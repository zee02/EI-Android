package com.example.trabalholaboratorialpl11.com.company;

public abstract class Divisao extends Descritor {
    private boolean aberta;

    public Divisao(String nome){
        this(nome, false);
    }

    public Divisao(String nome, boolean aberta) {
        super(nome);
        this.aberta = aberta;
    }

    public boolean isAberta() {
        return aberta;
    }

    public void abrir() {
        aberta = true;
    }

    public void fechar() {
        aberta = false;
    }
}
