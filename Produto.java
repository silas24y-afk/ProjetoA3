public class Produto {

    private static int proximoId = 1;

    //Private serve para o encapsulamento
    private int id;
    private String nome;
    private String peca_roupa;
    private String marca;
    private String tamanho;
    private String cor;
    private double preco;
    private int quantidade;


    //Construtor vazio, boa prática e para quando usarmos framework
    public Produto() {
    }

    //Construtor com paramêtros
    public Produto(String nome, String peca_roupa, String marca, String tamanho,
                   String cor, double preco, int quantidade) {

        //Usado para diferenciar o atributo da classe do paramêtro do método ou construr

        this.id = proximoId++;
        this.nome = nome;
        this.peca_roupa = peca_roupa;
        this.marca = marca;
        this.tamanho = tamanho;
        this.cor = cor;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public Produto(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPeca_roupa() {
        return peca_roupa;
    }
    public void setPeca_roupa(String peca_roupa) {

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

    @Override
    public String toString() {
        return "ID: " + id +
                "\nNome: " + nome +
                "\nPeça de Roupa: " + peca_roupa +
                "\nMarca: " + marca +
                "\nTamanho: " + tamanho +
                "\nCor: " + cor +
                "\nPreço: R$ " + preco +
                "\nQuantidade: " + quantidade;
    }
}
