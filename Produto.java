//Objetivo da classe PRODUTOS é guardar informações
// Estrutura principal
//Produto será a representação da roupa
// utilizando o private para o encapsulamento.


public class Produto {
//Atributos
        private int id;
        private String nome;
        private String marca;
        private String tamanho;
        private String cor;
        private double preco;
        private int quantidade;

//Construtores
//Construtor vazio

public Produto (){} // construtor vazio

//Construtor completo
public Produto (String nome,String marca,String tamanho,String cor, double preco, int quantidade){
}

//Construtor com o Id
public Produto (int id){}

// Métodos getters e Setters

public int getId (){
    return id;
}
public void setId( int id){
    this.id=id;
}

public String getNome (){
    return nome;
}

public void setNome(String nome){
    this.nome=nome;
    }

public String getMarca(){
    return marca;
}

public void setMarca(String marca) {
    this.marca = marca;
}

public String getTamanho(){
    return tamanho;
}

public void setTamanho(String tamanho){
    this.tamanho=tamanho;
}

public String getCor(){
    return cor;
}
public void setCor(String cor){
    this.cor=cor;
}

public double getPreco(){
    return preco;
}
public void setPreco( double preco){
    this.preco=preco;
}

public int getQuantidade(){
    return quantidade;
}
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}





