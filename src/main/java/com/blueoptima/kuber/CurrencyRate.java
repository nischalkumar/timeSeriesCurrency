package com.blueoptima.kuber;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CurrencyRate {
    Currency currency;
    double baseValue;
}
