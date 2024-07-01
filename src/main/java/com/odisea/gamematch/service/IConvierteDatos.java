package com.odisea.gamematch.service;

public interface IConvierteDatos {

    <T> T obtenerDatos(String json, Class <T> clase);
}
