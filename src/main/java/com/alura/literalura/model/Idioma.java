package com.alura.literalura.model;

public enum Idioma {

    ESPANOL("es"),
    INGLES("en"),
    FRANCES("fr"),
    PORTUGUES("pt");

    private String IdiomaGutendex;

    Idioma (String IdiomaGutendex){
        this.IdiomaGutendex = IdiomaGutendex;

    }

    public static Idioma fromString(String text) {
        for (Idioma Idioma : Idioma.values()) {
            if (Idioma.IdiomaGutendex.equalsIgnoreCase(text)) {
                return Idioma;
            }
        }
        throw new IllegalArgumentException("Ningun Idioma encontrado: " + text);
    }

}
