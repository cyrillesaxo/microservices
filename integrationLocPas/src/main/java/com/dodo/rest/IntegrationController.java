package com.dodo.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dodo.integration.IntegrationClient;
import com.dodo.model.Integration;
import com.dodo.model.Location;
import com.dodo.model.Passenger;

@RestController
public class IntegrationController {
	private final IntegrationClient integrationClient;

	public IntegrationController(IntegrationClient integrationClient) {
		this.integrationClient = integrationClient;
	}

	@RequestMapping("/{id}/{latitude}/{longitude}/integration")
	Integration integration(@PathVariable("id") String id, @PathVariable("latitude") String latitude, @PathVariable("longitude") String longitude) {
		System.out.println("####################  ORCHESTRATION ###########################");
		return new Integration(id,  this.integrationClient.getLocations(latitude, longitude), this.integrationClient.getPassengers(id));
	}  
}
