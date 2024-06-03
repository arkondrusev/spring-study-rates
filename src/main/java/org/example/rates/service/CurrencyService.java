package org.example.rates.service;

import org.example.rates.dto.currency.CreateCurrencyRequest;
import org.example.rates.dto.currency.CurrencyListResponse;
import org.example.rates.dto.currency.DeleteCurrencyRequest;
import org.example.rates.model.Currency;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CurrencyService {

    private List<Currency> currencyList = new ArrayList<>();

    public CurrencyListResponse getCurrencyList() {
        CurrencyListResponse response = new CurrencyListResponse();
        for (Currency currency : currencyList) {
            response.getCurrencyList().add(currency);
        }
        return response;
    }

    public void addCurrency(CreateCurrencyRequest request) {
        currencyList.add(new Currency(request.getCurrencyName(), request.getCurrencySymbol()));
    }

    public void removeCurrency(DeleteCurrencyRequest request) {
        Currency foundCurrency = currencyList.stream()
                .filter(cur -> cur.getSymbol().equals(request.getCurrencySymbol()))
                .findFirst().get();
        currencyList.remove(foundCurrency);
    }

}
