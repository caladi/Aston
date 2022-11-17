package com.aston.travelInsurence.entity.enums;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum LifeSpanType {
    SHORT_TERM("krátkodobé poistenie"),
    ANNUAL("celoročné poistenie");

    private String title;

    LifeSpanType(String title) {
        this.title = title;
    }

    @JsonValue
    public String getTitle() {
        return title;
    }

    public static LifeSpanType of(String title) {
        return Stream.of(LifeSpanType.values())
                .filter(p -> p.getTitle().equals(title))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
