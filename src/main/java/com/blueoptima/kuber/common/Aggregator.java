package com.blueoptima.kuber.common;

import com.blueoptima.kuber.pojo.CurrencyRate;

import java.util.Collection;

public interface Aggregator {
    CurrencyRate aggregate(Collection<CurrencyRate> currencyRates);
}
