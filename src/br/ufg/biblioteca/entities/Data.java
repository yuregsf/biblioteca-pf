package br.ufg.biblioteca.entities;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 * Classe que representa e persiste os dados da aplicação.
 */
public final class Data {
    
    // Declara as listas que armazenarao os objetos que serao utilizados em toda a aplicacao
    public static ArrayList<Aluno> alunos = new ArrayList<Aluno>();
    public static ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
    public static ArrayList<Livro> livros = new ArrayList<Livro>();
    public static ArrayList<Autor> autores = new ArrayList<Autor>();
    public static ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();


    /**
     * Abre e le o arquivo, armazenando os dados nas respectivas listas.
     */
    public static void readData() {
        try {
            FileInputStream fileIn = new FileInputStream("alunos.ser");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
 
            Object obj = objectIn.readObject();
            objectIn.close();

            alunos = (ArrayList<Aluno>)obj;
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            FileInputStream fileIn = new FileInputStream("funcionarios.ser");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
 
            Object obj = objectIn.readObject();
            objectIn.close();

            funcionarios = (ArrayList<Funcionario>)obj;
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            FileInputStream fileIn = new FileInputStream("livros.ser");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
 
            Object obj = objectIn.readObject();
            objectIn.close();

            livros = (ArrayList<Livro>)obj;
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            FileInputStream fileIn = new FileInputStream("autores.ser");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
 
            Object obj = objectIn.readObject();
            objectIn.close();

            autores = (ArrayList<Autor>)obj;
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            FileInputStream fileIn = new FileInputStream("emprestimos.ser");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
 
            Object obj = objectIn.readObject();
            objectIn.close();

            emprestimos = (ArrayList<Emprestimo>)obj;
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Abre e escreve os dados no arquivo
     * @throws IOException
     */
    public static void saveData() throws IOException {
        try {
            FileOutputStream fop = new FileOutputStream("alunos.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fop);
            oos.writeObject(alunos);
            oos.close();
    
        } catch (FileNotFoundException e) {

        }
        try {
            FileOutputStream fop = new FileOutputStream("funcionarios.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fop);
            oos.writeObject(funcionarios);
            oos.close();
    
        } catch (FileNotFoundException e) {

        }
        try {
            FileOutputStream fop = new FileOutputStream("livros.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fop);
            oos.writeObject(livros);
            oos.close();
    
        } catch (FileNotFoundException e) {

        }
        try {
            FileOutputStream fop = new FileOutputStream("autores.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fop);
            oos.writeObject(autores);
            oos.close();
    
        } catch (FileNotFoundException e) {

        }
        try {
            FileOutputStream fop = new FileOutputStream("emprestimos.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fop);
            oos.writeObject(emprestimos);
            oos.close();
    
        } catch (FileNotFoundException e) {

        }
    }
}
