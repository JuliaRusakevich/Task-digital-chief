package com.juliar.taskdigitalchief.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sights", schema = "sights")
@Entity
public class Sight {

    @Id
    @GeneratedValue(generator = "increment")
    private Long id;
    private String name;
    private String architect;
    private String style;
    private String address;
    private String description;
    private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

}
