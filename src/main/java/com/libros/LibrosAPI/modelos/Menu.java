package com.libros.LibrosAPI.modelos;

import com.libros.LibrosAPI.trabajoapis.ConstructorDeDatos;
import com.libros.LibrosAPI.trabajoapis.ConsumeAPI;

import java.util.DoubleSummaryStatistics;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Menu {
    private final ConsumeAPI consumo = new ConsumeAPI();
    private final ConstructorDeDatos constructor = new ConstructorDeDatos();
    Libros libreria = constructor.obtenerDatos( consumo.obtenerDatos("https://gutendex.com/books/"), Libros.class );     //Construccion de la libreria

    public void despliegaMenu(){
        //Primer resultado, los primeros 5
        System.out.println("Datos");
        libreria.libros().stream().limit(5).forEach(System.out::println);

        //Los 10 mas descargados
        System.out.println("\nTop 10 libros mas descargados");
        libreria.libros().stream().limit(10).forEach(l-> System.out.println(l.titulo()));
        //Busqueda
        busqueda(libreria);
    }

    private void busqueda(Libros libreria){

        String libroBuscado;
        Scanner entrada = new Scanner(System.in);
        int pagina=1;
        Optional<DatosLibros> busqueda = Optional.empty();

        System.out.println("\nIntroduce el libro que estas buscando");
        libroBuscado = entrada.nextLine();

        while(busqueda.isEmpty()) {
            busqueda = libreria.libros().stream()
                    .filter(l -> l.titulo().toUpperCase().contains(libroBuscado.toUpperCase()))
                    .findFirst();
            if (busqueda.isPresent()) {
                System.out.println("Este es el libro");
                System.out.println(busqueda.get());
                estadisticas(busqueda);
            } else {
                pagina++;
                libreria.libros()
                        .addAll(constructor.obtenerDatos(consumo.obtenerDatos("https://gutendex.com/books/?page=" + String.valueOf(pagina)), Libros.class)
                                .libros());
            }
        }

    }

    private void estadisticas(Optional<DatosLibros> resultado){
        DoubleSummaryStatistics estadisticas = libreria.libros().stream().collect(Collectors.summarizingDouble( DatosLibros::descargas ) );
        System.out.println("Media de descargas: "+estadisticas.getAverage());
        System.out.println("Numero mayor de descargas: "+estadisticas.getMax());
        System.out.println("Numero mayor de descargas: "+estadisticas.getMin());
        System.out.println("Numero de registros revisados: "+ estadisticas.getCount() );
    }
}