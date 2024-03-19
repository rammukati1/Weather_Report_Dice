package io.springsecurityjwt.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.net.URI;
import java.net.URISyntaxException;

@Service
public class WeatherService {

	private final RestTemplate restTemplate;

	public WeatherService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public String getForecastSummary(String locationName) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-RapidAPI-Key", "bcf9ca6850msh9a41c75c24b92c0p1b44dbjsn73d06d585ecb");
		headers.set("X-RapidAPI-Host", "forecast9.p.rapidapi.com");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + locationName);
		RequestEntity<Void> requestEntity;
		try {
			requestEntity = new RequestEntity<>(headers, HttpMethod.GET,
					new URI("https://forecast9.p.rapidapi.com/rapidapi/forecast/"+locationName+"/summary/"));
		} catch (URISyntaxException e) {
			// Handle URI syntax exception
			// handle location exceptions
			return null;
		}

		ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);
		return responseEntity.getBody();
	}

	public String getForecastSummaryHourly(String locationName) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-RapidAPI-Key", "bcf9ca6850msh9a41c75c24b92c0p1b44dbjsn73d06d585ecb");
		headers.set("X-RapidAPI-Host", "forecast9.p.rapidapi.com");
		RequestEntity<Void> requestEntity;
		System.out.println("https://forecast9.p.rapidapi.com/rapidapi/forecast/"+locationName+"/hourly/");
		try {
			requestEntity = new RequestEntity<>(headers, HttpMethod.GET,
					new URI("https://forecast9.p.rapidapi.com/rapidapi/forecast/"+locationName+"/hourly/"));
		} catch (URISyntaxException e) {
			// Handle URI syntax exception
			return null;
		}

		ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);
		return responseEntity.getBody();
	}
}
