package com.holamundo.personasmaterial;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Random;

public class AgregarCarro extends AppCompatActivity {
    private EditText txtplaca, txtprecio;
    private Spinner cmbmarca, cmbcolor ;
    private ArrayAdapter<String> adapter;
    private String opcC[], opcM[];
    private ArrayList<Integer> fotos;
    private ImageView foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_carro);

        txtplaca = findViewById(R.id.txtplaca);
        txtprecio = findViewById(R.id.txtprecio);

        cmbmarca = findViewById(R.id.cmbmarca);
        cmbcolor = findViewById(R.id.cmbcolor);
        foto = findViewById(R.id.foto);

        fotos = new ArrayList<>();
        fotos.add(R.drawable.img1);
        fotos.add(R.drawable.img2);
        fotos.add(R.drawable.img3);
        fotos.add(R.drawable.img4);
        fotos.add(R.drawable.img5);

        opcC = getResources().getStringArray(R.array.color);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,opcC);
        cmbcolor.setAdapter(adapter);

        opcM = getResources().getStringArray(R.array.marca);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,opcM);
        cmbmarca.setAdapter(adapter);
    }

    public int fotoAleatoria(){
        int fotoSeleccionada;
        Random r = new Random();
        fotoSeleccionada = r.nextInt(this.fotos.size());
        return fotos.get(fotoSeleccionada);
    }

    public void guardar(View v) {
        String placa, precio;
        int foto, marca, color;

        foto = this.fotoAleatoria();
        placa = txtplaca.getText().toString();
        precio = txtprecio.getText().toString();
        color = cmbcolor.getSelectedItemPosition();
        marca = cmbmarca.getSelectedItemPosition();

        Carro c = new Carro(foto,placa,marca,precio,color);
        c.guardar();

        limpiar();
        Snackbar.make(v,getResources().getString(R.string.guardado_exitoso),Snackbar.LENGTH_SHORT)
                .show();

    }

    public void onBackPressed(){
        finish();
        Intent i = new Intent(AgregarCarro.this,Principal.class);
        startActivity(i);
    }

    public void limpiar(){
        txtplaca.setText("");
        txtprecio.setText("");

        cmbcolor.setSelection(0);
        cmbmarca.setSelection(0);

        txtplaca.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }


    public void limpiar(View v){
        limpiar();
    }
}
