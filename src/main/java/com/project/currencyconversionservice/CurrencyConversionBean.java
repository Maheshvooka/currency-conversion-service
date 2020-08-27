package com.project.currencyconversionservice;

import java.math.BigDecimal;

public class CurrencyConversionBean {
    private String from;
    private String to;
    private BigDecimal conversionRate;
    private String port;
    private int amount;
    private BigDecimal conversionValue;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(BigDecimal conversionRate) {
        this.conversionRate = conversionRate;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public BigDecimal getConversionValue() {
        return conversionValue;
    }

    public void setConversionValue(BigDecimal conversionValue) {
        this.conversionValue = conversionValue;
    }
}
