package br.ufg.biblioteca.test;


import br.ufg.biblioteca.entities.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Date;
class AlunoTest {
    private static Aluno aluno;
    private static Funcionario funcionario;
    private static Autor autor;
    private static Livro livro;
    private static Emprestimo emp;

    @BeforeAll
    static void criaAluno(){
        aluno = new Aluno("João", "11111", "6299999", "joao@java.ufg.br");
        funcionario = new Funcionario("João", "11111");
        autor = new Autor("Machado de Assis", "Brasileira");
        livro = new Livro("Brás Cubas", 1990, "Primeira", "Livro legal sobre o Brás Cubas", 1, autor);
        emp = new Emprestimo(livro, aluno, funcionario, new Date(), new Date());
    }

    @Test
    void listarEmprestimos() {
        Assertions.assertEquals(emp.toString()+'\n', aluno.listarEmprestimos());
    }

    @Test
    void listarEmprestimosNaoConcluidos() {
        Assertions.assertNotEquals(emp.toString()+'\n', aluno.listarEmprestimos(true));

    }

    @Test
    void listarEmprestimosConcluidos() {
        emp.setConcluido(true);
        Assertions.assertEquals(emp.toString()+'\n', aluno.listarEmprestimos(true));

    }
}