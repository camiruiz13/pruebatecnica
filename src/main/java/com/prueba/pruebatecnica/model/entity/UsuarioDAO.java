package com.prueba.pruebatecnica.model.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "USUARIO")
public class UsuarioDAO {

    @Id
    @Basic(optional = false)
    @Column(name = "ID_USUARIO", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @OneToOne(optional = false, cascade = {
            CascadeType.REFRESH, CascadeType.DETACH
    })
    @JoinColumn(name = "ID_ROL", nullable = false, referencedColumnName = "ID_ROL", foreignKey = @ForeignKey(
            name = "FK_USUARIO_TIENE_ROL"
    ))
    private RolDAO rol;

    @Column(name = "NOMBRE",nullable = false, length = 50)
    private String nombre;

    @Column(name = "ACTIVO",nullable = false, length = 2)
    private  String  activo;
}
