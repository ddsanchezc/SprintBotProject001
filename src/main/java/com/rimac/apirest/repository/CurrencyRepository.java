package com.rimac.apirest.repository;

import com.rimac.apirest.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency,Long> {
    Currency findByNcurrency(String ncurrency);
}
