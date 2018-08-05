package com.blueoptima.kuber;

import com.blueoptima.kuber.pojo.CurrencyRate;

import java.util.List;
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
    NavigableMap<Long, CurrencyRate> getParticularCurrencyInRange(int id, long startTime, long endTime);

    int persist(long utc, List<CurrencyRate> currencies);


}
