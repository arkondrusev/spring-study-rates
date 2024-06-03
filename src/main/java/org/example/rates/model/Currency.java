package org.example.rates.model;

import lombok.Data;

@Data
public class Currency {

    private final String name;
    // RUR, USD, EUR
    private final String symbol;

}
