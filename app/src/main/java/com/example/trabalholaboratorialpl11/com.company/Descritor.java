package com.example.trabalholaboratorialpl11.com.company;

public abstract class Descritor {
    protected String nome;

    public Descritor(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
