package com.example.recbuscarregistro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    AdapterUsuarios adapterUsuarios;
    EditText buscarRegistro;
    Button buscar;
    Dbhelper conn;
    RecyclerView recyclerView;
    List<usuario> listaUsuario; //lista global (este tiene que ir acumulando los resultado)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buscarRegistro = findViewById(R.id.edtBuscarRegistro);
        buscar = findViewById(R.id.btnBuscarRegistro);
        conn = new Dbhelper(this);
        recyclerView = findViewById(R.id.Vista_recyclerView);
        //conn.insertarDatos("3000","queso","3500","1");
        listaUsuario = new ArrayList<>(); //inicializa en cero la lista global
        LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(manager);
        adapterUsuarios=new AdapterUsuarios(listaUsuario);
        recyclerView.setAdapter(adapterUsuarios);
    }
    public void BuscarRegistro(View view)
    {
        List<usuario> registrosbuscados = conn.Buscar(buscarRegistro.getText().toString());
        listaUsuario.addAll(registrosbuscados);
        adapterUsuarios = new AdapterUsuarios(listaUsuario);
        recyclerView.setAdapter(adapterUsuarios);


        buscarRegistro.setText("");


    }

}