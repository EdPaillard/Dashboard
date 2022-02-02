package com.hachehorde.api.widget;

public interface CurrencyConverter {
    public float convert(String currencyFrom, String currencyTo) throws Exception;
}