package br.ufg.biblioteca.entities;

import java.io.Serializable;

/**
 * Classe que representa o autor de um livro
 */
public class Autor implements Serializable {
    private String nome;
    private String nacionalidade;

    /**
     *
      * @param nome Nome do autor
     * @param nacionalidade Nacionalidade do autor
     */
    public Autor(String nome, String nacionalidade) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
    }

    /**
     * Retorna o nome do autor
     * @return Nome do autor
     */
    public String getNome() {
        return nome;
    }

    /**
     * Transforma o objeto em um array com seus respectivos dados.
     * @return [nome, nacionalidade]
     */
    public Object[] toArray() {
        Object[] array = {getNome(), nacionalidade};
        return array;
    }
}
