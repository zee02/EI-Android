package com.example.trabalholaboratorialpl11.com.company;

public class Identificador extends Descritor {
    protected long numero;

    public Identificador(String nome, long numero){
        super(nome);
        this.numero = numero;
    }

    public long getNumero(){
        return numero;
    }

    public void setNumero(long numero){
        this.numero = numero;
    }

    @Override
    public String toString() {
        return super.toString() + " (" + numero + ")";
    }
}
