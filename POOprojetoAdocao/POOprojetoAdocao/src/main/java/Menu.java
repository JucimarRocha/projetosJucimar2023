import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class Menu extends JFrame {

    private GerenciamentoAdocao sistema = new GerenciamentoAdocao();

    JTextField txtNome = new JTextField();

    JTextField txtTamanho = new JTextField();

    JTextField txtEspecie = new JTextField();

    JTextField txtComportamento = new JTextField();

    JTextField txtRaca = new JTextField();

    GravadorDeAnimal gravadorDeAnimal = new GravadorDeAnimal();

    public Menu() {
        try {
            sistema.setAnimais(gravadorDeAnimal.recuperarAnimal());
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }


        setTitle("Menu");
        setLayout(null);
        setResizable(false);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);


        JButton btnCadastrarTela = new JButton("Cadastrar");
        btnCadastrarTela.setBounds(135, 60, 100, 30);
        btnCadastrarTela.setForeground(Color.red);
        btnCadastrarTela.setBackground(Color.black);
        add(btnCadastrarTela);

        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(135, 210, 100, 30);
        btnExcluir.setForeground(Color.red);
        btnExcluir.setBackground(Color.black);
        add(btnExcluir);

        JButton btnPesquisarPorTamanho = new JButton("Pesquisar");
        btnPesquisarPorTamanho.setBounds(135, 160, 100, 30);
        btnPesquisarPorTamanho.setForeground(Color.red);
        btnPesquisarPorTamanho.setBackground(Color.black);
        add(btnPesquisarPorTamanho);

        JButton btnAtualizar = new JButton("Atualizar");
        btnAtualizar.setBounds(135, 110, 100, 30);
        btnAtualizar.setForeground(Color.red);
        btnAtualizar.setBackground(Color.black);
        add(btnAtualizar);

        JButton btnListar = new JButton("Listar");
        btnListar.setBounds(135, 260, 100, 30);
        btnListar.setForeground(Color.red);
        btnListar.setBackground(Color.black);
        add(btnListar);

        JButton btnSair = new JButton("Sair");
        btnSair.setBounds(135, 300, 100, 30);
        btnSair.setForeground(Color.red);
        btnSair.setBackground(Color.black);
        add(btnSair);

        BufferedImage img;
        Image instImage;
        try {
            img = ImageIO.read(new File("src" + File.separator + "main" + File.separator +
                    "java" + File.separator + "imagens" + File.separator + "fundoPetShop.png"));

            instImage = img.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
            JLabel image = new JLabel();
            ImageIcon imageIcon = new ImageIcon(instImage);
            image.setBounds(-14, 0, this.getWidth(), this.getHeight());
            image.setIcon(imageIcon);
            this.add(image);

        } catch (IOException e) {
            e.printStackTrace();
        }

        btnCadastrarTela.addActionListener(this::telaCadastro);
        btnAtualizar.addActionListener(this::telaAtualizar);
        btnPesquisarPorTamanho.addActionListener(this::telaPesquisa);
        btnExcluir.addActionListener(this::telaExcluir);
        btnListar.addActionListener(this::listar);
        btnSair.addActionListener(this::Sair);

    }

    /*MÉTODO DA TELA DE CADASTRO*/
    private void telaCadastro(ActionEvent e) {
        setVisible(false);
        JDialog telaCadastrar = new JDialog();
        telaCadastrar.setTitle("Registrar Produtos");
        telaCadastrar.setLayout(null);
        telaCadastrar.setResizable(false);
        telaCadastrar.setSize(200, 300);
        telaCadastrar.setLocationRelativeTo(null);
        telaCadastrar.setModal(true);


        JLabel labelNome = new JLabel("Nome:");
        labelNome.setBounds(25, 20, 140, 20);
        labelNome.setFont(new Font("Times New Roman", Font.BOLD, 12));
        labelNome.setForeground(Color.red);
        telaCadastrar.add(labelNome);

        txtNome.setLayout(new FlowLayout());
        txtNome.setBounds(25, 40, 140, 20);
        txtNome.setFont(new Font("Times New Roman", Font.BOLD, 12));
        txtNome.setForeground(Color.black);
        telaCadastrar.add(txtNome);

        JLabel labelTamanho = new JLabel("Tamanho:");
        labelTamanho.setBounds(25, 60, 140, 20);
        labelTamanho.setFont(new Font("Times New Roman", Font.BOLD, 12));
        labelTamanho.setForeground(Color.red);
        telaCadastrar.add(labelTamanho);

        txtTamanho.setLayout(new FlowLayout());
        txtTamanho.setBounds(25, 80, 140, 20);
        txtTamanho.setFont(new Font("Times New Roman", Font.BOLD, 12));
        txtTamanho.setForeground(Color.black);
        telaCadastrar.add(txtTamanho);

        JLabel labelEspecie = new JLabel("Especie:");
        labelEspecie.setBounds(25, 100, 140, 20);
        labelEspecie.setFont(new Font("Times New Roman", Font.BOLD, 12));
        labelEspecie.setForeground(Color.red);
        telaCadastrar.add(labelEspecie);

        txtEspecie.setLayout(new FlowLayout());
        txtEspecie.setBounds(25, 120, 140, 20);
        txtEspecie.setFont(new Font("Times New Roman", Font.BOLD, 12));
        txtEspecie.setForeground(Color.black);
        telaCadastrar.add(txtEspecie);

        JLabel labelRaca = new JLabel("Raca:");
        labelRaca.setBounds(25, 140, 140, 20);
        labelRaca.setFont(new Font("Times New Roman", Font.BOLD, 12));
        labelRaca.setForeground(Color.red);
        telaCadastrar.add(labelRaca);

        txtRaca.setLayout(new FlowLayout());
        txtRaca.setBounds(25, 160, 140, 20);
        txtRaca.setFont(new Font("Times New Roman", Font.BOLD, 12));
        txtRaca.setForeground(Color.black);
        telaCadastrar.add(txtRaca);

        JLabel labelComportamento = new JLabel("Comportamento:");
        labelComportamento.setBounds(25, 180, 140, 20);
        labelComportamento.setFont(new Font("Times New Roman", Font.BOLD, 12));
        labelComportamento.setForeground(Color.red);
        telaCadastrar.add(labelComportamento);

        txtComportamento.setLayout(new FlowLayout());
        txtComportamento.setBounds(25, 200, 140, 20);
        txtComportamento.setFont(new Font("Times New Roman", Font.BOLD, 12));
        txtComportamento.setForeground(Color.black);
        telaCadastrar.add(txtComportamento);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(40, 220, 100, 30);
        btnCadastrar.setForeground(Color.red);
        btnCadastrar.setBackground(Color.black);
        telaCadastrar.add(btnCadastrar);


        BufferedImage img;
        Image instImage;
        try {
            img = ImageIO.read(new File("src" + File.separator + "main" + File.separator +
                    "java" + File.separator + "imagens" + File.separator + "fundoPetShop.png"));

            instImage = img.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
            JLabel image = new JLabel();
            ImageIcon imageIcon = new ImageIcon(instImage);
            image.setBounds(-14, 0, this.getWidth(), this.getHeight());
            image.setIcon(imageIcon);
            telaCadastrar.add(image);

        } catch (IOException w) {
            w.printStackTrace();
        }
        btnCadastrar.addActionListener(this::cadastrar);


        telaCadastrar.setVisible(true);

        setVisible(true);
    }

    /*MÉTODO QUE EFETUA O CADASTRO*/
    private void cadastrar(ActionEvent actionEvent) {
        String nome, tamanho, especie, raca, comportamento;
        try {

            nome = txtNome.getText();
            tamanho = txtTamanho.getText();
            especie = txtEspecie.getText();
            raca = txtRaca.getText();
            comportamento = txtComportamento.getText();

            Animal animal = new Animal(nome, tamanho, especie, raca, comportamento);


            if (sistema.registrarAnimalNaLista(animal)) {
                JOptionPane.showMessageDialog(null, "Cadastrou com sucesso!");
            }

        } catch (NullPointerException a) {
            JOptionPane.showMessageDialog(null, a.getMessage());
        } catch (AnimalInformadoIncorretamenteException ex) {
            JOptionPane.showMessageDialog(null, "Animal informado incorretamente");
        }
    }

    /*TELA DE ATUALIZAR*/
    private void telaAtualizar(ActionEvent e){
        setVisible(false);
        JDialog telaAtualizar = new JDialog();
        telaAtualizar.setTitle("Registrar Produtos");
        telaAtualizar.setLayout(null);
        telaAtualizar.setResizable(false);
        telaAtualizar.setSize(200, 300);
        telaAtualizar.setLocationRelativeTo(null);
        telaAtualizar.setModal(true);


        JLabel labelNome = new JLabel("Nome:");
        labelNome.setBounds(25, 0, 140, 20);
        labelNome.setFont(new Font("Times New Roman", Font.BOLD, 12));
        labelNome.setForeground(Color.red);
        telaAtualizar.add(labelNome);

        txtNome.setLayout(new FlowLayout());
        txtNome.setBounds(25, 20, 140, 20);
        txtNome.setFont(new Font("Times New Roman", Font.BOLD, 12));
        txtNome.setForeground(Color.black);
        telaAtualizar.add(txtNome);

        JLabel labelTamanho = new JLabel("Tamanho:");
        labelTamanho.setBounds(25, 40, 140, 20);
        labelTamanho.setFont(new Font("Times New Roman", Font.BOLD, 12));
        labelTamanho.setForeground(Color.red);
        telaAtualizar.add(labelTamanho);

        txtTamanho.setLayout(new FlowLayout());
        txtTamanho.setBounds(25, 60, 140, 20);
        txtTamanho.setFont(new Font("Times New Roman", Font.BOLD, 12));
        txtTamanho.setForeground(Color.black);
        telaAtualizar.add(txtTamanho);

        JLabel labelEspecie = new JLabel("Especie:");
        labelEspecie.setBounds(25, 80, 140, 20);
        labelEspecie.setFont(new Font("Times New Roman", Font.BOLD, 12));
        labelEspecie.setForeground(Color.red);
        telaAtualizar.add(labelEspecie);

        txtEspecie.setLayout(new FlowLayout());
        txtEspecie.setBounds(25, 100, 140, 20);
        txtEspecie.setFont(new Font("Times New Roman", Font.BOLD, 12));
        txtEspecie.setForeground(Color.black);
        telaAtualizar.add(txtEspecie);

        JLabel labelComportamento = new JLabel("Comportamento:");
        labelComportamento.setBounds(25, 120, 140, 20);
        labelComportamento.setFont(new Font("Times New Roman", Font.BOLD, 12));
        labelComportamento.setForeground(Color.red);
        telaAtualizar.add(labelComportamento);

        txtComportamento.setLayout(new FlowLayout());
        txtComportamento.setBounds(25, 140, 140, 20);
        txtComportamento.setFont(new Font("Times New Roman", Font.BOLD, 12));
        txtComportamento.setForeground(Color.black);
        telaAtualizar.add(txtComportamento);

        JLabel labelRaca = new JLabel("Raca:");
        labelRaca.setBounds(25, 160, 140, 20);
        labelRaca.setFont(new Font("Times New Roman", Font.BOLD, 12));
        labelRaca.setForeground(Color.red);
        telaAtualizar.add(labelRaca);

        txtRaca.setLayout(new FlowLayout());
        txtRaca.setBounds(25, 180, 140, 20);
        txtRaca.setFont(new Font("Times New Roman", Font.BOLD, 12));
        txtRaca.setForeground(Color.black);
        telaAtualizar.add(txtRaca);

        JButton btnAtualizar = new JButton("Atualizar");
        btnAtualizar.setBounds(40, 210, 100, 30);
        btnAtualizar.setForeground(Color.red);
        btnAtualizar.setBackground(Color.black);
        telaAtualizar.add(btnAtualizar);

        BufferedImage img;
        Image instImage;
        try {
            img = ImageIO.read(new File("src" + File.separator + "main" + File.separator +
                    "java" + File.separator + "imagens" + File.separator + "fundoPetShop.png"));

            instImage = img.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
            JLabel image = new JLabel();
            ImageIcon imageIcon = new ImageIcon(instImage);
            image.setBounds(-14, 0, this.getWidth(), this.getHeight());
            image.setIcon(imageIcon);
            telaAtualizar.add(image);

        } catch (IOException w) {
            w.printStackTrace();
        }
        btnAtualizar.addActionListener(this::atualizar);
        telaAtualizar.setVisible(true);


        setVisible(true);
    }

    /*MÉTODO QUE EFETUA A ATUALIZAÇÃO*/
    private void atualizar(ActionEvent e) {
        String nome, tamanho, especie, raca, comportamento;
        try {
            nome = txtNome.getText();
            tamanho = txtTamanho.getText();
            especie = txtEspecie.getText();
            raca = txtRaca.getText();
            comportamento = txtComportamento.getText();

            if (sistema.atualizarInfoAnimal(nome, tamanho, especie, raca, comportamento)){
                JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            }

        } catch (Exception w){
            JOptionPane.showMessageDialog(null, w.getMessage());
        }
    }

    /*SAIR*/
    private void Sair(ActionEvent e) {
        try {
            gravadorDeAnimal.gravaAnimal(sistema.obterListaDeAnimais());
            sistema.sair();
        } catch (Exception w){
            JOptionPane.showMessageDialog(null, w.getMessage());
        }

    }

    /*TELA DE PESQUISA POR TAMANHO*/
    private void telaPesquisa(ActionEvent e){
        setVisible(false);
        JDialog telaPesquisa = new JDialog();
        telaPesquisa.setTitle("Pesquisar por tamanho");
        telaPesquisa.setLayout(null);
        telaPesquisa.setResizable(false);
        telaPesquisa.setSize(200, 300);
        telaPesquisa.setLocationRelativeTo(null);
        telaPesquisa.setModal(true);

        JLabel labelTamanho = new JLabel("Pesquisar por tamanho:");
        labelTamanho.setBounds(25, 40, 140, 20);
        labelTamanho.setFont(new Font("Times New Roman", Font.BOLD, 12));
        labelTamanho.setForeground(Color.red);
        telaPesquisa.add(labelTamanho);

        txtTamanho.setLayout(new FlowLayout());
        txtTamanho.setBounds(25, 60, 140, 20);
        txtTamanho.setFont(new Font("Times New Roman", Font.BOLD, 12));
        txtTamanho.setForeground(Color.black);
        telaPesquisa.add(txtTamanho);

        JButton btnPesquisar = new JButton("Atualizar");
        btnPesquisar.setBounds(40, 210, 100, 30);
        btnPesquisar.setForeground(Color.red);
        btnPesquisar.setBackground(Color.black);
        telaPesquisa.add(btnPesquisar);

        BufferedImage img;
        Image instImage;
        try {
            img = ImageIO.read(new File("src" + File.separator + "main" + File.separator +
                    "java" + File.separator + "imagens" + File.separator + "fundoPetShop.png"));

            instImage = img.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
            JLabel image = new JLabel();
            ImageIcon imageIcon = new ImageIcon(instImage);
            image.setBounds(-14, 0, this.getWidth(), this.getHeight());
            image.setIcon(imageIcon);
            telaPesquisa.add(image);
        } catch (IOException w) {
            w.printStackTrace();
        }
        btnPesquisar.addActionListener(this::pesquisar);
        telaPesquisa.setVisible(true);
        setVisible(true);
    }

    /*MÉTODO QUE REALIZA A PESQUISA*/
    private void pesquisar(ActionEvent e){
        String tamanho;
        try {
            tamanho = txtTamanho.getText();

            JOptionPane.showMessageDialog(null, sistema.pesquisarAnimalPeloTamanho(tamanho));
        } catch (Exception w){
            JOptionPane.showMessageDialog(null, w.getMessage());
        }
    }

    /*TELA EXCLUIR*/
    private void telaExcluir(ActionEvent e){
        setVisible(false);
        JDialog telaExcluir = new JDialog();
        telaExcluir.setTitle("Excluir");
        telaExcluir.setLayout(null);
        telaExcluir.setResizable(false);
        telaExcluir.setSize(200, 300);
        telaExcluir.setLocationRelativeTo(null);
        telaExcluir.setModal(true);

        JLabel labelTamanho = new JLabel("Nome:");
        labelTamanho.setBounds(25, 40, 140, 20);
        labelTamanho.setFont(new Font("Times New Roman", Font.BOLD, 12));
        labelTamanho.setForeground(Color.red);
        telaExcluir.add(labelTamanho);

        txtTamanho.setLayout(new FlowLayout());
        txtTamanho.setBounds(25, 60, 140, 20);
        txtTamanho.setFont(new Font("Times New Roman", Font.BOLD, 12));
        txtTamanho.setForeground(Color.black);
        telaExcluir.add(txtTamanho);

        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(40, 210, 100, 30);
        btnExcluir.setForeground(Color.red);
        btnExcluir.setBackground(Color.black);
        telaExcluir.add(btnExcluir);


        btnExcluir.addActionListener(this::excluir);
        telaExcluir.setVisible(true);
        setVisible(true);
    }

    /*MÉTODO QUE EXCLUI*/
    private void excluir(ActionEvent e) {
        String nome;
        nome = txtNome.getText();
        if(sistema.deletarAnimal(nome)) {
            JOptionPane.showMessageDialog(null, "Excluido");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao excluir");
        }

    }

    /*MÉTODO QUE FAZ A LISTAGEM*/
    private void listar(ActionEvent e){
        try {
            JOptionPane.showMessageDialog(null, sistema.obterTextoComListaDeAnimais(sistema.getAnimais()));
        } catch (Exception w){
            JOptionPane.showMessageDialog(null, w.getMessage());
        }

    }
}