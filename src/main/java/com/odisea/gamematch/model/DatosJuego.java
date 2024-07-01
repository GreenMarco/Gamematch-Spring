package com.odisea.gamematch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosJuego(@JsonAlias("name") String titulo,
                         //Lee y Escribe
                         //@JsonProperty("released") String fechaDeLanzamiento,
                         //Solo lee
                         @JsonAlias("released") String fechaDeLanzamiento,
                         @JsonAlias("description") String descripcion,
                         @JsonAlias("metacritic") String mediaNotas,
                         @JsonAlias("metacritic_platforms") List<DatosCalificaciones> calificaciones,
                         @JsonAlias("parent_platforms") List<Platform> plataformas){
}