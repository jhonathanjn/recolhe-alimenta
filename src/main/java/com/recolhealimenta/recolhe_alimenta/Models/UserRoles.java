package com.recolhealimenta.recolhe_alimenta.Models;

public enum UserRoles {
    ADMIN("admin"),
    ONG("ong"),
    EMPLOYEE("employee");

    private String role;

    UserRoles(String role){
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
