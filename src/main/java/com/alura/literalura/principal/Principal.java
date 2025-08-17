package com.alura.literalura.principal;

import com.alura.literalura.model.DadosAutor;
import com.alura.literalura.model.DadosLivro;
import com.alura.literalura.model.Livro;
import com.alura.literalura.repository.LivroRepository;
import com.alura.literalura.service.ConsumoAPI;
import com.alura.literalura.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();
    private final String ENDERECO = "https://gutendex.com/books/?search=";
    private List<DadosLivro> dadosLivro = new ArrayList<>();
    private List<DadosAutor> dadosAutor = new ArrayList<>();

//    private LivroRepository repositorio;
//
//    public Principal(LivroRepository repositorio) {
//        this.repositorio = repositorio;
//    }

    public void exibeMenu() {
        var opcao = -1;
        while (opcao != 0) {
            var menu = """
                    1 - Buscar resultado pelo título
                    2 - Listar livros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos em um determinado ano
                    5 - Listar livros em um determinado idioma
                    
                    0 - Sair
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    buscarLivro();
                    break;
                case 2:
                    listarLivros();
                    break;
                case 3:
                    listarAutores();
                    break;
                case 4:
                    listarAutoresVivosPorAno();
                    break;
                case 5:
                    listarLivrosPorIdioma();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private DadosLivro getDadosLivro() {
        System.out.println("Digite o nome do resultado:");
        var nomeLivro = leitura.nextLine();
        var json = consumoAPI.obterDados(ENDERECO + nomeLivro.replace(" ", "+"));
        DadosLivro dadosLivro = conversor.obterDados(json, DadosLivro.class);
        return dadosLivro;
    }

    private void buscarLivro() {
        DadosLivro dados = getDadosLivro();
        dadosLivro.add(dados);
//        Livro livro = new Livro(dados);
//        livroRepository.save(livro);
        System.out.println(dados.getLivroPrincipal());
    }

    public void listarLivros(){
        dadosLivro.forEach(System.out::println);
    }

    public void listarAutores(){

    }

    public void listarAutoresVivosPorAno(){

    }

    public void listarLivrosPorIdioma(){

    }
}
