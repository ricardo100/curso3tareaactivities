package com.ejemplosadicionales.curso3tareaactivities;

//Ejercicio tomado de
//https://www.youtube.com/watch?v=hwe1abDO2Ag
//Android Beginner Tutorial #25 - DatePicker Dialog [Choosing a Date from a Dialog Pop-Up]

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.ejemplosadicionales.curso3tareaactivities.R;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDataSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Incia texto
        final EditText etNombreCompleto = (EditText) findViewById(R.id.etNombreCompleto);
        final EditText etTelefono = (EditText) findViewById(R.id.etTelefono);
        final EditText etEmail = (EditText) findViewById(R.id.etEmail);
        final EditText etDescripcion = (EditText) findViewById(R.id.etDescripcion);
        final Button btnSiguiente =  (Button) findViewById(R.id.btnSiguiente);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ConfirmarDatos.class);
                intent.putExtra("nombre",etNombreCompleto.getText().toString());
                int telefono = Integer.parseInt(etTelefono.getText().toString());
                intent.putExtra("telefono",telefono);
                intent.putExtra("email",etEmail.getText().toString());
                intent.putExtra("descripcion",etDescripcion.getText().toString());
                intent.putExtra("date",mDisplayDate.getText());
                startActivity(intent);

            }
        });


        //Inicia calendario
        mDisplayDate = (TextView) findViewById(R.id.tvDate);

       mDisplayDate.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Calendar cal = Calendar.getInstance();
               int year = cal.get(Calendar.YEAR);
               int month = cal.get(Calendar.MONTH);
               int day = cal.get(Calendar.DAY_OF_MONTH);

               DatePickerDialog dialog = new DatePickerDialog(MainActivity.this,
                       android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                       mDataSetListener, year,month,day);
               dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
               dialog.show();

           }
       });

       mDataSetListener = new DatePickerDialog.OnDateSetListener() {
           @Override
           public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
               month = month + 1;
               Log.d(TAG, "onDateSet: mm/dd/yy: " +month + "/" + dayOfMonth + "/" + year);

               String date = dayOfMonth + "/" + month + "/" + year;
               mDisplayDate.setText(date);


           }
       };

    }
}
