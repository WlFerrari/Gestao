import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar produto");
            System.out.println("2. Remover produto");
            System.out.println("3. Exibir preços com desconto");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                System.out.print("Digite o tipo de produto (eletronico/roupa): ");
                String tipo = scanner.nextLine();
                System.out.print("Digite o nome do produto: ");
                String nome = scanner.nextLine();
                System.out.print("Digite o preço do produto: ");
                double preco = scanner.nextDouble();

                Produto produto;
                if (tipo.equalsIgnoreCase("eletronico")) {
                    produto = new ProdutoEletronico(nome, preco);
                } else if (tipo.equalsIgnoreCase("roupa")) {
                    produto = new ProdutoRoupa(nome, preco);
                } else {
                    System.out.println("Tipo de produto desconhecido. Tente novamente.");
                    continue;
                }

                estoque.adicionarProduto(produto);
                System.out.println("Produto adicionado com sucesso!");
            } else if (opcao == 2) {
                System.out.print("Digite o nome do produto a remover: ");
                String nome = scanner.nextLine();
                Produto produtoARemover = null;

                for (Produto produto : estoque.produtos) {
                    if (produto.getNome().equalsIgnoreCase(nome)) {
                        produtoARemover = produto;
                        break;
                    }
                }

                if (produtoARemover != null) {
                    estoque.removerProduto(produtoARemover);
                    System.out.println("Produto removido com sucesso!");
                } else {
                    System.out.println("Produto não encontrado.");
                }
            } else if (opcao == 3) {
                System.out.print("Digite a porcentagem de desconto: ");
                double porcentagem = scanner.nextDouble();
                estoque.exibirPrecosComDesconto(porcentagem);
            } else if (opcao == 4) {
                System.out.println("Saindo...");
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}
