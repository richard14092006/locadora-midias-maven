package com.locadora;

public class DVD extends Midia {
    public DVD() { super(); }
    public DVD(int id, String titulo) {
        super(id, titulo);
    }

    @Override
    public double calcularPreco(int dias) {
        return dias * 3.5;
    }
}
