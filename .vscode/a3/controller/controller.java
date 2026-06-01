package controller;

import model.Ticket;
import model.Veiculo;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class EstacionamentoController {

    private List<Ticket> tickets = new ArrayList<>();

    public void registrarEntrada(String placa, String modelo) {

        Veiculo veiculo = new Veiculo(placa, modelo);
        Ticket ticket = new Ticket(veiculo);

        tickets.add(ticket);

        System.out.println("Entrada registrada com sucesso.");
    }

    public void registrarSaida(String placa) {

        for (Ticket ticket : tickets) {

            if (ticket.getVeiculo().getPlaca().equalsIgnoreCase(placa)
                    && ticket.getSaida() == null) {

                ticket.registrarSaida();

                long horas = Duration.between(
                        ticket.getEntrada(),
                        ticket.getSaida()
                ).toHours();

                if (horas == 0) {
                    horas = 1;
                }

                double valor = calcularValor(horas);

                System.out.println("Tempo: " + horas + " hora(s)");
                System.out.println("Valor a pagar: R$ " + valor);

                return;
            }
        }

        System.out.println("Veículo não encontrado.");
    }

    private double calcularValor(long horas) {

        double valor = 12.0;

        if (horas > 1) {
            valor += (horas - 1) * 6;
        }

        if (valor > 50) {
            valor = 50;
        }

        return valor;
    }

    public void listarVeiculos() {

        for (Ticket ticket : tickets) {

            if (ticket.getSaida() == null) {

                System.out.println(
                        "Placa: "
                        + ticket.getVeiculo().getPlaca()
                        + " | Modelo: "
                        + ticket.getVeiculo().getModelo()
                );
            }
        }
    }
}