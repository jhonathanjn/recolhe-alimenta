package com.recolhealimenta.recolhe_alimenta.Models;

public enum EnterpriseType {
    MERCADO("mercado"),
    RESTAURANTE("restaurante"),
    PRODUTOR("produtos"),
    ONG("ong");

    private String types;

    EnterpriseType(String types){
        this.types = types;
    }

    public String getRole() {
        return types;
    }
}
