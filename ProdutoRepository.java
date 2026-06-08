public class ProdutoRepository implements ProdutoCRUD {

    private Produto[] produtos;
    private int quantidade;

    // Construtor
    public ProdutoRepository() {
        produtos = new Produto[10];
        quantidade = 0;
    }

    // Método privado para aumentar o tamanho do array em 50%
    private void aumentarArray() {
        int novoTamanho = produtos.length + (produtos.length / 2);

        Produto[] novoArray = new Produto[novoTamanho];

        for (int i = 0; i < produtos.length; i++) {
            novoArray[i] = produtos[i];
        }

        produtos = novoArray;
    }

    // Método privado para localizar a posição do produto
    private int pesquisarIndice(int id) {

        for (int i = 0; i < quantidade; i++) {

            if (produtos[i] != null &&
                    produtos[i].getId() == id) {

                return i;
            }
        }

        return -1;
    }

    @Override
    public boolean inserir(Produto produto) {

        if (quantidade == produtos.length) {
            aumentarArray();
        }

        produtos[quantidade] = produto;
        quantidade++;

        return true;
    }

    @Override
    public Produto pesquisar(Produto produto) {

        int indice = pesquisarIndice(produto.getId());

        if (indice != -1) {
            return produtos[indice];
        }

        return null;
    }

    @Override
    public boolean remover(int id) {

        int indice = pesquisarIndice(id);

        if (indice == -1) {
            return false;
        }

        // Desloca os elementos para a esquerda
        for (int i = indice; i < quantidade - 1; i++) {
            produtos[i] = produtos[i + 1];
        }

        produtos[quantidade - 1] = null;
        quantidade--;

        return true;
    }

    @Override
    public boolean atualizarNome(int id, String novoValor) {

        int indice = pesquisarIndice(id);

        if (indice == -1) {
            return false;
        }

        produtos[indice].setNome(novoValor);

        return true;
    }

    @Override
    public boolean atualizarPreco(int id, double preco) {

        int indice = pesquisarIndice(id);

        if (indice == -1) {
            return false;
        }

        produtos[indice].setPreco(preco);

        return true;
    }
}
