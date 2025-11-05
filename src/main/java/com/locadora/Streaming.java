package com.locadora;

public class Streaming extends Midia {
    public Streaming() { super(); }
    public Streaming(int id, String titulo) {
        super(id, titulo);
    }

    @Override
    public double calcularPreco(int dias) {
        return dias * 5.0;
    }
}
