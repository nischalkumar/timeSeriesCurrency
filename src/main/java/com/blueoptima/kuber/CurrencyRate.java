package com.blueoptima.kuber;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class CurrencyRate {
    Currency currency;
    double baseValue;
}
