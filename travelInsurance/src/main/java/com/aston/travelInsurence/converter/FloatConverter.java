package com.aston.travelInsurence.converter;

import org.springframework.stereotype.Component;

@Component
public class FloatConverter {
    public Float convert(Integer integer) {
        return Float.valueOf(integer);
    }
}
