package com.blueoptima.kuber;

import java.util.Collection;

public interface Aggregator {
    CurrencyRate aggregate(Collection<CurrencyRate> currencyRates);
}
