package com.odisea.gamematch.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "juegos")

public class Juego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    private String fechaDeLanzamiento;
    private String descripcion;
    private String mediaNotas;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DatosCalificaciones> calificaciones;

    @ManyToMany
    @JoinTable(
            name = "juego_platform",
            joinColumns = @JoinColumn(name = "juego_id"),
            inverseJoinColumns = @JoinColumn(name = "platform_id")
    )
    private List<Platform> plataformas;

    public Juego (DatosJuego datosJuego){
        this.titulo = datosJuego.titulo();
        this.fechaDeLanzamiento = datosJuego.fechaDeLanzamiento();
        this.descripcion = datosJuego.descripcion();
        this.mediaNotas = datosJuego.mediaNotas();
        this.calificaciones = datosJuego.calificaciones();
        this.plataformas = datosJuego.plataformas();
    }

    @Override
    public String toString() {
        return  "Titulo='" + titulo + '\'' +
                "FechaDeLanzamiento='" + fechaDeLanzamiento+'\''+
                "Descripcion='" + descripcion +'\''+
                "Media de Notas='" + mediaNotas +'\''+
                "Calificiaciones='" + calificaciones+'\'';
    }

    //Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setFechaDeLanzamiento(String fechaDeLanzamiento) {
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setMediaNotas(String mediaNotas) {
        this.mediaNotas = mediaNotas;
    }

    public void setCalificaciones(List<DatosCalificaciones> calificaciones) {
        this.calificaciones = calificaciones;
    }

    public void setPlataformas(List<Platform> plataformas) {
        this.plataformas = plataformas;
    }

    //Getters

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getMediaNotas() {
        return mediaNotas;
    }

    public List<DatosCalificaciones> getCalificaciones() {
        return calificaciones;
    }

    public List<Platform> getPlataformas() {
        return plataformas;
    }
}
