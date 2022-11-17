package com.aston.travelInsurence.repository;

import com.aston.travelInsurence.entity.Insurance;
import com.aston.travelInsurence.entity.dto.InsuranceView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
    List<InsuranceView> findAllInsuranceBy();

    Optional<InsuranceView> findInsuranceById(Long id);

}
