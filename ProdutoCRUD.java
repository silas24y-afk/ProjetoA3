// Criando interface
//Todos abaixo são métodos
//Usamos boolean para informar se deu certo ou errado

public interface ProdutoCRUD{
    public boolean inserir(Produto produto);//Adiciona um novo produto no array.
    public Produto pesquisar(Produto produto);//Procura um produto pelo ID
    public boolean remover(int id);//Remove um produto do array.
    public boolean atualizarNome(int id, String novoValor);// Altera nome do produto
    boolean atualizarPreco(int id, double preco);//Atualiza preço]
    Produto[] listarProdutos();
}
