package com.prueba.pruebatecnica.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ROL")
public class RolDAO {


    @Id
    @Column(name = "ID_ROL", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;

    @Column(name = "NOMBRE",nullable = false, length = 50)
    private String nombre;
}
