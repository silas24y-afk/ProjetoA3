//Objetivo da classe PRODUTOS é guardar informações
// Estrutura principal
//Produto será a representação da roupa
// utilizando o private para o encapsulamento.


public class Produto {

    // Controle automático do ID
    private static int proximoId = 1;

    // Atributos
    private int id;
    private String nome;
    private String marca;
    private String tamanho;
    private String cor;
    private double preco;
    private int quantidade;

    // Construtor vazio
    public Produto() {
    }

    // Construtor completo
    public Produto(String nome, String marca, String tamanho,
                   String cor, double preco, int quantidade) {

        this.id = proximoId++;

        this.nome = nome;
        this.marca = marca;
        this.tamanho = tamanho;
        this.cor = cor;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    // Construtor utilizado para pesquisa
    public Produto(int id) {
        this.id = id;
    }

    // Getters e Setters

    public int getId() {
        return id;
    }

    // Opcional: pode remover este setter para evitar alteração manual do ID
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
