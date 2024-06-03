package org.example.rates.dto.currency;

import lombok.Data;
import org.example.rates.model.Currency;

import java.util.ArrayList;
import java.util.List;

@Data
public class CurrencyListResponse {

    private List<Currency> currencyList = new ArrayList<>();

}
