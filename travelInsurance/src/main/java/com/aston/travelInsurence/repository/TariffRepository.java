package com.aston.travelInsurence.repository;

import com.aston.travelInsurence.entity.Tariff;
import com.aston.travelInsurence.entity.enums.LifeSpanType;
import com.aston.travelInsurence.entity.enums.PackageType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TariffRepository extends JpaRepository<Tariff, Long> {

    @Query("select t.price from Tariff t where t.packageType = :packageType and t.lifeSpanType = :lifeSpanType")
    Optional<Long> getPriceByPackageTypeAndLifeSpanType(PackageType packageType, LifeSpanType lifeSpanType);
}
