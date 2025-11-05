package com.locadora;

import java.io.Serializable;
import java.time.LocalDate;

public class Locacao implements Serializable {
    private Cliente cliente;
    private Midia midia;
    private int dias;
    private LocalDate data;

    public Locacao() {}

    public Locacao(Cliente cliente, Midia midia, int dias) {
        this.cliente = cliente;
        this.midia = midia;
        this.dias = dias;
        this.data = LocalDate.now();
    }

    public double getValor() {
        return midia.calcularPreco(dias);
    }

    @Override
    public String toString() {
        return "Locação: " + cliente.getNome() + " alugou '" +
                midia.getTitulo() + "' por " + dias + " dias. Valor: R$" + getValor();
    }

    public Midia getMidia() { return midia; }
}
