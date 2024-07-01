package com.odisea.gamematch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosCalificaciones(@JsonAlias("metascore") int metascore,
                                  @JsonAlias("url") String URL,
                                  @JsonAlias("platform") Platform plataforma
                                  ) {

}

