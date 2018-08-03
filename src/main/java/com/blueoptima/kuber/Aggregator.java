package com.blueoptima.kuber;

import java.util.List;

public interface Aggregator {
    CurrencyRate aggregate(List<CurrencyRate> currencyRates);
}
