package com.odisea.gamematch.model;

import jakarta.persistence.*;

@Entity
@Table(name = "calificaciones")

public class Calificaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "juego_id")
    private Juego juego;

    @ManyToOne
    @JoinColumn(name = "platform_id")
    private Platform platform;

    private int metascore;
    private String URL;
    private Platform plataforma;

    public Calificaciones (DatosCalificaciones datosCalificaciones){
        this.metascore = datosCalificaciones.metascore();
        this.URL = datosCalificaciones.URL();
        this.plataforma = datosCalificaciones.plataforma();

    }

    @Override
    public String toString() {
        return  "Plataforma='" + plataforma + '\'' +
                "MetaScore='" + metascore +'\''+
                "URL='" + URL+'\'';
    }

    //Setters


    public void setId(Long id) {
        this.id = id;
    }
    public void setJuego(Juego juego) {
        this.juego = juego;
    }
    public void setMetascore(int metascore) {
        this.metascore = metascore;
    }
    public void setURL(String URL) {
        this.URL = URL;
    }
    public void setPlataforma(Platform plataforma) {
        this.plataforma = plataforma;
    }

    //Getters

    public Long getId() {
        return id;
    }

    public Juego getJuego() {
        return juego;
    }

    public int getMetascore() {
        return metascore;
    }
    public String getURL() {
        return URL;
    }
    public Platform getPlataforma() {
        return plataforma;
    }
}
