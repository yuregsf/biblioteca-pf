package br.ufg.biblioteca.views;

import br.ufg.biblioteca.entities.*;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
    Classe que representa o formulario de emprestimos, onde 
    ocorre a atribuicao dos livros, alunos e funcionarios.
 */

public class FormEmprestimo extends Formulario {

    ArrayList<String> nomesLivros = new ArrayList<String>();
    ArrayList<String> nomesAlunos = new ArrayList<String>();
    ArrayList<String> nomesFuncionarios = new ArrayList<String>();

    String nomeLivro;
    String nomeAluno;
    String nomeFuncionario;

    Date inicio;
    Date fim;

    /**
     *
     * @param nomeLivro Nome do livro
     * @param nomeAluno Nome do aluno que quer o emprestimo
     * @param nomeFuncionario Nome do funcionario que fez o emprestimo
     * @param inicio Data que foi realizada o emprestimo
     * @param fim Data para entregar o livro ou exemplar
     */

    public FormEmprestimo(Lista lista, String[] atributos) {
        super(lista, atributos);
    }

    /**
     * Checa se as informacoes inseridas sao validas
     */
    boolean validateText() {

        boolean ok = true;

        for(Livro a : Data.livros) {
            nomesLivros.add(a.getNome());
        }
        for(Aluno a : Data.alunos) {
            nomesAlunos.add(a.getNome());
        }
        for(Funcionario a : Data.funcionarios) {
            nomesFuncionarios.add(a.getNome());
        }

        nomeLivro = atributosText.get(0).getText();
        nomeAluno = atributosText.get(1).getText();
        nomeFuncionario = atributosText.get(2).getText();

        /**
         * Checa se o livro inserido esta cadastrado
         */
        if(!nomesLivros.contains(nomeLivro)) {
            atributosErrorLabel.get(0).setText("Livro nao cadastrado");
            ok = false;
        }
        /**
         * Checa se o livro inserido esta disponivel
         */
        else if(Data.livros.get(nomesLivros.indexOf(nomeLivro)).getQuantidade() <= 0) {
            atributosErrorLabel.get(0).setText("Livro indisponivel");
            ok = false;
        }
        /**
         * Checa se o aluno inserido esta cadastrado
         */
        if(!nomesAlunos.contains(nomeAluno)) {
            atributosErrorLabel.get(1).setText("Aluno nao cadastrado");
            ok = false;
        }
        /**
         * Checa se o funcionario inserido esta cadastrado
         */
        if(!nomesFuncionarios.contains(nomeFuncionario)) {
            atributosErrorLabel.get(2).setText("Funcionario nao cadastrado");
            ok = false;
        }
        /**
         * Checa se a data de inicio inserida esta no formato correto
         */
        try {
            inicio = new SimpleDateFormat("dd/MM").parse(atributosText.get(3).getText());
        } catch (ParseException e) {
            atributosErrorLabel.get(3).setText("Insira uma data (dd/MM)");
            ok = false;
        }
        /**
         * Checa se a data para entregar inserida esta no formato correto
         */
        try {
            fim = new SimpleDateFormat("dd/MM").parse(atributosText.get(4).getText());
        } catch (ParseException e) {
            atributosErrorLabel.get(4).setText("Insira uma data (dd/MM)");
            ok = false;
        }

        return ok;
    }

    /**
     * Cria um novo emprestimo e o adiciona na lista global (em Data)
     */
    void createData(Object[] data) {
        int indexLivro = nomesLivros.indexOf(nomeLivro);
        int indexAluno = nomesAlunos.indexOf(nomeAluno);
        int indexFuncionario = nomesFuncionarios.indexOf(nomeFuncionario);
        
        Data.emprestimos.add(new Emprestimo(Data.livros.get(indexLivro), Data.alunos.get(indexAluno),
        Data.funcionarios.get(indexFuncionario), inicio, fim));
        Data.livros.get(indexLivro).diminuirQuantidade();
    }
    
}
