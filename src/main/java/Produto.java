public class Produto {

    protected String nome;

    protected int quant;

    protected float preco;

    public static int ID = 1;

    public Produto(String nome, int quantidade, float preco) {
        super();
        this.nome = nome;
        this.quant = quantidade;
        this.preco = preco;
    }

    public String getName() {
        return nome;
    }

    public void setName(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quantidade) {
        this.quant = quantidade;
    }


    @Override
    public String toString() {
        return "Nome do Produto =" + nome + "\nquantidade=" + quant + "\npreco=" + preco + "]";
    }


}