package com.wipro.training;

import com.wipro.training.client.CountryClient;
import com.wipro.training.wsdl.GetCountryResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebervicessopaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebervicessopaClientApplication.class, args);
	}

    @Bean
    CommandLineRunner lookup(CountryClient countryClient) {
        return args -> {
            String name = "Poland";

            if (args.length > 0) {
                name = args[0];
            }
            GetCountryResponse response = countryClient.getCountry(name);
            System.err.println(response.getCountry().getName());
            System.err.println(response.getCountry().getCapital());
            System.err.println(response.getCountry().getCurrency());
            System.err.println(response.getCountry().getPopulation());
        };
    }
}
