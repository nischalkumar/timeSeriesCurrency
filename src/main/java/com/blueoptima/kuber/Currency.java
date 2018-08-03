package com.blueoptima.kuber;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Currency {
    private final int id;
    private final String country;
    private final String name;
}
