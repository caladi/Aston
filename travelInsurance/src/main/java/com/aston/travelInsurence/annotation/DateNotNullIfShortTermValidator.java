package com.aston.travelInsurence.annotation;

import com.aston.travelInsurence.entity.Insurance;
import com.aston.travelInsurence.entity.enums.LifeSpanType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateNotNullIfShortTermValidator implements ConstraintValidator<DateNotNullIfShortTerm, Insurance> {

    private static final Logger log = LoggerFactory.getLogger(DateNotNullIfShortTerm.class);

    @Override
    public void initialize(DateNotNullIfShortTerm arg0) { }

    @Override
    public boolean isValid(Insurance insurance, ConstraintValidatorContext ctx) {
        return (insurance.getLifeSpanType().equals(LifeSpanType.ANNUAL) ||
                insurance.getLifeSpanType().equals(LifeSpanType.SHORT_TERM) && insurance.getToDate() != null);
    }
}
