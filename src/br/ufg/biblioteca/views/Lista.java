package br.ufg.biblioteca.views;

import br.ufg.biblioteca.entities.*;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

/**
 * Uma classe que inicializa uma lista na aplicacao.
 */
public class Lista extends JFrame {

    DefaultTableModel tableModel;
    TableRowSorter<DefaultTableModel> sorter;
    JTextField searchTextField;
    Lista essaLista = this;
    String classe;

    /**
     *
     * @param classe
     * @param nome
     * @param colunas
     * @param data
     */
    public Lista(String classe, String nome, String[] colunas, Object[][] data) {

        /**
         * Inicializando a nova janela e o panel principal
         */
        super(nome);
        this.classe = classe;
        setMinimumSize(new Dimension(450,450));

        JPanel listaPanel = new JPanel();
        listaPanel.setLayout(new BoxLayout(listaPanel, BoxLayout.Y_AXIS));

        /**
         * Fazendo a tabela
         */
        tableModel = new DefaultTableModel(data, colunas);

        sorter = new TableRowSorter<DefaultTableModel>(tableModel);
        
        JTable tabela = new JTable(tableModel);
        tabela.setFillsViewportHeight(true);
        tabela.setRowSorter(sorter);
        tabela.setDefaultEditor(Object.class, null);
        
        JScrollPane barraRolagem = new JScrollPane(tabela);
        barraRolagem.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));


        /**
         * Botões e opções
         */
        JPanel toolsPanel = new JPanel();
        toolsPanel.setMaximumSize(new Dimension(Short.MAX_VALUE, 20));
        toolsPanel.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20));

        ImageIcon plusIcon = new ImageIcon("plusIcon.png");
        Image image = plusIcon.getImage();
        Image newImg = image.getScaledInstance(25, 25,  Image.SCALE_SMOOTH);
        plusIcon = new ImageIcon(newImg);

        JButton addRowButton = new JButton("Adicionar");
        addRowButton.setFocusPainted(false);
        addRowButton.setIcon(plusIcon);

        addRowButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    /**
                     * Abre o formulario de cada classe de acordo com o atributo
                     */
                    if(classe.equals("Livro"))
                        new FormLivro(essaLista, colunas);
                    else if(classe.equals("Aluno"))
                        new FormAluno(essaLista, colunas);
                    else if(classe.equals("Funcionario"))
                        new FormFuncionario(essaLista, colunas);
                    else if(classe.equals("Autor"))
                        new FormAutor(essaLista, colunas);
                    else if(classe.equals("Emprestimo"))
                        new FormEmprestimo(essaLista, colunas);
                }
            }
        );

        ImageIcon xIcon = new ImageIcon("xIcon.png");
        Image image2 = xIcon.getImage();
        Image newImg2 = image2.getScaledInstance(25, 25,  Image.SCALE_SMOOTH);
        xIcon = new ImageIcon(newImg2);

        JButton removeRowButton = new JButton("Remover");
        removeRowButton.setFocusPainted(false);
        removeRowButton.setIcon(xIcon);

        removeRowButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(tabela.getSelectedRow() != -1) {
                        int confirm = JOptionPane.showConfirmDialog(null, "Deseja remover a linha selecionada?", "Confirmar", JOptionPane.YES_NO_OPTION);
                        /**
                         * Remove a linha selecionada e os dados da lista da classe
                         */
                        if(confirm == JOptionPane.YES_OPTION) {
                            int row = sorter.convertRowIndexToModel(tabela.getSelectedRow());
                            tableModel.removeRow(row);
                            if(classe.equals("Aluno")) {
                                Data.alunos.remove(row);
                            }
                            if(classe.equals("Livro")) {
                                Data.livros.remove(row);
                            }                                
                            if(classe.equals("Funcionario")) {
                                Data.funcionarios.remove(row);
                            } 
                            if(classe.equals("Autor")) {
                                Data.autores.remove(row);
                            } 
                            if(classe.equals("Emprestimo")) {
                                Data.emprestimos.get(row).getLivro().aumentarQuantidade();
                                Data.emprestimos.remove(row);
                            }
                            try {
                                /**
                                 * Escreve a mudanca realizada (remocao)
                                 */
                                Data.saveData();
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        }

                    }
                }
            }
        );

        toolsPanel.add(addRowButton);
        toolsPanel.add(removeRowButton);

        /**
         * Barra de pesquisa
         */
        JPanel searchPanel = new JPanel();
        searchPanel.setBorder(BorderFactory.createEmptyBorder(0,20,10,20));
        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.X_AXIS));
        searchPanel.setMaximumSize(new Dimension(Short.MAX_VALUE, 20));

        JLabel searchLabel = new JLabel("Buscar:");

        searchTextField = new JTextField(20);

        JComboBox<String> columnList = new JComboBox<String>(colunas);

        searchTextField.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                newFilter(columnList.getSelectedIndex());
            }
            public void removeUpdate(DocumentEvent e) {
                newFilter(columnList.getSelectedIndex());
            }
            public void insertUpdate(DocumentEvent e) {
                newFilter(columnList.getSelectedIndex());
            }
        });

        searchPanel.add(columnList);
        searchPanel.add(Box.createHorizontalStrut(5));
        searchPanel.add(searchLabel);
        searchPanel.add(Box.createHorizontalStrut(5));
        searchPanel.add(searchTextField);

        /**
         * Adicionando os componentes e o painel na janela principal
         */
        listaPanel.add(toolsPanel);
        listaPanel.add(searchPanel);
        listaPanel.add(barraRolagem);

        add(listaPanel);
        
        /**
         * Preparando a janela principal
         */
        setSize(450,450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        start();
    }

    /**
     * Inicializa a lista, adicionando as linhas de acordo com os dados das listas de Data
     */
    private void start() {

        tableModel.setRowCount(0);

        if(classe.equals("Aluno")) {
            for(Aluno a : Data.alunos) {
                tableModel.addRow(a.toArray());
            }
        }
        if(classe.equals("Livro")) {
            for(Livro a : Data.livros) {
                tableModel.addRow(a.toArray());
            }
        } 
        if(classe.equals("Funcionario")) {
            for(Funcionario a : Data.funcionarios) {
                tableModel.addRow(a.toArray());
            }
        } 
        if(classe.equals("Autor")) {
            for(Autor a : Data.autores) {
                tableModel.addRow(a.toArray());
            }
        } 
        if(classe.equals("Emprestimo")) {
            for(Emprestimo a : Data.emprestimos) {

                SimpleDateFormat f = new SimpleDateFormat("dd/MM");
                Object[] array = a.toArray();
                array[3] = f.format(array[3]);
                array[4] = f.format(array[4]);

                tableModel.addRow(array);

            }
        } 
    }

    /**
     *  Abre/Reabre a janela com as configuracoes originais
     */
    public void open() {
        start();
        sorter.setSortKeys(null);
        searchTextField.setText("");
        setSize(450,450);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Abre a janela ou a foca se ja estiver aberta
     */
    public void requestOpen() {
        if(!isVisible()) {
            open();
        }
        else {
            toFront();
            requestFocus();
        }
    }

    /**
     * Metodo para realizar a filtragem na barra de pesquisa
     */
    private void newFilter(int column) {
        RowFilter<DefaultTableModel, Object> rf = null;
        try {
            rf = RowFilter.regexFilter(searchTextField.getText(), column);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        sorter.setRowFilter(rf);
    }
}
