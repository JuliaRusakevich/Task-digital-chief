package com.juliar.taskdigitalchief.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cities", schema = "sights")
@Entity
public class City {

    @Id
    @GeneratedValue(generator = "increment")
    private Long id;
    private String name;
    private String country;
    private Integer age;
    private Double population;
    private String description;
    private LocalDateTime createdAt;

    /**
     * 1. @JoinColumn(name = "city_id")
     * 2. @OneToMany(mappedBy = "city")
     */
    @OneToMany(
            mappedBy = "city",
            cascade = CascadeType.ALL,
            orphanRemoval = true //чтобы удалены были достопримечательности
    )
    //@JoinColumn(name = "city_id")
            List<Sight> sights = new ArrayList<>();
}
