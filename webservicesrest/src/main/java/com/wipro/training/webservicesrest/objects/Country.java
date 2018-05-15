package com.wipro.training.webservicesrest.objects;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Osnir Cunha on 07-May-18.
 */
@Data
@Entity
public class Country {

    @Id
    private String name;
    private String capital;
    private Currency currency;
    private Integer population;

}
