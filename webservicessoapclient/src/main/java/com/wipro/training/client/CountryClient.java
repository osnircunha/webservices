package com.wipro.training.client;

import com.wipro.training.wsdl.GetCountryRequest;
import com.wipro.training.wsdl.GetCountryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

/**
 * Created by Osnir Cunha on 09-May-18.
 */
public class CountryClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(CountryClient.class);
    private static final String COUNTRY_WS_ENDPOINT = "http://localhost:8080/ws/country";

    public GetCountryResponse getCountry(String name) {

        GetCountryRequest request = new GetCountryRequest();
        request.setName(name);

        log.info("Requesting country " + name);

        GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate()
                .marshalSendAndReceive(COUNTRY_WS_ENDPOINT, request, new SoapActionCallback("http://localhost:8080/ws/countries.wsdl"));

        return response;
    }
}
