import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Loja {
    protected List<Produto> produtos;

    public Loja() {
        this.produtos = new ArrayList<>();
    }

    public void addProduto (Produto produto) {
        this.produtos.add(produto);
    }

    public boolean RemoveProduto(String nomeProduto) {
        for(Produto p : this.produtos) {
            if (p.getName().equals(nomeProduto)) {
                this.produtos.remove(p);
                return true;
            }
        }
        return false;
    }

    /**
     * Nova funcionalidade:
     * - Retornar a lista de produtos da loja
     */
    public List<Produto> getProdutos () {
       return Collections.unmodifiableList(this.produtos);
    }

    public void MostraProdutos(String nome) {
        if (this.Quantidade() > 0) {
            for (Produto p : this.produtos) {
                if (p.getName().equals(nome)) {
                    System.out.println(p);
                }
            }
        } else {
            System.out.println("Carrinho de Compras Vazio.\n");
        }
    }

    public int Quantidade() {
        return this.produtos.size();
    }

    /**
     * Refatoração:
     * - Retorna o produto se encontrado
     * - Retorna um erro se o produto não for encontrado
     */
    public Produto Busca (String nomeProduto) throws Exception {
        for(Produto p : this.produtos) {
            if (p.getName().equals(nomeProduto)) {
                return p;
            }
        }
        throw new Exception("Produto não encontrado");
    }

    public void ListaTudo () {
        for (Produto p : this.produtos) {
            System.out.println(p);
        }
        System.out.println();
    }
}