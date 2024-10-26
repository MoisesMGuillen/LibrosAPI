package com.libros.LibrosAPI;

import com.libros.LibrosAPI.modelos.Menu;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibrosApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LibrosApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Menu menu = new Menu();
		menu.despliegaMenu();
	}
}
