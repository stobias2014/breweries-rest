package com.tobias.saul.beerrest.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/breweries")
public class BreweryWebService {

	private final static String BASE_URL = "https://api.openbrewerydb.org/breweries";

	private final RestTemplate restTemplate;

	public BreweryWebService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@GetMapping
	public List getBreweries() {
		System.out.println("inside getbreweries");
		List breweries = restTemplate.getForEntity(BASE_URL, ArrayList.class).getBody();
		System.out.println(breweries);
		
		return breweries;
	}

}
