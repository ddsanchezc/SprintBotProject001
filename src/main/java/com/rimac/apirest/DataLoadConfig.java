package com.rimac.apirest;

import com.rimac.apirest.model.Currency;
import com.rimac.apirest.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoadConfig {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Bean
    public CommandLineRunner initData() {
        return args -> {
            // Precargar datos JSON
            loadCurrencyData("PEN", "1");
            loadCurrencyData("USD", "3.70");
        };
    }

    private void loadCurrencyData(String ncurrency, String nexchange) {
        Currency currency = new Currency();
        currency.setNcurrency(ncurrency);
        currency.setNexchange(nexchange);
        currencyRepository.save(currency);
    }
}
