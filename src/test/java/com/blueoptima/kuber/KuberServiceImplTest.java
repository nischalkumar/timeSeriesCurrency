package com.blueoptima.kuber;

import com.blueoptima.kuber.pojo.Currency;
import com.blueoptima.kuber.pojo.CurrencyRate;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class KuberServiceImplTest {
    KubserService kubserService;

    @Before
    public void init() {
        kubserService=new KuberServiceImpl();
    }

    @Test
    public void convert() {
        CurrencyRate currencyRate= new CurrencyRate(Currency.rupee,60);
    }
}