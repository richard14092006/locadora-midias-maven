package com.locadora;

import java.util.List;
import java.util.Scanner;

public class GerenciadorLocadora {
    private int contadorClientes = 1;
    private int contadorMidias = 1;

    public GerenciadorLocadora() {
        BancoDeDados.iniciar();

        // carregar contadores para não colidir IDs se houver dados existentes
        List<Cliente> clientes = BancoDeDados.listarClientes();
        if (!clientes.isEmpty()) {
            clientes.stream().mapToInt(Cliente::getId).max().ifPresent(max -> contadorClientes = max + 1);
        }
        List<Midia> midias = BancoDeDados.listarMidias();
        if (!midias.isEmpty()) {
            midias.stream().mapToInt(Midia::getId).max().ifPresent(max -> contadorMidias = max + 1);
        }
    }

    public void encerrar() {
        BancoDeDados.fechar();
    }

    public void cadastrarCliente(Scanner sc) {
        System.out.print("Nome do cliente: ");
        String nome = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();

        Cliente c = new Cliente(contadorClientes++, nome, email);
        BancoDeDados.salvarCliente(c);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public void cadastrarMidia(Scanner sc) {
        System.out.print("Tipo de mídia (1-VHS, 2-DVD, 3-Streaming): ");
        int tipo = sc.nextInt();
        sc.nextLine();
        System.out.print("Título: ");
        String titulo = sc.nextLine();

        Midia m = switch (tipo) {
            case 1 -> new VHS(contadorMidias++, titulo);
            case 2 -> new DVD(contadorMidias++, titulo);
            case 3 -> new Streaming(contadorMidias++, titulo);
            default -> null;
        };

        if (m != null) {
            BancoDeDados.salvarMidia(m);
            System.out.println("Mídia cadastrada com sucesso!");
        } else {
            System.out.println("Tipo inválido!");
        }
    }

    public void realizarLocacao(Scanner sc) {
        List<Cliente> clientes = BancoDeDados.listarClientes();
        List<Midia> midias = BancoDeDados.listarMidias();

        if (clientes.isEmpty() || midias.isEmpty()) {
            System.out.println("Cadastre clientes e mídias antes de locar.");
            return;
        }

        System.out.println("Clientes disponíveis:");
        clientes.forEach(System.out::println);
        System.out.print("ID do cliente: ");
        int idCliente = sc.nextInt();

        Cliente cliente = clientes.stream()
                .filter(c -> c.getId() == idCliente)
                .findFirst().orElse(null);

        if (cliente == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }

        System.out.println("Mídias disponíveis:");
        midias.stream().filter(Midia::isDisponivel).forEach(System.out::println);
        System.out.print("ID da mídia: ");
        int idMidia = sc.nextInt();

        Midia midia = midias.stream()
                .filter(m -> m.getId() == idMidia && m.isDisponivel())
                .findFirst().orElse(null);

        if (midia == null) {
            System.out.println("Mídia não encontrada ou indisponível!");
            return;
        }

        System.out.print("Quantos dias de locação? ");
        int dias = sc.nextInt();
        sc.nextLine();

        Locacao locacao = new Locacao(cliente, midia, dias);
        midia.setDisponivel(false);

        BancoDeDados.salvarMidia(midia);
        BancoDeDados.salvarLocacao(locacao);

        System.out.println("Locação registrada com sucesso!");
    }

    public void listarClientes() {
        BancoDeDados.listarClientes().forEach(System.out::println);
    }

    public void listarMidias() {
        BancoDeDados.listarMidias().forEach(System.out::println);
    }

    public void listarLocacoes() {
        BancoDeDados.listarLocacoes().forEach(System.out::println);
    }
}
