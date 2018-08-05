package com.blueoptima.kuber.pojo;

import com.blueoptima.kuber.pojo.Currency;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CurrencyRate {
    Currency currency;
    double baseValue;
}
