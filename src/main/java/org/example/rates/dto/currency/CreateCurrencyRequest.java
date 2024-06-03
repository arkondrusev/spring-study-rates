package org.example.rates.dto.currency;

import lombok.Data;

@Data
public class CreateCurrencyRequest {

    private final String currencyName;
    private final String currencySymbol;

}
