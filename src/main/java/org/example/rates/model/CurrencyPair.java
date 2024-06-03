package org.example.rates.model;

import lombok.Data;

@Data
public class CurrencyPair {

    private final Currency baseCurrency;
    private final Currency quoteCurrency;

}
