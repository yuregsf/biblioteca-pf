package br.ufg.biblioteca.entities;

/**
 * Classe que representa um funcionário da biblioteca.
 */
public class Funcionario extends Pessoa {
    private boolean isAdmin = false; // Não foi implementado

    /**
     *
     * @param nome Nome do funcionário
     * @param matricula Matrícula do funcionário
     */
    public Funcionario(String nome, String matricula) {
        super(nome, matricula);
    }

    // Não foi implementado

    /**
     * Promove um funcionário a administrador
     */
    public void promoverAdmin(){
        this.isAdmin = true;
    }

    /**
     * Transforma o objeto em um array com seus respectivos dados.
     * @return [nome, matricula]
     */
    public Object[] toArray() {
        Object[] array = {getNome(), getMatricula()};
        return array;
    }
}
