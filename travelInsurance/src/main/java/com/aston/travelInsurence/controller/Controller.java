package com.aston.travelInsurence.controller;

import com.aston.travelInsurence.entity.Insurance;
import com.aston.travelInsurence.entity.dto.InsuranceView;
import com.aston.travelInsurence.entity.enums.AdditionalInsuranceType;
import com.aston.travelInsurence.entity.enums.LifeSpanType;
import com.aston.travelInsurence.entity.enums.PackageType;
import com.aston.travelInsurence.service.InsuranceBillingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
public class Controller {

    private static final Logger log = LoggerFactory.getLogger(Controller.class);

    @Autowired
    InsuranceBillingService insuranceBillingService;

    @GetMapping("/")
    public List<InsuranceView> getInsurances() {
        return this.insuranceBillingService.findAllInsuranceRecords();
    }

    @GetMapping("/additional-insurances")
    public Set<AdditionalInsuranceType> getAdditionalInsurances() {
        return Set.of(AdditionalInsuranceType.values());
    }

    @GetMapping("/life-span-types")
    public Set<LifeSpanType> getLifeSpanTypes() {
        return Set.of(LifeSpanType.values());
    }

    @GetMapping("/package-types")
    public Set<PackageType> getPackageType() {
        return Set.of(PackageType.values());
    }

    @PostMapping("/")
    public InsuranceView saveInsurance(@Valid @RequestBody Insurance insurance) {
        return this.insuranceBillingService.saveInsuranceRecord(insurance);
    }
}
