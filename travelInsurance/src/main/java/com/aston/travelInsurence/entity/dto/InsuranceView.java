package com.aston.travelInsurence.entity.dto;

import com.aston.travelInsurence.entity.enums.AdditionalInsuranceType;
import com.aston.travelInsurence.entity.enums.LifeSpanType;
import com.aston.travelInsurence.entity.enums.PackageType;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
import java.util.List;

public interface InsuranceView {
    LifeSpanType getLifeSpanType();
    PackageType getPackageType();
    List<AdditionalInsuranceType> getAdditionalInsurance();
    LocalDate getFromDate();
    LocalDate getToDate();
    @Value("#{@floatConverter.convert(target.price) / 100}")
    Float getPrice();
    Integer getPersons();
}
