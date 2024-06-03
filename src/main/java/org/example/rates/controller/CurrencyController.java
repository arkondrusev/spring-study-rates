package org.example.rates.controller;

import org.example.rates.dto.currency.CreateCurrencyRequest;
import org.example.rates.dto.currency.CurrencyListResponse;
import org.example.rates.dto.currency.DeleteCurrencyRequest;
import org.example.rates.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CurrencyController {

    @Autowired
    CurrencyService currencyService;

    @GetMapping("getCurrencyList")
    public CurrencyListResponse getCurrencyList() {
        return currencyService.getCurrencyList();
    }

    @PostMapping("addCurrency")
    public void addCurrency(@RequestBody CreateCurrencyRequest request) {
        currencyService.addCurrency(request);
    }

    @PostMapping("delCurrency")
    public void delCurrency(@RequestBody DeleteCurrencyRequest request) {
        currencyService.removeCurrency(request);
    }

}
