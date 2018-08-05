package com.blueoptima.kuber.pojo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CrawlRequest {
    private final long startTime;
    private final long endTime;
}
