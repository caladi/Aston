package com.aston.travelInsurence.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {DateNotNullIfShortTermValidator.class})
public @interface DateNotNullIfShortTerm {
    String message() default " For short-term insurance ToDate must be present";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
