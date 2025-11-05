package com.locadora;

import java.io.Serializable;

public abstract class Midia implements Serializable {
    private int id;
    private String titulo;
    private boolean disponivel = true;

    public Midia() {}

    public Midia(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public boolean isDisponivel() { return disponivel; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }

    public abstract double calcularPreco(int dias);

    @Override
    public String toString() {
        return "[" + id + "] " + titulo + " (" + (disponivel ? "Disponível" : "Alugada") + ")";
    }
}
