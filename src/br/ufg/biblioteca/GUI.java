package br.ufg.biblioteca;

import br.ufg.biblioteca.entities.Data;
import br.ufg.biblioteca.views.Lista;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI {
    
    // Inicializando as colunas de cada lista
    static String[] colunasLivros = {"Nome", "Ano", "Edicao", "Descricao", "Quantidade", "Autor"};
    static String[] colunasAlunos = {"Nome", "Matricula", "Telefone", "Email"};
    static String[] colunasFuncionarios = {"Nome", "Matricula"};
    static String[] colunasAutores = {"Nome", "Nacionalidade"};
    static String[] colunasEmprestimos = {"Exemplar", "Aluno", "Funcionario", "Inicio", "Fim"};

    // Declarando as janelas secundarias que serao utilizadas posteriormente
    static Lista listaLivros;
    static Lista listaAlunos;
    static Lista listaFuncionarios;
    static Lista listaAutores;
    static Lista listaEmprestimos;

    // Declarando a janela principal
    static JFrame mainFrame = new JFrame("Bibliotecapp");
    public static void main(String[] args) {

        // Sao lidos os dados armazenados em arquivo
        Data.readData();
        
        // Inicializando as janelas secundarias que serao utilizadas posteriormente
        listaLivros = new Lista("Livro", "Livros", colunasLivros, new Object[][]{});
        listaAlunos = new Lista("Aluno", "Alunos", colunasAlunos, new Object[][]{});
        listaFuncionarios = new Lista("Funcionario", "Funcionarios", colunasFuncionarios, new Object[][]{});
        listaAutores = new Lista("Autor", "Autores", colunasAutores, new Object[][]{});
        listaEmprestimos = new Lista("Emprestimo", "Emprestimos", colunasEmprestimos, new Object[][]{});

        // Executa-se o menu principal
        mainMenu();

        // Inicializando a janela principal
        mainFrame.setSize(350,400);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);
    }

    static void mainMenu() {
        
        // Criando o painel do menu
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));

        // Titulo
        JPanel titlePanel = new JPanel(); 
        titlePanel.setMaximumSize(new Dimension(Short.MAX_VALUE,0));
        titlePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        ImageIcon logo = new ImageIcon("bookIcon.png");
        Image image = logo.getImage();
        Image newImg = image.getScaledInstance(75, 75,  Image.SCALE_SMOOTH);
        logo = new ImageIcon(newImg);
        JLabel titleLabel = new JLabel(logo);
        titlePanel.add(titleLabel);

        // Botoes para as listas
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(0, 1, 0, 20));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton button1 = new JButton("Livros");
        button1.setFocusPainted(false);
        button1.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    listaLivros.requestOpen();
                }
            }
        );

        JButton button2 = new JButton("Alunos");
        button2.setFocusPainted(false);
        button2.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    listaAlunos.requestOpen();
                }
            }
        );

        JButton button3 = new JButton("Funcionarios");
        button3.setFocusPainted(false);
        button3.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    listaFuncionarios.requestOpen();
                }
            }
        );

        JButton button4 = new JButton("Autores");
        button4.setFocusPainted(false);
        button4.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    listaAutores.requestOpen();
                }
            }
        );

        JButton button5 = new JButton("Emprestimos");
        button5.setFocusPainted(false);
        button5.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    listaEmprestimos.requestOpen();
                }
            }
        );

        buttonsPanel.add(button1);
        buttonsPanel.add(button2);
        buttonsPanel.add(button3);
        buttonsPanel.add(button4);
        buttonsPanel.add(button5);

        // Adicionando os componentes e o painel na janela principal
        menuPanel.add(titlePanel);
        menuPanel.add(buttonsPanel);

        mainFrame.add(menuPanel);
    }
}   