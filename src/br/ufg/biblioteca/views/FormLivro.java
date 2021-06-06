package br.ufg.biblioteca.views;

import br.ufg.biblioteca.entities.Autor;
import br.ufg.biblioteca.entities.Data;
import br.ufg.biblioteca.entities.Livro;

import java.util.ArrayList;
/**
 * Classe que representa o formulario dos livros na biblioteca, onde
 * ocorre a verificacao do livro e se ele esta em estoque.
 */

public class FormLivro extends Formulario {
    /**
     * Declara a lista de autores que vai ser utilizada na aplicacao
     */
    ArrayList<String> nomesAutores = new ArrayList<String>();
    String nomeAutor;
    /**
     * @param nomeAutor Nome do autor do livro em questao
     */
    public FormLivro(Lista lista, String[] atributos) {
        super(lista, atributos);
    
    }
    /**&
     * Checa se as informacoes inseridas sao validas
     */
    boolean validateText() {

        boolean ok = true;
        
        /**
         * Checa se o ano inserido e um numero inteiro
         */
        try {
            Integer.valueOf(atributosText.get(1).getText());
        } catch (NumberFormatException e) {
            atributosErrorLabel.get(1).setText("Insira um numero inteiro.");
            ok = false;
        }

        /**
         * Checa se a quantidade inserida e um numero inteiro
         */
        try {
            Integer.valueOf(atributosText.get(4).getText());
        } catch (NumberFormatException e) {
            atributosErrorLabel.get(4).setText("Insira um numero inteiro.");
            ok = false;
        }

        for(Autor a : Data.autores) {
            nomesAutores.add(a.getNome());
        }

        nomeAutor = atributosText.get(5).getText();

        /**
         * Checa se o autor inserido esta cadastrado
         */
        if(!nomesAutores.contains(nomeAutor)) {
            atributosErrorLabel.get(5).setText("Autor nao cadastrado");
            ok = false;
        }

        return ok;
    }

    /**
     * Cria um novo livro e o adiciona na lista global (em Data)
     */
    void createData(Object[] data) {
        int indexAutor = nomesAutores.indexOf(nomeAutor);
        Data.livros.add(new Livro((String)data[0], Integer.valueOf(data[1].toString()), (String)data[2], (String)data[3], Integer.valueOf(data[4].toString()), Data.autores.get(indexAutor)));
    }
    
}
