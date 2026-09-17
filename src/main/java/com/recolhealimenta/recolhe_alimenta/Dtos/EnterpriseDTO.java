package com.recolhealimenta.recolhe_alimenta.Dtos;

import com.recolhealimenta.recolhe_alimenta.Models.EnterpriseType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnterpriseDTO {

    private String name;

    private String cnpj;

    @Enumerated(EnumType.STRING)
    private EnterpriseType type;

    private String address;
}
