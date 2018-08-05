package com.blueoptima.kuber;

public class Converter {
    public final double BASE_FINAL_VALUE = 100.000;

    public double convert(CurrencyRate fromCurrencyRate, CurrencyRate toCurrencyRate) {
        return (BASE_FINAL_VALUE / fromCurrencyRate.baseValue) * toCurrencyRate.baseValue;
    }
}
