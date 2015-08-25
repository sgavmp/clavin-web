package com.ucm.ilsa.clavinweb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bericotech.clavin.resolver.ResolvedLocation;
import com.ucm.ilsa.clavinweb.service.GeoParserService;

@Controller
public class ClavinApi {
	
	@Autowired
	private GeoParserService geoparser;
	
	@RequestMapping(value="/parser", method=RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public List<ResolvedLocation> getLocationsFromText(String text, HttpServletRequest request, HttpServletResponse response) {
		List<ResolvedLocation> locationsAp = null;
		try {
			locationsAp = geoparser.parser(text);
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		return locationsAp;
	}
	
}
