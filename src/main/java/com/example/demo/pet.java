package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;
import lombok.Data;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor



public @Data class pet {
    public UUID id = UUID.randomUUID();
    private String type;
    private String name;
    private String gender;
    private double price;

    //GETTER & SETTER
    public String getName() {
        return name;
    }
    public String getType(){
        return type;
    }
    public String getGender(){
        return gender;
    }
    public Double getPrice(){
        return price;
    }
    public void setId(String id) {
        this.id = UUID.fromString(id);
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
}
