package br.ufg.biblioteca.entities;

import java.io.Serializable;

/**
 * Classe abstrata que representa uma pessoa na aplicação.
 * Uma pessoa possui um nome e uma matrícula de cadastro.
 */
public abstract class Pessoa implements Serializable {
    private String nome;
    private String matricula;

    /**
     *
     * @param nome Nome da pessoa
     * @param matricula Matrícula de cadastro da pessoa
     */
    public Pessoa(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    /**
     * Retorna o nome da pessoa
     * @return Nome da pessoa
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna a matrícula de cadastro da pessoa
     * @return Matrícula de cadastro da pessoa
     */
    public String getMatricula() {
        return matricula;
    }
}