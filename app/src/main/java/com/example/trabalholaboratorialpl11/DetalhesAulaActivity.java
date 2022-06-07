package com.example.trabalholaboratorialpl11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.Toast;

import com.example.trabalholaboratorialpl11.com.company.Aula;
import com.example.trabalholaboratorialpl11.com.company.GestorSemanaAulas;
import com.example.trabalholaboratorialpl11.databinding.ActivityDetalhesAulaBinding;

public class DetalhesAulaActivity extends AppCompatActivity {

    private ActivityDetalhesAulaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetalhesAulaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int indiceAula = getIntent().getIntExtra("INDICE_AULA", -1);
        Aula aula = GestorSemanaAulas.INSTANCIA.getAula(indiceAula);

        binding.textViewNome.setText(aula.getNome());
        binding.textViewProfessor.setText(Long.toString(aula.getNumero()));
        binding.textViewHorario.setText(aula.getHorario().toString());
        binding.textViewSala.setText(aula.getSala().getNome());
        binding.textViewProfessor.setText(aula.getProfessor().getNome());

        binding.listViewAlunos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, aula.getAlunos()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detalhes_aula,menu);
        Toast.makeText(this, "Adicionar Aluno!", Toast.LENGTH_SHORT).show();
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.itemAdicionarAluno){

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static Intent createIntent(Activity activity, int indiceAula){
        Intent intent = new Intent(activity, DetalhesAulaActivity.class);
        intent.putExtra("INDICE_AULA", indiceAula);

        return intent;
    }
}