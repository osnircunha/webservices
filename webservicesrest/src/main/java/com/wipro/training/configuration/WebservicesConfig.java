package com.wipro.training.configuration;

import com.wipro.training.repositories.CountryRepository;
import com.wipro.training.webservicesrest.objects.Country;
import com.wipro.training.webservicesrest.objects.Currency;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Osnir Cunha on 08-May-18.
 */
@Configuration
public class WebservicesConfig {

    @Bean
    public CommandLineRunner loadData(CountryRepository repository) {
        return (args) -> {
            Country spain = new Country();
            spain.setName("Spain");
            spain.setCapital("Madrid");
            spain.setCurrency(Currency.EUR);
            spain.setPopulation(46704314);

            Country poland = new Country();
            poland.setName("Poland");
            poland.setCapital("Warsaw");
            poland.setCurrency(Currency.PLN);
            poland.setPopulation(38186860);

            Country uk = new Country();
            uk.setName("United Kingdom");
            uk.setCapital("London");
            uk.setCurrency(Currency.GBP);
            uk.setPopulation(63705000);

            repository.save(spain);
            repository.save(poland);
            repository.save(uk);
        };
    }
}
