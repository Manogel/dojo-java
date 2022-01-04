import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class LojaTest {
    private Produto produto = new Produto("Arroz", 10, 4);
    private Loja loja;

    /**
     * Setup das variaveis globais utilizadas (A nível de classe)
     */
    @BeforeEach
    void setUp() {
        this.loja = new Loja();
        this.produto = new Produto("Arroz", 10, 4);
    }

    /**
     * Deve adicionar um produto na loja
     */
    @Test
    void addProduto() {
        List<Produto> cart = this.loja.getProdutos();
        assertEquals(cart.size(), 0);

        this.loja.addProduto(this.produto);
        List<Produto> cartUpdated = this.loja.getProdutos();

        assertEquals(cartUpdated.size(), 1);
        assertEquals(cartUpdated.get(0), this.produto);
    }

    /**
     * Deve remover um produto da loja
     */
    @Test
    void removeProduto() throws Exception {
        Produto produto2 = new Produto("Feijao", 2, 8);
        this.loja.addProduto(this.produto);
        this.loja.addProduto(produto2);

        Produto isExists = this.loja.Busca(produto2.nome);
        assertNotNull(isExists);

        Boolean isRemoved = this.loja.RemoveProduto(produto2.nome);
        assertTrue(isRemoved);
        
        Exception exception = assertThrows(Exception.class, () -> {
            this.loja.Busca(produto2.nome);
        } );
        String expectedErrorMessage = "Produto não encontrado";
        String errorMessage = exception.getMessage();

        assertEquals(expectedErrorMessage, errorMessage);
    }

    /**
     * Contar se os produtos estão sendo
     * adicionados na loja 
     * @throws Exception
     */
    @Test
    void countAllProductsAdded() throws Exception{
        var cart = this.loja.getProdutos();
        assertEquals(cart.size(), 0);

        this.loja.addProduto(this.produto);
        cart = this.loja.getProdutos();
        var isExists = this.loja.Busca(this.produto.nome);
        assertEquals(cart.size(), 1);
        assertNotNull(isExists);

        Produto produto2 = new Produto("Feijao", 2, 8);
        this.loja.addProduto(produto2);
        cart = this.loja.getProdutos();
        isExists = this.loja.Busca(produto2.nome);
        assertEquals(cart.size(), 2);
        assertNotNull(isExists);
    }

    /**
     * Encontrar um produto especifico adicionado
     * @throws Exception
     */
    @Test
    void findOneProductAdded() throws Exception {
        var cart = this.loja.getProdutos();
        assertEquals(cart.size(), 0);
        
        this.loja.addProduto(this.produto);
        Produto produto2 = new Produto("Feijao", 2, 8);
        this.loja.addProduto(produto2);
        assertEquals(cart.size(), 2);
    
        Produto isExists = this.loja.Busca(produto2.nome);
        assertNotNull(isExists);
    }

    /**
     * Deve procurar um produto que nao existe na loja
     * e verificar se foi retornado um erro
     */
    @Test
    void findOneProductNotExists() {
        var cart = this.loja.getProdutos();
        assertEquals(cart.size(), 0);
        
        this.loja.addProduto(this.produto);
        Produto produto2 = new Produto("Feijao", 2, 8);
        this.loja.addProduto(produto2);
        assertEquals(cart.size(), 2);
        
        Produto produtoInexistente = new Produto("Feijao diferente", 20, 80);

        Exception exception = assertThrows(Exception.class, () -> {
            this.loja.Busca(produtoInexistente.nome);
        } );

        String expectedErrorMessage = "Produto não encontrado";
        String errorMessage = exception.getMessage();

        assertEquals(expectedErrorMessage, errorMessage);
    }

    /**
     * Deve editar Preço de Quantidade de um produto
     * existente na loja
     */
    @Test
    void editProduct() throws Exception{
        var cart = this.loja.getProdutos();
        assertEquals(cart.size(), 0);

        this.loja.addProduto(this.produto);
        cart = this.loja.getProdutos();
        assertEquals(cart.size(), 1);

        Produto produto2 = new Produto("Feijao", 2, 8);
        this.loja.addProduto(produto2);
        cart = this.loja.getProdutos();
        assertEquals(cart.size(), 2);
        
        Produto isExists = this.loja.Busca(produto2.nome);

        int novoPreco = 40;
        int novaQuantidade = 4;

        isExists.setPreco(novoPreco);
        isExists.setQuant(novaQuantidade);

        assertEquals(isExists.nome, produto2.nome);
        assertEquals(novoPreco, produto2.preco);
        assertEquals(novaQuantidade, produto2.quant);
    }
}