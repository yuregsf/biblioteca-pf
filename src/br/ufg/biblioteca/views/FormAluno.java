package br.ufg.biblioteca.views;

import br.ufg.biblioteca.entities.Aluno;
import br.ufg.biblioteca.entities.Data;
import br.ufg.biblioteca.exceptions.AlunoExistenteException;

/**
    Classe que representa o formulario do aluno, onde 
    ocorre a atribuicao dele na lista.
 */

public class FormAluno extends Formulario{

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
    void createData(Object[] data) throws AlunoExistenteException{
        final Aluno a = Data.alunos.stream().filter(aluno ->
                data[0].toString().equals(aluno.getNome()) &&
                        data[1].equals(aluno.getMatricula()))
                .findFirst()
                .orElse(null);
        if(a != null) throw new AlunoExistenteException();
        Data.alunos.add(new Aluno(data[0].toString(), (String)data[1], (String)data[2], (String)data[3]));
    }
}
