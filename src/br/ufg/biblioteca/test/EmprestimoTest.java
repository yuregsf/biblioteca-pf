package br.ufg.biblioteca.test;

import br.ufg.biblioteca.entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class EmprestimoTest {
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
    void devolverExemplar() {
        emp.devolverExemplar(Calendar.getInstance());
        Assertions.assertEquals(livro.getQuantidade(), 1);
    }
}