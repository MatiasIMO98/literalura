package com.alura.literalura;

import com.alura.literalura.model.DatosLibro;
import com.alura.literalura.model.Libro;
import com.alura.literalura.repository.LibroRepository;
import com.alura.literalura.service.ConsumoAPI;
import com.alura.literalura.service.ConvierteDatos;

import java.util.Scanner;

public class Principal {

    private Scanner teclado = new Scanner(System.in);
    ConsumoAPI consumoApi = new ConsumoAPI();
    ConvierteDatos conversor = new ConvierteDatos();
    LibroRepository repositorio;
    private final String URL_BASE = "https://gutendex.com/books?";

    public Principal(LibroRepository repository){
        this.repositorio = repository;
    }

    public void muestraElMenu() {
        var opcion = -1;

        System.out.println("\n\n******* Bienvenidx a Literalura!! *******");
        while (opcion != 0) {
            var menu = """
                    \n
                    Elija una opción a través de su número:
                    1 - buscar libro por titulo
                    2 - listar libros registrados
                    3 - listar autores registrados
                    4 - listar autores vivos en un determinado año
                    5 - listar libros por idioma
                                  
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    buscarLibro();
                    break;
                case 2:
                    listarLibrosRegistrados();
                    break;
                case 3:
                    listarAutoresRegistrados();
                    break;
                case 4:
                    listarAutoresVivosEnPeriodo();
                    break;
                case 5:
                    listarLibrosPorIdioma();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }

    }

    private DatosLibro getDatosLibro() {
        System.out.println("Ingrese el nombre del libro que desea buscar: ");
        var titulo = teclado.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE + "search="+ titulo.replace(" ", "%20"));
        System.out.println(json);
        return conversor.obtenerDatos(json, DatosLibro.class);
    }

    private void buscarLibro() {
        DatosLibro datos = getDatosLibro();
        Libro libro = new Libro(datos);
        repositorio.save(libro);
        System.out.println(datos);
    }

    private void listarLibrosRegistrados() {
    }

    private void listarAutoresRegistrados() {
    }

    private void listarAutoresVivosEnPeriodo() {
    }

    private void listarLibrosPorIdioma() {
    }

}
