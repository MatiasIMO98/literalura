package com.alura.literalura.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(unique = true)
    private String nombre;
    private int fechaNacimiento;
    private int fechaFallecimiento;
    @ManyToMany(mappedBy = "libro", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libro> libros;

    public Autor(){}

    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(int fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getFechaFallecimiento() {
        return fechaFallecimiento;
    }
    public void setFechaFallecimiento(int fechaFallecimiento) {
        this.fechaFallecimiento = fechaFallecimiento;
    }

    public List<Libro> getLibros() {
        return libros;
    }
    public void setLibros(List<Libro> libros) {
        if(libros != null) libros.forEach(l -> l.getAutores().add(this));
        this.libros = libros;
    }

    @Override
    public String toString() {
        String nombresLibros = libros.stream()
                .map(Libro::getTitulo)
                .collect(Collectors.joining(", "));
        return "Autor: " + nombre +
                "\nfechaNacimiento: " + fechaNacimiento +
                "\nfechaFallecimiento: " + fechaFallecimiento +
                "\nlibros: " + libros;
    }
}
