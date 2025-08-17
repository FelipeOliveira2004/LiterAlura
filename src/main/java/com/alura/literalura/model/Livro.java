package com.alura.literalura.model;

import jakarta.persistence.*;

import java.util.List;

//@Entity
//@Table(name = "tb_livros")
public class Livro {
    private List<DadosLivro> resultado;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_livro")
    private Long id;
    private String titulo;
    private Autor nomeAutor;
    @Enumerated(EnumType.STRING)
    private Idioma idioma;
    private Integer downloads;

    @ManyToOne
    private Autor autor;

    public Livro(){}

    public Livro(DadosLivro dadosLivro) {
        this.titulo = dadosLivro.titulo();
        this.idioma = Idioma.fromString(dadosLivro.idiomas().toString().split(",")[0]);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public List<DadosLivro> getResultado() {
        return resultado;
    }

    public void setResultado(List<DadosLivro> resultado) {
        this.resultado = resultado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(Autor nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }
}
