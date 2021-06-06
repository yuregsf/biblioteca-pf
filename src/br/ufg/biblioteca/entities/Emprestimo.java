package br.ufg.biblioteca.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Calendar;

/**
 * Classe que representa o empréstimo de um livro.
 * Guarda o livro emprestado, o funcionário que realizou o empréstimo
 * e a quem foi emprestado, no caso o aluno.
 */
public class Emprestimo implements Serializable {

    private Date dataEmprestimo;
    private Date previsaoDevolucao;
    private Calendar dataDevolucao; // Não foi implementado
    private boolean concluido = false; // Não foi implementado
    private Livro livro;

    private Aluno aluno;
    private Funcionario funcionario;

    /**
     *
     * @param livro Objeto do livro a ser emprestado
     * @param aluno Objeto do aluno que está recebendo o livro
     * @param funcionario Objeto do funcionário que está realizando o empréstimo
     * @param dataEmprestimo Data em que o empréstimo está sendo realizado
     * @param previsaoDevolucao Data de previsão para devolução do livro
     */
    public Emprestimo(Livro livro, Aluno aluno, Funcionario funcionario, Date dataEmprestimo,
                      Date previsaoDevolucao) {
        this.dataEmprestimo = dataEmprestimo;
        this.previsaoDevolucao = previsaoDevolucao;
        this.aluno = aluno;
        this.funcionario = funcionario;
        this.livro = livro;
    }

    // Nao foi utilizado/implementado

    /**
     *
     * @hidden
     * @param data
     */
    public void devolverExemplar(Calendar data) {
        livro.aumentarQuantidade();
        this.dataDevolucao = data;
        this.concluido = true;
    }

    // Nao foi utilizado/implementado

    /**
     * @return
     */
    public boolean isConcluido() {
        return concluido;
    }

    // Nao foi utilizado/implementado

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }
    /**
     * Transforma o objeto em um array com seus respectivos dados.
     * @return [nome do livro, nome do aluno, nome do funcionário, data de empréstimo, previsao de devolução]
     */
    public Object[] toArray() {
        Object[] array = {livro.getNome(), aluno.getNome(), funcionario.getNome(),
                 dataEmprestimo, previsaoDevolucao};
        return array;
    }

    /**
     * Retorna livro utilizado no empréstimo.
     * @return Livro emprestado
     */
    public Livro getLivro() {
        return livro;
    }
}
