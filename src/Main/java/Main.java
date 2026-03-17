package Main.java;

import java.util.Scanner;

class itens {
    String nome;
    String tipo;
    int quantidade;
}

public class Main{
    static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        itens[] mochila = new itens[10];
        int totalItens = 0;

        int opcao;

        do {
            System.out.println("\n===== MOCHILA =====");
            System.out.println("1- Adicionar item");
            System.out.println("2- Remover item");
            System.out.println("3- Listar item");
            System.out.println("0- Sair");

            opcao = input.nextInt();
            input.nextLine(); // Limpar buffer

        switch (opcao) {
            case 1:
                if (totalItens < 10) {
                    System.out.println("Adicionar novo item: ");

                    itens item = new itens();

                    System.out.print("Nome: ");
                    item.nome = input.nextLine();

                    System.out.print("Tipo: ");
                    item.tipo = input.nextLine();

                    System.out.print("Quantidade: ");
                    item.quantidade = input.nextInt();

                    input.nextLine();

                    mochila[totalItens] = item;
                    totalItens++;

                    System.out.println("Item adicionado!");
                } else {
                    System.out.println("Mochila cheia!");
                }
                break;

            case 2:
                System.out.println("Digite o nome do item para remover: ");
                String nomeRemover = input.nextLine();

                int espaco = -1;

                for (int i = 0; i < totalItens; i++){
                    if (mochila[i].nome.equalsIgnoreCase(nomeRemover)){
                        espaco = i;
                    }

                    // Mover itens
                    if (espaco != -1){
                        for (int j = espaco; j < totalItens -1; j++) {
                            mochila[j] = mochila[j + 1];
                        }

                        totalItens--;
                        System.out.println("Item removido!");

                    } else {
                        System.out.println("Item não encontrado!");
                    }
                }
                break;


        }
        } while (opcao != 0);

        input.close();
    }
}
