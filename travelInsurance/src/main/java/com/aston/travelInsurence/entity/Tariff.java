package com.aston.travelInsurence.entity;

import com.aston.travelInsurence.entity.enums.LifeSpanType;
import com.aston.travelInsurence.entity.enums.PackageType;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tariff")
@IdClass(TariffCompositeKey.class)
public class Tariff {

    @Id
    @Column(name = "package_type")
    @Enumerated(EnumType.STRING)
    private PackageType packageType;

    @Id
    @Column(name = "life_span_type")
    @Enumerated(EnumType.STRING)
    private LifeSpanType lifeSpanType;

    @Column(name = "price")
    private Long price;

}
class TariffCompositeKey implements Serializable {
    private PackageType packageType;
    private LifeSpanType lifeSpanType;
}
