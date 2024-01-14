package com.rimac.apirest;

import org.antlr.v4.runtime.misc.NotNull;

public class CurrencyConversionRequest {

    private Double namount;
    private String ncurrencyOri;
    private String ncurrencyEnd;

    public Double getNamount() {
        return namount;
    }

    public void setNamount(Double namount) {
        this.namount = namount;
    }

    public String getNcurrencyOri() {
        return ncurrencyOri;
    }

    public void setNcurrencyOri(String ncurrencyOri) {
        this.ncurrencyOri = ncurrencyOri;
    }

    public String getNcurrencyEnd() {
        return ncurrencyEnd;
    }

    public void setNcurrencyEnd(String ncurrencyEnd) {
        this.ncurrencyEnd = ncurrencyEnd;
    }

}
