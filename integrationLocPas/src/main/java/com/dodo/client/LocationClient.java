package com.dodo.client;

import java.util.Collection;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.dodo.model.*;
import com.dodo.security.FeignClientConfiguration;


@FeignClient(name="location", configuration = FeignClientConfiguration.class)
//@FeignClient(name="LOCATION")
//@FeignClient(name="location",url = "${location_url}")
//@FeignClient(name="location",url = "http://localhost:8080")
//@FeignClient(name="location",url = "http://localhost:8080", path="/Location/api")
public interface LocationClient {
	
	@RequestMapping(method = RequestMethod.GET, value = "/Location/api/location/latitude/{latitude}/longitude/{longitude} ")
	Geocoding getLocations(@PathVariable("latitude") String latitude, @PathVariable("longitude") String longitude);

}
