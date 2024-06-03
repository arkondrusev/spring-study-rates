package org.example.rates.service;

import org.example.rates.dto.currency.CreateCurrencyRequest;
import org.example.rates.dto.currency.DeleteCurrencyRequest;
import org.example.rates.model.Currency;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        CurrencyService.class
})
public class CurrencyServiceTest {

    @Autowired
    private CurrencyService currencyService;

    @Test
    @Order(1)
    void addCurrency_success() {
        // prepare request and expected currency
        CreateCurrencyRequest request = new CreateCurrencyRequest("Ruble", "RUR");
        Currency expectedCurrency = new Currency("Ruble", "RUR");

        // check currency doesn't exist before call
        Optional<Currency> foundCurrency = currencyService.getCurrencyList().getCurrencyList().stream()
                .filter(cur -> cur.getSymbol().equals(request.getCurrencySymbol())
                        && cur.getName().equals(request.getCurrencyName())).findFirst();
        Assertions.assertTrue(foundCurrency.isEmpty());

        //call
        currencyService.addCurrency(request);

        // check currency exists after call
        foundCurrency = currencyService.getCurrencyList().getCurrencyList().stream()
                .filter(cur -> cur.getSymbol().equals(request.getCurrencySymbol())
                        && cur.getName().equals(request.getCurrencyName())).findFirst();
        Assertions.assertTrue(foundCurrency.isPresent());
        Assertions.assertEquals(expectedCurrency, foundCurrency.get());
    }

    @Test
    @Order(2)
    void delCurrency_success() {
        // prepare request
        DeleteCurrencyRequest request = new DeleteCurrencyRequest("RUR");

        // check currency exists before call
        Optional<Currency> foundCurrency = currencyService.getCurrencyList().getCurrencyList().stream()
                .filter(cur -> cur.getSymbol().equals(request.getCurrencySymbol())).findFirst();
        Assertions.assertTrue(foundCurrency.isPresent());

        // call
        currencyService.removeCurrency(request);

        // check currency absent after call
        foundCurrency = currencyService.getCurrencyList().getCurrencyList().stream()
                .filter(cur -> cur.getSymbol().equals(request.getCurrencySymbol())).findFirst();
        Assertions.assertTrue(foundCurrency.isEmpty());
    }

}
