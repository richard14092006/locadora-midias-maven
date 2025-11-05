package com.locadora;

import java.io.Serializable;

public class Cliente implements Serializable {
    private int id;
    private String nome;
    private String email;

    public Cliente() {}

    public Cliente(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }

    @Override
    public String toString() {
        return "Cliente [" + id + "] " + nome + " - " + email;
    }
}
