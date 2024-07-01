package com.odisea.gamematch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "plataformas")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Platform {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "plataformas")
    private List<Juego> juegos;

    @OneToMany(mappedBy = "platform", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Calificaciones> calificacionesPlataforma;

    @JsonAlias("name")
    private String nombre;



    public String getName() {
        return nombre;
    }

    public void setName(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return String.valueOf(nombre);
    }
}