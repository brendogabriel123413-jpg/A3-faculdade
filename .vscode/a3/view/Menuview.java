package view;

import controller.EstacionamentoController;

import java.util.Scanner;

public class MenuView {

    private Scanner scanner = new Scanner(System.in);
    private EstacionamentoController controller =
            new EstacionamentoController();

    public void iniciar() {

        int opcao;

        do {

            System.out.println("\n===== ESTACIONAMENTO =====");
            System.out.println("1 - Registrar Entrada");
            System.out.println("2 - Registrar Saída");
            System.out.println("3 - Veículos Estacionados");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    entrada();
                    break;

                case 2:
                    saida();
                    break;

                case 3:
                    controller.listarVeiculos();
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }

    private void entrada() {

        System.out.print("Placa: ");
        String placa = scanner.nextLine();

        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();

        controller.registrarEntrada(placa, modelo);
    }

    private void saida() {

        System.out.print("Placa: ");
        String placa = scanner.nextLine();

        controller.registrarSaida(placa);
    }
}