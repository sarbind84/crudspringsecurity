package com.example.interview.domain;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "product1")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;
    @Column(name = "name")
    public String name;
    @Column(name = "description")
    public String desc;
    @Column(name = "price")
    public Double price;
    @Column(name = "category")
    public String category;

}
