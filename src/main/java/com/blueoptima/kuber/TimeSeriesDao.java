package com.blueoptima.kuber;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;

public interface TimeSeriesDao {
//    double convert(Currency from, Currency to, long utc);
//    void persist(CurrencyRate currencyRate);
//    void persist(List<CurrencyRate> currencyRates);
//    List<CurrencyRate> getAllCurrencyRates(long utc);

    //Map<Long, List<Currency>>
    //denomotization
    //weaker
    //stronger

    List<CurrencyRate> getCurrencies(long utc);
    NavigableMap<Long, List<CurrencyRate>> getCurrencyInRange(long startTime, long endTime);
    //scrollable
    Map<Long, CurrencyRate> getParticularCurrencyInRange(String id, long startTime, long endTime);
    int persist(long utc, List<CurrencyRate> currencies);


}
