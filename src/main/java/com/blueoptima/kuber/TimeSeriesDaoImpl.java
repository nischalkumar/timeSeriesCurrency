package com.blueoptima.kuber;

import com.blueoptima.kuber.TimeSeriesDao;
import com.blueoptima.kuber.pojo.CurrencyRate;

import java.util.*;
import java.util.stream.Collectors;

public class TimeSeriesDaoImpl implements TimeSeriesDao {
    private final TreeMap<Long, List<CurrencyRate>> treeMap;

    public TimeSeriesDaoImpl() {
        this.treeMap = new TreeMap<>();
    }

    @Override
    public List<CurrencyRate> getCurrencies(long utc) {
        synchronized (this) {
            return treeMap.get(utc);
        }
    }

    @Override
    public NavigableMap<Long, List<CurrencyRate>> getCurrencyInRange(long startTime, long endTime) {
        synchronized (this) {
            NavigableMap<Long, List<CurrencyRate>> map = new TreeMap<>();
            for (Map.Entry<Long, List<CurrencyRate>> entry : treeMap.tailMap(startTime).entrySet()) {
                if (entry.getKey() <= endTime) {
                    map.put(entry.getKey(), entry.getValue());
                } else {
                    break;
                }
            }
            return map;
        }
    }

    @Override
    public NavigableMap<Long, CurrencyRate> getParticularCurrencyInRange(int id, long startTime, long endTime) {
        synchronized (this) {
            NavigableMap<Long, CurrencyRate> map = new TreeMap<>();
            for (Map.Entry<Long, List<CurrencyRate>> entry : treeMap.tailMap(startTime).entrySet()) {
                if (entry.getKey() <= endTime) {
                    for (CurrencyRate currencyRate : entry.getValue()) {
                        if(currencyRate.getCurrency().getId()==id){
                            map.put(entry.getKey(), currencyRate);
                        }
                    }
                } else {
                    break;
                }
            }
            return map;
        }
    }

    @Override
    public int persist(long utc, List<CurrencyRate> currencies) {
        synchronized (this) {
            List<CurrencyRate> currencyRates = treeMap.getOrDefault(utc, new ArrayList<>());
            currencyRates.addAll(currencies);
            treeMap.put(utc, currencyRates);
        }
        return currencies.size();
    }
}
