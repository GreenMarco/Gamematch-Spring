package com.odisea.gamematch.principal;

import com.odisea.gamematch.model.Calificaciones;
import com.odisea.gamematch.model.DatosCalificaciones;
import com.odisea.gamematch.model.DatosJuego;
import com.odisea.gamematch.model.Juego;
import com.odisea.gamematch.service.ConsumoAPI;
import com.odisea.gamematch.service.ConvierteDatos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String URL_BASE = "https://api.rawg.io/api/games/";
    private final String API_KEY = "?key=572882ee98a64375b928320bec019291";
    private ConvierteDatos conversor = new ConvierteDatos();
    private List<DatosJuego> datosJuego = new ArrayList<>();

    public void muestraElMenu(){

        System.out.println("Hello world!");

        String op = "0";
        Scanner opci = new Scanner(System.in);
        Scanner lectura = new Scanner(System.in);

        double valor;

        System.out.println("\nHola, Bienvenido al conversor de monedas\n");
        while (!op.equals("4")){
            System.out.println("""

                    Primero selecciona una opción
                    O si lo prefieres, ingresa 6 o Salir para Salir

                    1 - Consulta un juego
                    2 - Ver listado de juegos por nombre
                    3 - Ver listado de juegos por plataforma
                    4 - Salir
                    """);
            op = opci.nextLine();
            switch (op){
                case "1":
                    buscarJuego();
                    break;
                case "2":
                    System.out.println("Ci 2");
                    break;
                case "3":
                    mostrarJuegosBuscados();
                    break;
                case "4":
                case "Salir":
                    System.out.println("Gracias, vuelva pronto c:");
                    break;
                default:
                    System.out.println("Opción NO válida");
                    break;
            }
        }

    }
    private DatosJuego getDatosJuego() {
        System.out.println("Escribe el nombre de la serie que deseas buscar");
        var nombreJuego = teclado.nextLine();
        var json = ConsumoAPI.obtenerDatos(URL_BASE + nombreJuego.replace(" ", "-") + API_KEY);
        System.out.println(json);
        DatosJuego datos = conversor.obtenerDatos(json, DatosJuego.class);
        return datos;
    }

    private void buscarJuego() {
        DatosJuego datos = getDatosJuego();
        datosJuego.add(datos);
        System.out.println(datos);
    }

    private void mostrarJuegosBuscados() {
        List<Juego> juegos = new ArrayList<>();
        juegos = datosJuego.stream()
                .map(d -> new Juego(d))
                .collect(Collectors.toList());
        juegos.forEach(System.out::println);
    }
}
