package com.odisea.gamematch;

import com.odisea.gamematch.model.DatosJuego;
import com.odisea.gamematch.principal.EjemploStreams;
import com.odisea.gamematch.principal.Principal;
import com.odisea.gamematch.service.ConsumoAPI;
import com.odisea.gamematch.service.ConvierteDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GamematchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GamematchApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hola Mundo desde Spring");
		Principal principal = new Principal();
		principal.muestraElMenu();
		//EjemploStreams ejemploStreams = new EjemploStreams();
		//ejemploStreams.muestraEjemplo();
	}
}
