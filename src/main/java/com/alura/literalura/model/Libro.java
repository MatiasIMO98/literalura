package com.alura.literalura.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

@Entity
@Table(name = "Libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(unique = true)
    private String titulo;
    private Integer numeroDescargas;
    @Enumerated(EnumType.STRING)
    private Idioma idioma;
    @ManyToMany
    private List<Autor> autores;

    public Libro(){}

    public Libro(DatosLibro datosLibro) {
        this.titulo = datosLibro.titulo();
        this.idioma = datosLibro.idioma();
//      this.idioma = Idioma.fromString(datosLibro.idioma().split(",")[0].trim());
        this.numeroDescargas = datosLibro.numeroDescargas();
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

    public Integer getNumeroDescargas() {
        return numeroDescargas;
    }
    public void setNumeroDescargas(Integer numeroDescargas) {
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
