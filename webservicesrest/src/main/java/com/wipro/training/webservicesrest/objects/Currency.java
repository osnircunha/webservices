package com.wipro.training.webservicesrest.objects;

/**
 * Created by Osnir Cunha on 07-May-18.
 */
public enum Currency {

    GBP,
    EUR,
    PLN;

    public String value() {
        return name();
    }

    public static Currency fromValue(String v) {
        return valueOf(v);
    }
}
