package com.wipro.training.services;

import com.wipro.training.repositories.CountryRepository;
import com.wipro.training.webservicesrest.objects.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Osnir Cunha on 07-May-18.
 */
@RestController
@RequestMapping("/api/country")
public class CountryServices {

    @Autowired
    private CountryRepository countryRepository;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/{countryName}")
    @ResponseStatus(value = HttpStatus.OK)
    public Country getCountry(@PathVariable("countryName") String countryName) {
        return this.countryRepository.findById(countryName).orElse(new Country());
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Iterable<Country> getCountry() {
        return this.countryRepository.findAll();
    }

}
