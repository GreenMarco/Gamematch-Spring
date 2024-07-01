package com.odisea.gamematch.principal;

import java.util.Arrays;
import java.util.List;

public class EjemploStreams {
    public void muestraEjemplo(){
        List<String> nombres = Arrays.asList("Marco","Tania","Maru","Damian","Brandon");
        nombres.stream()
                .sorted()
                //.limit(2)
                .filter(n -> n.startsWith("M"))
                .map(n->n.toUpperCase())
                .forEach(System.out::println);
    }
}
