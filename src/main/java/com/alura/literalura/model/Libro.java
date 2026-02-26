package com.alura.literalura.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(unique = true)
    private String titulo;
    private Double numeroDescargas;
    @Enumerated(EnumType.STRING)
    private Idioma idioma;
    @ManyToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Autor> autores;

    public Libro(){}

    public Libro(DatosLibro datosLibro) {
        this.titulo = datosLibro.titulo();
        this.idioma = datosLibro.idioma();
//        this.idioma = Idioma.fromString(datosLibro.idioma().split(",")[0].trim());
        this.numeroDescargas = OptionalDouble.of(datosLibro.numeroDescargas()).orElse(0);

    }

    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Double getNumeroDescargas() {
        return numeroDescargas;
    }
    public void setNumeroDescargas(Double numeroDescargas) {
        this.numeroDescargas = numeroDescargas;
    }

    public Idioma getIdioma() {
        return idioma;
    }
    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public List<Autor> getAutores() {
        return autores;
    }
    public void setAutores(List<Autor> autores) {
        if(autores != null) autores.forEach(a -> a.getLibros().add(this));
        this.autores = autores;
    }

    @Override
    public String toString() {
        String nombresAutores = autores.stream()
                .map(Autor::getNombre)
                .collect(Collectors.joining(", "));
        return "----- Libro -----"+
                "\ntitulo: " + titulo +
                "\nautor: " + nombresAutores +
                "\nnumeroDescargas=" + numeroDescargas +
                "\ntitulo='" + titulo;
    }
}
