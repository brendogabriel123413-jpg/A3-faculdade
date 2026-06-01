package model;

import java.time.LocalDateTime;

public class Ticket {

    private Veiculo veiculo;
    private LocalDateTime entrada;
    private LocalDateTime saida;

    public Ticket(Veiculo veiculo) {
        this.veiculo = veiculo;
        this.entrada = LocalDateTime.now();
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public LocalDateTime getSaida() {
        return saida;
    }

    public void registrarSaida() {
        saida = LocalDateTime.now();
    }
}