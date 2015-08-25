package com.ucm.ilsa.clavinweb.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.bericotech.clavin.ClavinException;
import com.bericotech.clavin.GeoParser;
import com.bericotech.clavin.GeoParserFactory;
import com.bericotech.clavin.extractor.AlphaExtractor;
import com.bericotech.clavin.resolver.ResolvedLocation;

@Component
public class GeoParserService {
	private GeoParser parser;
	private final static Logger LOGGER = Logger
			.getLogger(GeoParserService.class);
	
	public GeoParserService() throws ClavinException {
		ClassLoader classLoader = getClass().getClassLoader();
		String path = classLoader.getResource("IndexDirectory").getFile();
		path = path.replaceAll("%20", " ");
		parser = GeoParserFactory.getDefault(path, new AlphaExtractor(), 50,
				15, false);
		LOGGER.info("Indice CLAVIN-MOD: ".concat(path));
		LOGGER.info("GeoParser ".concat(parser != null ? "Iniciado"
				: "No iniciado"));
	}
	
	public List<ResolvedLocation> parser(String text) throws Exception {
		return this.parser.parse(text);
	}
}
