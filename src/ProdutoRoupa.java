public class ProdutoRoupa extends Produto {
    public ProdutoRoupa(String nome, double preco) {
        super(nome, preco);
    }

    @Override
    public double calcularDesconto(double porcentagem) {
        return preco - (preco * (porcentagem / 50));
    }
}
