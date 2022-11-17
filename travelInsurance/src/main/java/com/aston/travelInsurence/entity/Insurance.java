package com.aston.travelInsurence.entity;

import com.aston.travelInsurence.annotation.DateNotNullIfShortTerm;
import com.aston.travelInsurence.entity.enums.AdditionalInsuranceType;
import com.aston.travelInsurence.entity.enums.LifeSpanType;
import com.aston.travelInsurence.entity.enums.PackageType;
import com.aston.travelInsurence.entity.util.DateProcessor;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@DateNotNullIfShortTerm
@Table(name = "insurance")
public class Insurance implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false)
    private Long id;

    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateProcessor.DATE_FORMAT)
    @Column(name = "CREATED_AT",insertable = false, updatable = false)
    @DateTimeFormat(pattern = DateProcessor.DATE_FORMAT)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "life_span_type")
    private LifeSpanType lifeSpanType;

    @Enumerated(EnumType.STRING)
    @Column(name = "package_type")
    private PackageType packageType;

    @Nullable
    @ElementCollection(targetClass = AdditionalInsuranceType.class)
    @CollectionTable(
            name="additional_insurance",
            joinColumns=@JoinColumn(name="insurance_id")
    )
    @Enumerated(EnumType.STRING)
    @Column(name = "additional_insurance")
    private List<AdditionalInsuranceType> additionalInsurance;

    @NotNull
    @Column(name = "from_date", nullable = false)
    private LocalDate fromDate;

    @Nullable
    @Column(name = "due_date")
    private LocalDate toDate;

    @Column(name = "price")
    private Long price;

    @Column
    @Min(value = 1)
    @Max(value = 3)
    private Integer persons;
}
