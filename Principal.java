import javax.swing.JOptionPane;//É uma classe que permite criar janelas simples para interação com o usuário.

public class Principal {

    public static void main(String[] args) {

        ProdutoRepository dao = new ProdutoRepository();

        int opcao=0;

        do {
            try {
                String menu =
                        "=== Estoque De Roupas ===\n\n" +
                                "1 - Inserir Produto\n" +
                                "2 - Pesquisar Produto\n" +
                                "3 - Atualizar Nome\n" +
                                "4 - Atualizar Preço\n" +
                                "5 - Remover Produto\n" +
                                "6 - Listar Produtos\n" +
                                "0 - Sair";
                opcao = Integer.parseInt(
                        JOptionPane.showInputDialog(menu));

                switch (opcao) {

                    case 1:

                        boolean nomeInvalido = true;

                        String nome = JOptionPane.showInputDialog("Nome:");
                        while(nomeInvalido) {
                            if (nome == null) {
                                JOptionPane.showMessageDialog(null, "Preencha o nome!");
                                continue;
                            }
                            if (nome.length() < 3) {
                                JOptionPane.showMessageDialog(null, "Nome com caracteres inválidos");
                                nome = JOptionPane.showInputDialog("Digite um nome válido:");
                            } else {
                                nomeInvalido = false;
                            }
                        }

                        String menuPecas = "Escolha a Peça de Roupa:\n1 - Calça\n2 - Camiseta\n3 - Jaqueta";
                        String entradaPeca = JOptionPane.showInputDialog(menuPecas);
                        int peca_roupa = Integer.parseInt(entradaPeca);

                        String pecaNome = "";

                        // CORREÇÃO: Atribuindo os valores corretos para pecaNome em cada case
                        switch (peca_roupa) {
                            case 1:
                                pecaNome = "Calça";
                                JOptionPane.showMessageDialog(null, "1 - Calça");
                                break;
                            case 2:
                                pecaNome = "Camiseta"; // Adicionado
                                JOptionPane.showMessageDialog(null, "2 - Camiseta");
                                break;
                            case 3:
                                pecaNome = "Jaqueta"; // Adicionado
                                JOptionPane.showMessageDialog(null, "3 - Jaqueta");
                                break;
                            default:
                                pecaNome = "Inválido";
                                JOptionPane.showMessageDialog(null, "Opção inválida");
                        }

                        String menuMarca = "Escolha a Peça de Roupa:\n1 - Nike\n2 - Adidas\n3 - New Balance";
                        String entradaMarca = JOptionPane.showInputDialog(menuMarca);
                        int marca = Integer.parseInt(entradaMarca);

                        String MarcaRoupa = "";

                        // CORREÇÃO: Atribuindo os valores corretos para pecaNome em cada case
                        switch (marca) {
                            case 1:
                                MarcaRoupa = "Calça";
                                JOptionPane.showMessageDialog(null, "1 - Nike");
                                break;
                            case 2:
                                MarcaRoupa = "Camiseta"; // Adicionado
                                JOptionPane.showMessageDialog(null, "2 - Adidas");
                                break;
                            case 3:
                                MarcaRoupa = "Jaqueta"; // Adicionado
                                JOptionPane.showMessageDialog(null, "3 - New Balance");
                                break;
                            default:
                                MarcaRoupa = "Inválido";
                                JOptionPane.showMessageDialog(null, "Opção inválida");
                                JOptionPane.showInputDialog("Digite uma opçao válida:");
                                marca = Integer.parseInt(entradaMarca);
                        }

                        String menuTamanho = "Escolha a Peça de Roupa:\n1 - P\n2 - M\n3 - G";
                        String entradaTamanho = JOptionPane.showInputDialog(menuTamanho);
                        int tamanho = Integer.parseInt(entradaTamanho);

                        String TamanhoRoupa = "";

                        // CORREÇÃO: Atribuindo os valores corretos para pecaNome em cada case
                        switch (tamanho) {
                            case 1:
                                TamanhoRoupa = "Calça";
                                JOptionPane.showMessageDialog(null, "1 - P");
                                break;
                            case 2:
                                TamanhoRoupa = "Camiseta"; // Adicionado
                                JOptionPane.showMessageDialog(null, "2 - M");
                                break;
                            case 3:
                                TamanhoRoupa = "Jaqueta"; // Adicionado
                                JOptionPane.showMessageDialog(null, "3 - M");
                                break;
                            default:
                                TamanhoRoupa = "Inválido";
                                JOptionPane.showMessageDialog(null, "Opção inválida");
                        }

                        String cor = JOptionPane.showInputDialog("Cor:");


                        boolean precoInvalido = true;
                        double preco = 0;
                             preco = Double.parseDouble(JOptionPane.showInputDialog("Preço:"));

                            while (precoInvalido) {
                                if (preco > 0) {
                                    precoInvalido = false;
                                } else {
                                    JOptionPane.showMessageDialog(null, "Produto com valor inválido");
                                    preco = Double.parseDouble(JOptionPane.showInputDialog("Digite um valor válido:"));
                                }
                            }

                        boolean quantidadeinvalida = true;
                        int quantidade = 0;
                        quantidade = Integer.parseInt(JOptionPane.showInputDialog("Quantidade:"));
                        while (quantidadeinvalida) {
                            if (quantidade > 0) {
                                quantidadeinvalida = false;
                            }else {
                        JOptionPane.showMessageDialog(null, "Quantidade inválida");
                                quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite uma quantidade válida:"));
                    }
                }

                        Produto produto = new Produto(
                                nome,
                                pecaNome,
                                MarcaRoupa,
                                TamanhoRoupa,
                                cor,
                                preco,
                                quantidade
                        );

                        dao.inserir(produto);
                         JOptionPane.showMessageDialog(
                                    null,
                                    "Produto cadastrado!\nID: " + produto.getId());
                            break;
                    case 2:

                        int idPesquisa = Integer.parseInt(
                                JOptionPane.showInputDialog("Digite o ID:"));

                        Produto busca = new Produto(idPesquisa);

                        Produto encontrado = dao.pesquisar(busca);

                        if (encontrado != null) {

                            JOptionPane.showMessageDialog(
                                    null,
                                    "ID: " + encontrado.getId() +
                                            "\nNome: " + encontrado.getNome() +
                                            "\nPeça de roupa: " + encontrado.getPeca_roupa() +
                                            "\nMarca: " + encontrado.getMarca() +
                                            "\nTamanho: " + encontrado.getTamanho() +
                                            "\nCor: " + encontrado.getCor() +
                                            "\nPreço: R$ " + encontrado.getPreco() +
                                            "\nQuantidade: " + encontrado.getQuantidade());
                        } else {

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Produto não encontrado!");
                        }

                        break;


                    case 3:

                        int idNome = Integer.parseInt(
                                JOptionPane.showInputDialog(
                                        "Digite o ID do produto:"));


                        boolean nomeInvalido1 = true;

                        String nomeNome = JOptionPane.showInputDialog("Digite um novo nome:");

                        while(nomeInvalido1) {
                            if (nomeNome == null) {
                                JOptionPane.showMessageDialog(null, "Preencha o nome!");
                                continue;
                            }
                            if (nomeNome.length() < 3) {
                                JOptionPane.showMessageDialog(null, "Nome com caracteres inválidos");
                                nomeNome = JOptionPane.showInputDialog("Digite um nome válido:");
                            } else {
                                nomeInvalido1 = false;
                            }
                        }

                        if (dao.atualizarNome(idNome, nomeNome)) {

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Nome atualizado!");

                        } else {

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Produto não encontrado!");
                        }

                        break;

                    case 4:

                        int idPreco = Integer.parseInt(
                                JOptionPane.showInputDialog(
                                        "Digite o ID do produto:"));


                        boolean precoInvalido1 = true;
                        double novoPreco = 0;

                        novoPreco = Double.parseDouble(JOptionPane.showInputDialog("Digite um novo preço:"));

                        while (precoInvalido1) {
                            if (novoPreco > 0) {
                                precoInvalido1 = false;
                            } else {
                                JOptionPane.showMessageDialog(null, "Produto com valor inválido");
                                novoPreco = Double.parseDouble(JOptionPane.showInputDialog("Digite um valor válido:"));
                            }
                        }

                        if (dao.atualizarPreco(idPreco, novoPreco)) {

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Preço atualizado!");

                        } else {

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Produto não encontrado!");
                        }
                        break;

                    case 5:

                        int idRemover;


                        boolean IdInvalido = true;

                        while(IdInvalido){

                            String input = JOptionPane.showInputDialog(null,"Digite um id válido:");

                            if (input == null){
                                break;
                            }

                            idRemover = Integer.parseInt(input);

                                if (dao.remover(idRemover)) {
                                JOptionPane.showMessageDialog(null, "Produto removido!");
                                IdInvalido = false;

                            } else {
                                JOptionPane.showMessageDialog(null, "Produto não encontrado!");
                            }
                        }
                        break;

                    case 6:

                        Produto[] lista = dao.listarProdutos();

                        if (lista.length == 0) {

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Nenhum produto cadastrado!");

                        } else {

                            String mensagem = "";

                            for (Produto p : lista) {

                                mensagem += p.toString()
                                        + "\n\n-------------------------\n\n";
                            }

                            JOptionPane.showMessageDialog(
                                    null,
                                    mensagem);
                        }

                        break;


                    case 0:

                        JOptionPane.showMessageDialog(
                                null,
                                "Sistema encerrado.");

                        break;

                    default:

                        JOptionPane.showMessageDialog(
                                null,
                                "Opção inválida.");
                }
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null,"Escolha uma opção válida!");
            }

        } while (opcao != 0) ;
        }
}
