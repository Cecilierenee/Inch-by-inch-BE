package com.inchbyinch.inchbyinchapi.model;


import javax.persistence.*;

@Entity
@Table(name = "routines")
public class Routine {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String steps;

    @Column
    private String products;

    public Routine() {
    }

    public Routine(Long id, String name, String steps, String products) {
        this.id = id;
        this.name = name;
        this.steps = steps;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Routine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", steps='" + steps + '\'' +
                ", products='" + products + '\'' +
                '}';
    }
}
