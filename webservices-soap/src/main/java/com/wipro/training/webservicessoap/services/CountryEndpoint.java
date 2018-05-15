package com.wipro.training.webservicessoap.services;

import com.wipro.training.webservicessoap.objects.GetCountryRequest;
import com.wipro.training.webservicessoap.objects.GetCountryResponse;
import com.wipro.training.webservicessoap.repositories.CountryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * Created by Osnir Cunha on 07-May-18.
 */
@Endpoint
public class CountryEndpoint {
    private static final String NAMESPACE_URI = "http://training.wipro.com/webservicessoap/objects";
    private static final Logger log = LoggerFactory.getLogger(CountryEndpoint.class);

    private CountryRepository countryRepository;

    @Autowired
    public CountryEndpoint(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        log.info("Requesting country " + request.getName());

        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countryRepository.findCountry(request.getName()));

        return response;
    }
}
