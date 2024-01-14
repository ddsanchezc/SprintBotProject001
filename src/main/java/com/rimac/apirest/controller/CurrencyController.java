package com.rimac.apirest.controller;

import com.rimac.apirest.CurrencyConversionRequest;
import com.rimac.apirest.CurrencyConversionResponse;
import com.rimac.apirest.CurrencyService;
import com.rimac.apirest.CurrencyUpdateRequest;
import com.rimac.apirest.model.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/currency")
public class CurrencyController {
    @Autowired
    private CurrencyService currencyService;
    public static final String LOCAL_CURRENCY = "PEN";

    @PostMapping
    public Currency createCurrency(@RequestBody Currency currency){
        return currencyService.createCurrency(currency);
    }

    @GetMapping
    public List<Currency> getAllCurrency(){
        return currencyService.getAllCurrency();
    }

    @GetMapping("{id}")
        public Currency SearchCurrencyById(@PathVariable("id") Long id) {
        return currencyService.getCurrencyById(id);
    }

    @DeleteMapping("{id}")
    public void deleteCurrencyById(@PathVariable("id") Long id){
        currencyService.deleteCurrency(id);
    }

    @GetMapping("/by-ncurrency/{ncurrency}")
    public Currency searchCurrencyByNcurrency(@PathVariable("ncurrency") String ncurrency) {
        return currencyService.getCurrencyByNcurrency(ncurrency);
    }

    @PutMapping("/update-currency") //actualizar valores (opcional)
    public ResponseEntity<?> updateCurrency(@RequestBody CurrencyUpdateRequest request) {
        try {
            String ncurrency = request.getNcurrency();
            Currency existingCurrency = currencyService.getCurrencyByNcurrency(ncurrency);

            if (existingCurrency == null) {
                return ResponseEntity.badRequest().body("Currency not found");
            }

            existingCurrency.setNexchange(request.getNexchange());
            currencyService.createCurrency(existingCurrency);

            return ResponseEntity.ok("Currency updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating currency");
        }
    }

    @PostMapping("/convert-currency")
    public ResponseEntity<?> convertCurrency(@RequestBody CurrencyConversionRequest request) {
        try {
            Currency originCurrency = currencyService.getCurrencyByNcurrency(request.getNcurrencyOri());
            Currency endCurrency = currencyService.getCurrencyByNcurrency(request.getNcurrencyEnd());


            if (originCurrency == null || endCurrency == null) {
                return ResponseEntity.badRequest().body("Invalid currency codes");
            }

            double nexchange = 0;
            double namount = request.getNamount();
            double namountEnd;

            if (namount == 0) {
                return ResponseEntity.badRequest().body("amount shoudn't be zero!");
            }

            if (LOCAL_CURRENCY.equals(request.getNcurrencyEnd())) {
                // Si la moneda de origen es local, se hace la conversión inversa
                nexchange = Double.parseDouble(originCurrency.getNexchange());
                namountEnd = namount / nexchange;
            } else {
                // En caso contrario, se realiza la conversión directa
                nexchange = Double.parseDouble(endCurrency.getNexchange());
                namountEnd = namount * nexchange;
            }

            CurrencyConversionResponse response = new CurrencyConversionResponse(
                    namount,
                    namountEnd,
                    request.getNcurrencyOri(),
                    request.getNcurrencyEnd(),
                    nexchange
            );

            return ResponseEntity.ok(response);
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("Invalid value!");
        }
    }
}
