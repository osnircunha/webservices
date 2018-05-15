package com.wipro.training.repositories;

import com.wipro.training.webservicesrest.objects.Country;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Osnir Cunha on 07-May-18.
 */
public interface CountryRepository extends CrudRepository<Country, String> {

}
