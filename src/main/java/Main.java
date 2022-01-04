import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Loja loja = new Loja();
        int opcao;
        String confirm;
        Scanner in = new Scanner(System.in);
        String nomeProduto;

        System.out.println("Loja XPTO online \n\n");
        System.out.println("Logado como: Operdador Teste\n\n");
        while (true) {
            System.out.println("Pressione:\n\t1 - Adicionar produtos\n\t2 - Excluir Produtos\n\t3 - Exibir produtos\n\t4 - Procurar produto\n\t5 - Editar produto\n\t6 - Sair\nopcao: ");
            opcao = in.nextByte();
            switch (opcao) {
                case 1:
                    String nome;
                    int quantidade;
                    float preco;
                    System.out.println("Nome do Produto a ser Adicionado: ");
                    nome = in.next();
                    System.out.println("Quantidade do produto:");
                    quantidade = in.nextInt();
                    System.out.println("Preco unitario: ");
                    preco = in.nextFloat();
                    Produto p = new Produto(nome, quantidade, preco);
                    loja.addProduto(p);
                    System.out.println("Produto Adicionado");
                    break;
                case 2:
                    System.out.println("Nome do Produto a ser Removido: ");
                    nomeProduto = in.next();
                    try {
                        loja.Busca(nomeProduto);
                        System.out.println("\n (y/n) Realmente deseja remover esse produto?" + nomeProduto);
                        confirm = in.next();
                        if (confirm.equals("y")) {
                            if (loja.RemoveProduto(nomeProduto)) {
                                System.out.println("Produto" + nomeProduto + "Removido" );
                            }
                        } else {
                            System.out.println("Operacao Cancelada\n");
                        }
                    } catch (Exception e) {
                        System.out.println("Produto: " + nomeProduto + "nao encontrado");
                    }
                    break;

                case 3:
                    System.out.println("A loja XPTO tem os Seguintes Produtos:\n");
                    loja.ListaTudo();
                    break;
                case 4:
                    System.out.println("Qual o nome do produto a ser buscado: ");
                    nomeProduto = in.next();
                    try {
                        loja.Busca(nomeProduto);
                        System.out.println("Produto" + nomeProduto + "encontrado\n");
                        loja.MostraProdutos(nomeProduto);
                    } catch (Exception e) {
                        System.out.println("Produto" + nomeProduto + "n�o encontado");
                    }
                    break;
                /**
                 * Nova Funcionalidade:
                 * - Editar um produto
                 * - Busca o produto pelo nome
                 * - Altera quantidade e preço do produto
                 */ 
                case 5:
                    System.out.println("Nome do Produto a ser Editado: ");
                    nome = in.next();
                    try {
                        Produto produtoExistente = loja.Busca(nome);
                        System.out.println("Nova quantidade do produto:");

                        quantidade = in.nextInt();
                        System.out.println("Preco unitario: ");
                        preco = in.nextFloat();

                        produtoExistente.setPreco(preco);
                        produtoExistente.setQuant(quantidade);
                        System.out.println("Produto editado :)");
                    } catch (Exception e) {
                        System.out.println("Produto" + nome + "não encontado");
                    }
                    break;
                /**
                 * Correção de defeito:
                 * - Interpretação do comando de saída
                 */ 
                case 6:
                    System.exit(0);
                default:
            }
        }
    }
}
