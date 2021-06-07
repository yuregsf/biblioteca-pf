package br.ufg.biblioteca.views;

import br.ufg.biblioteca.entities.Data;

import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public abstract class Formulario extends JFrame {

    String[] atributos;
    ArrayList<JTextField> atributosText = new ArrayList<JTextField>();
    ArrayList<JLabel> atributosErrorLabel = new ArrayList<JLabel>();

    String title;

    public Formulario(Lista lista, String[] atributos) {
        
        // Inicializando a nova janela e o panel principal
        super("Cadastrar " + lista.classe);
        this.atributos = atributos;        

        JPanel formularioPanel = new JPanel();
        formularioPanel.setLayout(new BoxLayout(formularioPanel, BoxLayout.Y_AXIS));

        // Titulo
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new GridLayout(2,1));
        titlePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel1 = new JLabel(lista.classe, SwingConstants.CENTER);
        titleLabel1.setFont(new Font("TimesRoman", Font.BOLD, 20));

        JLabel titleLabel2 = new JLabel("Novo cadastro:", SwingConstants.CENTER);

        titlePanel.add(titleLabel1);
        titlePanel.add(titleLabel2);

        formularioPanel.add(titlePanel);

        // Adicionando os campos de cada atributo
        for(int i = 0; i < atributos.length; i++) {

            JPanel atributoPanel = new JPanel();
            atributoPanel.setLayout(new BorderLayout());
            atributoPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

            JLabel atributoLabel = new JLabel(atributos[i] + ":");
            JTextField atributoTextField = new JTextField(20);
            JLabel atributoErrorLabel = new JLabel(" ", JLabel.RIGHT);
            atributoErrorLabel.setForeground(Color.RED);

            atributoPanel.add(atributoLabel, BorderLayout.WEST);
            atributoPanel.add(atributoTextField, BorderLayout.EAST);
            atributoPanel.add(atributoErrorLabel, BorderLayout.SOUTH);

            atributosText.add(atributoTextField);
            atributosErrorLabel.add(atributoErrorLabel);
            
            formularioPanel.add(atributoPanel);
        }

        // Botoes
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));

        JButton button1 = new JButton("Cancelar");
        button1.setFocusPainted(false);
        button1.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            }
        );

        JButton button2 = new JButton("Confirmar");
        button2.setFocusPainted(false);
        button2.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    // Junta-se todos os dados inseridos
                    ArrayList<String> texts = new ArrayList<String>();

                    for(int i = 0; i < atributosText.size(); i++) {

                        String text = atributosText.get(i).getText();
                        texts.add(text);
                    }

                    // Checa se o texto esta valido
                    if(checkEmpty() && validateText()) {
                        Object[] data = texts.toArray();

                        // Cria a nova classe e a armazena
                        createData(data);
                        try {
                            Data.saveData();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }

                        // Adiciona a nova linha com os dados inseridos e fecha a janela do formulario
                        lista.tableModel.addRow(data);
                        dispose();
                    }
                }
            }
        );
        
        // Adicionando os botoes e o panel principal
        buttonsPanel.add(button1);
        buttonsPanel.add(button2);

        formularioPanel.add(buttonsPanel);
        
        add(formularioPanel);

        // Preparando a janela
        pack();
        setMinimumSize(getSize());
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    // Checa se algum campo nao foi preenchido
    private boolean checkEmpty() {
        boolean ok = true;

        for(int i = 0; i < atributosText.size(); i++) {
            if(atributosText.get(i).getText().equals("")) {
                atributosErrorLabel.get(i).setText("Insira um valor");
                ok = false;
            }
            else
                atributosErrorLabel.get(i).setText(" ");
        }

        return ok;
    }

    abstract boolean validateText();

    abstract void createData(Object[] data);
}
