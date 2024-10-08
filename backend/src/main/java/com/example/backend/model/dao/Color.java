package com.example.backend.model.dao;

//import com.example.backend.Initialization.ColorInitializer;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "color")
@Data
//@EntityListeners(ColorInitializer.class)
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String colorName;

    @NotBlank
    @Column(nullable = false)
    private String colorCode;

    @Positive
    @Column(nullable = false)
    private BigDecimal price;

    @ManyToMany(mappedBy = "colors", fetch = FetchType.EAGER)
    private Set<Account> owners = new HashSet<>();
}
