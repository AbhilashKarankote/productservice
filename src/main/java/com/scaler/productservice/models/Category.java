package com.scaler.productservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel {

    private String name;
    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Product> products;
    String description;
}
