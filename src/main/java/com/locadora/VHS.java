package com.locadora;

public class VHS extends Midia {
    public VHS() { super(); }
    public VHS(int id, String titulo) {
        super(id, titulo);
    }

    @Override
    public double calcularPreco(int dias) {
        return dias * 2.5;
    }
}
