public class ProdutoEletronico extends Produto {
    public ProdutoEletronico(String nome, double preco) {
        super(nome, preco);
    }

    @Override
    public double calcularDesconto(double porcentagem) {
        if (preco > 2500) {
            return preco - (preco * (porcentagem / 100));
        } else {
            return preco - (preco * (porcentagem / 100 / 2));
        }
    }
}
