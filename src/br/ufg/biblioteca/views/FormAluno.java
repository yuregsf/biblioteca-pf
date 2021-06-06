package br.ufg.biblioteca.views;

import br.ufg.biblioteca.entities.Aluno;
import br.ufg.biblioteca.entities.Data;

public class FormAluno extends Formulario {

    public FormAluno(Lista lista, String[] atributos) {
        super(lista, atributos);
    }

    // Checa se as informacoes inseridas sao validas
    boolean validateText() {
        return true;
    }

    // Cria um novo aluno e o adiciona na lista global (em Data)
    void createData(Object[] data) {   
        Data.alunos.add(new Aluno(data[0].toString(), (String)data[1], (String)data[2], (String)data[3]));
    }
}
