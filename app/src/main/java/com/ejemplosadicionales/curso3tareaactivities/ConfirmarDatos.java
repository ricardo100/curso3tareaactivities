package com.ejemplosadicionales.curso3tareaactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);


        TextView tvLosDatos = (TextView) findViewById(R.id.tvLosDatos);
        Button btnConfirmarDatos = (Button)  findViewById(R.id.btnConfirmarDatos);
        Bundle bundle = getIntent().getExtras();


            String nombre = bundle.getString("nombre");
            int telefono = bundle.getInt("telefono", 0);
            String email = bundle.getString("email");
            String descripcion = bundle.getString("descripcion");
            String date = bundle.getString("date");
            tvLosDatos.setText("Nombre Completo: " + nombre + "\n" + "Telefono: " + telefono + "\n" +
                    "email: " + email  + "\n" + "Descripcion: " + descripcion +
                    "\n" + "Fecha: " + date);

            btnConfirmarDatos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    finish();
                }
            });




    }
}
