package com.rimac.apirest;

import com.rimac.apirest.model.Currency;
import com.rimac.apirest.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CurrencyService {
    @Autowired
    private CurrencyRepository currencyRepository;

    public Currency createCurrency(Currency currency){
        return currencyRepository.save(currency);
    }

    public Currency getCurrencyById(Long id){
        Optional<Currency> optionalUser = currencyRepository.findById(id);
        return optionalUser.get();
    }

    public List<Currency> getAllCurrency(){
        return currencyRepository.findAll();
    }

    public void deleteCurrency(Long id){
        currencyRepository.deleteById(id);
    }

    public Currency getCurrencyByNcurrency(String ncurrency) {
        return currencyRepository.findByNcurrency(ncurrency);
    }
}
