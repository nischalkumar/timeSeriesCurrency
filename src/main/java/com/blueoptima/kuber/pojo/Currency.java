package com.blueoptima.kuber.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Currency {
    rupee(1, "india", "rupee"),
    dollar(2, "usa", "dollar"),
    euro(3, "europe", "euro");
    private final int id;
    private final String country;
    private final String name;
}
