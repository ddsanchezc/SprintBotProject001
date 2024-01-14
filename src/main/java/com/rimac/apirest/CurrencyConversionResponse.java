package com.rimac.apirest;
import lombok.Data;

@Data
public class CurrencyConversionResponse {

    private Double namount;
    private Double namountEnd;
    private String ncurrencyOri;
    private String ncurrencyEnd;
    private Double nexchange;

    public CurrencyConversionResponse(Double namount, String format, String ncurrencyOri, String ncurrencyEnd, String nexchange) {
    }

    public Double getNamount() {
        return namount;
    }

    public void setNamount(Double namount) {
        this.namount = namount;
    }

    public Double getNamountEnd() {
        return namountEnd;
    }

    public void setNamountEnd(Double namountEnd) {
        this.namountEnd = namountEnd;
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

    public Double getNexchange() {
        return nexchange;
    }

    public void setNexchange(Double nexchange) {
        this.nexchange = nexchange;
    }

    public CurrencyConversionResponse(Double namount, Double namountEnd, String ncurrencyOri, String ncurrencyEnd, Double nexchange) {
        this.namount = namount;
        this.namountEnd = namountEnd;
        this.ncurrencyOri = ncurrencyOri;
        this.ncurrencyEnd = ncurrencyEnd;
        this.nexchange = nexchange;
    }

}
