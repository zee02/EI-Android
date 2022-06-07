package com.example.trabalholaboratorialpl11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.trabalholaboratorialpl11.com.company.Aula;
import com.example.trabalholaboratorialpl11.com.company.GestorAulas;
import com.example.trabalholaboratorialpl11.com.company.GestorSemanaAulas;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1º - obter o ListView - listViewAulas
        ListView listViewAulas = findViewById(R.id.listViewAulas);

        //2º - obter as aulas
        LinkedList<Aula> aulas = GestorSemanaAulas.INSTANCIA.getAulas();

        //3º - Criar um adaptador
        ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, aulas);

        //4º atribuir o adaptador à ListView
        listViewAulas.setAdapter(listAdapter);

        listViewAulas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(DetalhesAulaActivity.createIntent(MainActivity.this, position));
            }
        });

    }
}