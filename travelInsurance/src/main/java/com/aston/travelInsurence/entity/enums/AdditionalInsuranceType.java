package com.aston.travelInsurence.entity.enums;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum AdditionalInsuranceType {
    TRIP_CANCELLATION("storno cesty"),
    SPORT_ACTIVITIES("športové aktivity");

    private String title;

    AdditionalInsuranceType(String title) {
        this.title = title;
    }
    @JsonValue
    public String getTitle() {
        return title;
    }

    public static AdditionalInsuranceType of(String title) {
        return Stream.of(AdditionalInsuranceType.values())
                .filter(p -> p.getTitle().equals(title))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
