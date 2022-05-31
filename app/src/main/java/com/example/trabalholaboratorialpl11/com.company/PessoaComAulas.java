package com.example.trabalholaboratorialpl11.com.company;
import java.util.LinkedList;

public abstract class PessoaComAulas extends Pessoa implements RepositorioAulas,AssociavelAulas{
    private GestorAulas gestorAulas;

    public PessoaComAulas(String nome, long numero) {
        super(nome, numero);
        gestorAulas = new GestorAulas(this);
    }


    @Override
    public LinkedList<Aula> getAulas() {
        return gestorAulas.getAulas();
    }

    public LinkedList<Aula> getAulas(Horario horario) {
        return gestorAulas.getAulas(horario);
    }

    public void adicionar(Aula aula){
        gestorAulas.adicionar(aula);
    }

    public abstract void associar(Aula aula);

    public void remover(Aula aula){
        gestorAulas.remover(aula);
    }

    public abstract void desassociar(Aula aula);


    public void preencherSumario (Aula aula){
        if(aula == null || !gestorAulas.contem(aula)){
            return;
        }
        escreverSumario(aula);
    }

    protected void escreverSumario(Aula aula){
        aula.adicionarLinha(this.nome);
    }

}
