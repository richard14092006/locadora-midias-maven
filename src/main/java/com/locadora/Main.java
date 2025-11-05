package com.locadora;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GerenciadorLocadora locadora = new GerenciadorLocadora();

        int opcao;
        do {
            System.out.println("\n==== LOCADORA DE MÍDIAS ====");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Cadastrar mídia");
            System.out.println("3 - Realizar locação");
            System.out.println("4 - Listar clientes");
            System.out.println("5 - Listar mídias");
            System.out.println("6 - Listar locações");
            System.out.println("7 - Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> locadora.cadastrarCliente(sc);
                case 2 -> locadora.cadastrarMidia(sc);
                case 3 -> locadora.realizarLocacao(sc);
                case 4 -> locadora.listarClientes();
                case 5 -> locadora.listarMidias();
                case 6 -> locadora.listarLocacoes();
                case 7 -> {
                    System.out.println("Encerrando e salvando dados...");
                    locadora.encerrar();
                }
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 7);

        sc.close();
    }
}
