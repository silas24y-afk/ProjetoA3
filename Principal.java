import javax.swing.JOptionPane;

public class Principal {

    public static void main(String[] args) {

        ProdutoRepository dao = new ProdutoRepository();

        int opcao=0;

        do {
            try {
                String menu =
                        "=== LOJA DE ROUPAS ===\n\n" +
                                "1 - Inserir Produto\n" +
                                "2 - Pesquisar Produto\n" +
                                "3 - Atualizar Nome\n" +
                                "4 - Atualizar Preço\n" +
                                "5 - Remover Produto\n" +
                                "0 - Sair";

                opcao = Integer.parseInt(
                        JOptionPane.showInputDialog(menu));

                switch (opcao) {

                    case 1:

                        String nome = JOptionPane.showInputDialog("Nome:");

                        String marca = JOptionPane.showInputDialog("Marca:");

                        String tamanho = JOptionPane.showInputDialog("Tamanho:");

                        String cor = JOptionPane.showInputDialog("Cor:");

                        double preco = Double.parseDouble(
                                JOptionPane.showInputDialog("Preço:"));

                        int quantidade = Integer.parseInt(
                                JOptionPane.showInputDialog("Quantidade:"));

                        Produto produto = new Produto(
                                nome,
                                marca,
                                tamanho,
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

                        String novoNome = JOptionPane.showInputDialog(
                                "Novo nome:");

                        if (dao.atualizarNome(idNome, novoNome)) {

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

                        double novoPreco = Double.parseDouble(
                                JOptionPane.showInputDialog(
                                        "Novo preço:"));

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

                        int idRemover = Integer.parseInt(
                                JOptionPane.showInputDialog(
                                        "Digite o ID do produto:"));

                        if (dao.remover(idRemover)) {

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Produto removido!");

                        } else {

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Produto não encontrado!");
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
                JOptionPane.showMessageDialog(null,"Escolha uma opção "+ e.getMessage());
            }

        } while (opcao != 0) ;
        }
}
