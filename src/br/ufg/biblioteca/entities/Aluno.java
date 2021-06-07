package br.ufg.biblioteca.entities;

import java.util.ArrayList;

/**
    Classe que representa um aluno, a Pessoa
     a qual o emprésitmos de livros é atribuída.
 */
public class Aluno extends Pessoa {
    // Nao esta sendo utilizado os emprestimos
    ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
    private String telefone;
    private String email;

    /**
     *
     * @param nome Nome do aluno
     * @param matricula Matricula do aluno
     * @param telefone Telefone do aluno
     * @param email Email do aluno
     */
    public Aluno(String nome, String matricula, String telefone, String email) {
        super(nome, matricula);
        this.telefone = telefone;
        this.email = email;
    }

    // Nao foi utilizado

    /**
     * @hidden
     * @param concluido
     * @return
     */
    public String listarEmprestimos(boolean concluido){
        String ret = "";
        for(Emprestimo e : this.emprestimos){
            if(e.isConcluido() == concluido){
                ret += e.toString() + '\n';
            }
        }
        return ret;
    }

    // Nao foi utilizado

    /**
     * @hidden
     * @return
     */
    public String listarEmprestimos(){
        String ret = "";
        for(Emprestimo e : this.emprestimos){
                ret += e.toString() + '\n';
        }
        return ret;
    }

    /**
     * Transforma o objeto em um array com seus respectivos dados.
     * @return [nome, matricula, telefone, email]
     */
    public Object[] toArray() {
        Object[] array = {getNome(), getMatricula(), telefone, email};
        return array;
    }

    public void addEmprestimo(Emprestimo emp){
        this.emprestimos.add(emp);
    }
}