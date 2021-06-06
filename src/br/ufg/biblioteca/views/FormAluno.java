package br.ufg.biblioteca.views;

import br.ufg.biblioteca.entities.Aluno;
import br.ufg.biblioteca.entities.Data;

/**
    Classe que representa o formulario do aluno, onde 
    ocorre a atribuicao dele na lista.
 */

public class FormAluno extends Formulario {

    public FormAluno(Lista lista, String[] atributos) {
        super(lista, atributos);
    }

    /**
     *
     * @param lista Lista de alunos
     * @param atributos Atributos do formulario
     */

    /**
     * Checa se as informacoes inseridas sao validas
     */
    boolean validateText() {
        return true;
    }

    /**
     * Cria um novo aluno e o adiciona na lista global (em Data)
     */
    void createData(Object[] data) {   
        Data.alunos.add(new Aluno(data[0].toString(), (String)data[1], (String)data[2], (String)data[3]));
    }
}
