package com.alura.literalura.model;

public enum Idioma {
    ES("es", "Espanhol"),
    EN("en", "Inglês"),
    FR("fr", "Francês"),
    PT("pt", "Português");

    private String idiomaAPI;
    private String idiomaPortugues;

    Idioma(String idiomaAPI, String idiomaPortugues){
        this.idiomaAPI = idiomaAPI;
        this.idiomaPortugues = idiomaPortugues;
    }

    public static Idioma fromString(String text){
        for (Idioma idioma : Idioma.values()){
            if (idioma.idiomaAPI.equalsIgnoreCase(text)){
                return idioma;
            }
        }
        throw new IllegalArgumentException("Não existem livros nesse idioma no banco de dados.");
    }

    public static Idioma fromPortugues(String text){
        for (Idioma idioma : Idioma.values()){
            if (idioma.idiomaPortugues.equalsIgnoreCase(text)){
                return idioma;
            }
        }
        throw new IllegalArgumentException("Não existem livros nesse idioma no banco de dados.");
    }
}
