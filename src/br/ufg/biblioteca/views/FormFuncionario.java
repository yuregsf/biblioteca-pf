package br.ufg.biblioteca.views;

import br.ufg.biblioteca.entities.Data;
import br.ufg.biblioteca.entities.Funcionario;

public class FormFuncionario extends Formulario {

    public FormFuncionario(Lista lista, String[] atributos) {
        super(lista, atributos);
    }
    
    // Checa se as informacoes inseridas sao validas
    boolean validateText() {
        return true;
    }

    // Cria um novo funcionario e o adiciona na lista global (em Data)
    void createData(Object[] data) {
        Data.funcionarios.add(new Funcionario((String)data[0], (String)data[1]));
    }
    
}
