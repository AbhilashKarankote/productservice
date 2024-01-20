package com.scaler.productservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel {

    private String title;
    private Double price;
    private String description;
    private String imageUrl;
    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Category category;
}
