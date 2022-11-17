package com.aston.travelInsurence.entity.enums;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum PackageType {
    BASIC("základný"),
    EXTENDED("rozšírený"),
    EXTRA("extra");

    private String title;

    PackageType(String title) {
        this.title = title;
    }

    @JsonValue
    public String getTitle() {
        return title;
    }

    public static PackageType of(String title) {
        return Stream.of(PackageType.values())
                .filter(p -> p.getTitle().equals(title))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
