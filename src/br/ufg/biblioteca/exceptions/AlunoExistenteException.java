package br.ufg.biblioteca.exceptions;

public class AlunoExistenteException extends RuntimeException{

    public AlunoExistenteException(){
        super("Aluno já cadastrado no banco de dados");
    }
    public AlunoExistenteException(String msg){
        super(msg);
    }
}
