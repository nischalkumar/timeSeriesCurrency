package com.blueoptima.kuber.common;

import com.blueoptima.kuber.pojo.CurrencyRate;

public class Converter {
    public final double BASE_FINAL_VALUE = 1.000;

    public double convert(CurrencyRate fromCurrencyRate, CurrencyRate toCurrencyRate) {
        return (BASE_FINAL_VALUE / fromCurrencyRate.getBaseValue()) * toCurrencyRate.getBaseValue();
    }
}
