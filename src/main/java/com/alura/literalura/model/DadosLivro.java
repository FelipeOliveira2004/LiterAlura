package com.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLivro(@JsonAlias("results") List<DadosLivro> resultado,
                         @JsonAlias("title") String titulo,
                         @JsonAlias("authors") List<DadosAutor> autor,
                         @JsonAlias("languages")List<String> idiomas,
                         @JsonAlias("download_count") Integer downloads) {

    public DadosLivro getLivroPrincipal() {
        if (resultado != null && !resultado.isEmpty()) {
            return resultado.get(0);
        }
        return this;
    }
}