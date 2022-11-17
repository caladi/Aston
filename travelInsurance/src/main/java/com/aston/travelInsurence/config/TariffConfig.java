package com.aston.travelInsurence.config;

import com.aston.travelInsurence.entity.enums.AdditionalInsuranceType;
import com.aston.travelInsurence.entity.enums.LifeSpanType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.util.Pair;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class TariffConfig {
    @Value("${tariff.trip-cancellation.short-term}")
    private Integer tripCancellationShortTerm;

    @Value("${tariff.trip-cancellation.annual}")
    private Integer tripCancellationAnnual;

    @Value("${tariff.sport-activities.short-term}")
    private Integer sportActivitiesShortTerm;

    @Value("${tariff.sport-activities.annual}")
    private Integer sportActivitiesAnnual;

    @Bean
    public Map<Pair<AdditionalInsuranceType, LifeSpanType>, Integer> additionalInsuranceTariffs() {
        Map<Pair<AdditionalInsuranceType, LifeSpanType>, Integer> tariffs = new HashMap<>();
        tariffs.put(Pair.of(AdditionalInsuranceType.TRIP_CANCELLATION, LifeSpanType.SHORT_TERM), tripCancellationShortTerm);
        tariffs.put(Pair.of(AdditionalInsuranceType.TRIP_CANCELLATION, LifeSpanType.ANNUAL), tripCancellationAnnual);
        tariffs.put(Pair.of(AdditionalInsuranceType.SPORT_ACTIVITIES, LifeSpanType.SHORT_TERM), sportActivitiesShortTerm);
        tariffs.put(Pair.of(AdditionalInsuranceType.SPORT_ACTIVITIES, LifeSpanType.ANNUAL), sportActivitiesAnnual);
        return tariffs;
    }
}
