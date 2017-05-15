package com.dodo.client;

import java.util.Collection;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.dodo.model.*;

@FeignClient("passenger-service")
public interface PassengerClient {

	@RequestMapping(method = RequestMethod.GET, value = "/{id}/passengers")
	Collection<Passenger> getPassengers(@PathVariable("id") String id);

}
