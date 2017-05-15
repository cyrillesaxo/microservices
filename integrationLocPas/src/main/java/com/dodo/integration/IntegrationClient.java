package com.dodo.integration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.stereotype.Component;

import com.dodo.client.LocationClient;
import com.dodo.client.PassengerClient;
import com.dodo.model.Geocoding;
import com.dodo.model.Location;
import com.dodo.model.Passenger;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class IntegrationClient {

	private final LocationClient locationClient;

	private final PassengerClient passengerClient;

	public IntegrationClient(LocationClient LocationClient, PassengerClient passengerClient) {
		this.locationClient = LocationClient;
		this.passengerClient = passengerClient;
	}

	public Collection<Geocoding> getLocationsFallback(String latitude, String longitude) {
		System.out.println("getLocationFallback");
		return Arrays.asList();
	}

	@HystrixCommand(fallbackMethod = "getLocationsFallback")
	public Collection<Geocoding> getLocations(String latitude, String longitude) {
		System.out.println("########## calling hyxtrixcommand getLocations ###################");
		Collection<Geocoding> col = new ArrayList<Geocoding>();
		System.out.println("######"+this.locationClient.getLocations(latitude, longitude));
		col.add(this.locationClient.getLocations(latitude, longitude));
		return col;
	}

	public Collection<Passenger> getPassengersFallback(String userId) {
		System.out.println("getPassengerFallback");
		return Arrays.asList();
	}

	@HystrixCommand(fallbackMethod = "getPassengersFallback")
	public Collection<Passenger> getPassengers(String userId) {
		return this.passengerClient.getPassengers(userId);
	}

}
