package com.rimac.apirest;

public class CurrencyUpdateRequest {
    private String ncurrency;
    private String nexchange;

    public String getNcurrency() {
        return ncurrency;
    }

    public void setNcurrency(String ncurrency) {
        this.ncurrency = ncurrency;
    }

    public String getNexchange() {
        return nexchange;
    }

    public void setNexchange(String nexchange) {
        this.nexchange = nexchange;
    }
}