package com.bycorp.crud.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_mascotas")
@Data
@EqualsAndHashCode @ToString
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter
    private String animal;

    @Getter @Setter
    private String raza;

    @Getter @Setter
    private String nombre;

    @Getter @Setter
    private int edad;
}
