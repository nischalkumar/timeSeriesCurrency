package com.blueoptima.kuber.common;

import com.blueoptima.kuber.pojo.Currency;
import com.blueoptima.kuber.pojo.CurrencyRate;

import java.util.Collection;

public class AvgAggregator implements Aggregator{
    @Override
    public CurrencyRate aggregate(Collection<CurrencyRate> currencyRates) {
        double sum=0;
        Currency currency = null;
        for(CurrencyRate currencyRate : currencyRates) {
            sum+=currencyRate.getBaseValue();
            currency=currencyRate.getCurrency();
        }
        double rate = sum/currencyRates.size();
        return new CurrencyRate(currency, rate);
    }
}
