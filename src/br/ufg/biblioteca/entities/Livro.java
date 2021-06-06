package br.ufg.biblioteca.entities;

import java.io.Serializable;

/**
 * Classe que representa um livro da biblioteca.
 */
public class Livro implements Serializable {
    private String nome;
    private int ano;
    private String edicao;
    private String descricao;
    private int quantidade;
    private Autor autor;

    /**
     *
     * @param nome Nome do livro
     * @param ano Ano de publicação do livro
     * @param edicao Edição do livro
     * @param descricao Breve descrição sobre o livro
     * @param quantidade Quantidade de exemplares disponíveis
     * @param autor Objeto do autor que escreveu o livro
     */
    public Livro(String nome, int ano, String edicao, String descricao, int quantidade, Autor autor) {
        this.nome = nome;
        this.ano = ano;
        this.edicao = edicao;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.autor = autor;
    }

    /**
     * Aumenta a quantidade de exemplares do livro
     */
    public void aumentarQuantidade() {
        quantidade++;
    }

    /**
     * Diminui a quantidade de exemplares do livro
     */
    public void diminuirQuantidade() {
        quantidade--;
    }

    /**
     * Retorna o nome do livro
     * @return Nome do livro
     */
    public String getNome() {
        return nome;
    }

    /**
     * Transforma o objeto em um array com seus respectivos dados.
     * @return [nome, ano, edicao, descricao, quantidade, autor]
     */
    public Object[] toArray() {
        Object[] array = {getNome(), ano, edicao, descricao, quantidade, autor.getNome()};
        return array;
    }

    /**
     * Retorna a quantidade de exemplares do livro
     * @return Quantidade de exemplares do livro
     */
    public int getQuantidade() {
        return quantidade;
    }
}
