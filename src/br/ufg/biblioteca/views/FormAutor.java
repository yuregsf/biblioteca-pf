package br.ufg.biblioteca.views;

import br.ufg.biblioteca.entities.Autor;
import br.ufg.biblioteca.entities.Data;


public class FormAutor extends Formulario {

    public FormAutor(Lista lista, String[] atributos) {
        super(lista, atributos);
    }

    // Checa se as informacoes inseridas sao validas
    boolean validateText() {
        return true;
    }

    // Cria um novo autor e o adiciona na lista global (em Data)
    void createData(Object[] data) {
        Data.autores.add(new Autor((String)data[0], (String)data[1]));
    }
    
}
