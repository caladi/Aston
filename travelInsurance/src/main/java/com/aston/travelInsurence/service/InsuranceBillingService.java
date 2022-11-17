package com.aston.travelInsurence.service;

import com.aston.travelInsurence.entity.Insurance;
import com.aston.travelInsurence.entity.dto.InsuranceView;
import com.aston.travelInsurence.entity.enums.AdditionalInsuranceType;
import com.aston.travelInsurence.entity.enums.LifeSpanType;
import com.aston.travelInsurence.repository.InsuranceRepository;
import com.aston.travelInsurence.repository.TariffRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;


@Service
public class InsuranceBillingService {

    private static final Logger log = LoggerFactory.getLogger(InsuranceBillingService.class);

    @Autowired
    private InsuranceRepository insuranceRepository;
    @Autowired
    private TariffRepository tariffRepository;

    @Autowired
    private Map<Pair<AdditionalInsuranceType, LifeSpanType>, Integer> additionalInsuranceTariffs;

    public List<InsuranceView> findAllInsuranceRecords() {
        return this.insuranceRepository.findAllInsuranceBy();
    }
    public InsuranceView saveInsuranceRecord(Insurance insurance) {
        insurance.setPrice(getPrice(insurance));
        Insurance entity = this.insuranceRepository.save(insurance);
        return this.insuranceRepository.findInsuranceById(entity.getId()).orElseThrow();
    }

    private Long getPrice(Insurance insurance) {
        BigDecimal basePrice = new BigDecimal(0).setScale(2, RoundingMode.HALF_UP);
        final long packageTypePrice = this.tariffRepository
                .getPriceByPackageTypeAndLifeSpanType(insurance.getPackageType(), insurance.getLifeSpanType())
                .orElseThrow();
        if (insurance.getLifeSpanType().equals(LifeSpanType.ANNUAL)) {
            basePrice = basePrice.add(BigDecimal.valueOf(packageTypePrice));
        } else {
            final long numberOfDays = ChronoUnit.DAYS.between(insurance.getFromDate(), insurance.getToDate()) + 1;
            basePrice = basePrice.add(BigDecimal.valueOf(packageTypePrice * numberOfDays));
        }
        long temp = basePrice.longValue();
        if (insurance.getAdditionalInsurance() != null && !insurance.getAdditionalInsurance().isEmpty()) {
            for (AdditionalInsuranceType additionalInsurance : insurance.getAdditionalInsurance()) {
                final int percentage = additionalInsuranceTariffs.get(Pair.of(additionalInsurance,
                    insurance.getLifeSpanType()));
                basePrice = basePrice.add(BigDecimal.valueOf(temp * (float) percentage /100));
            }
        }
        return basePrice.multiply(BigDecimal.valueOf(insurance.getPersons())).longValue();
    }
}
