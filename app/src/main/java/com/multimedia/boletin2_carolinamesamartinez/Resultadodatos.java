package com.multimedia.boletin2_carolinamesamartinez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Resultadodatos extends AppCompatActivity {
    private Button button_volver;
    private TextView textView_nombremostrado,textView_tipodemascotaseleccionado,textView_sexomascotaseleccionado,textView_personalidadmascotaseleccionado,textView_colormascota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultadodatos);
        button_volver=(Button) findViewById(R.id.button_volver);
        textView_nombremostrado=(TextView) findViewById(R.id.textView_nombremostrado);
        textView_tipodemascotaseleccionado=(TextView) findViewById(R.id.textView_tipodemascotaseleccionado);
        textView_sexomascotaseleccionado=(TextView) findViewById(R.id.textView_sexomascotaseleccionado);
        textView_personalidadmascotaseleccionado=(TextView) findViewById(R.id.textView_personalidadmascotaseleccionado);
        textView_colormascota=(TextView) findViewById(R.id.textView_colormascota);

        Intent guardardatos=getIntent();
        String nombre=guardardatos.getStringExtra("nombremascota");
        textView_nombremostrado.setText(nombre);
        String tipodemascota=guardardatos.getStringExtra("tipomascota");
        textView_tipodemascotaseleccionado.setText(tipodemascota);
        String sexodemascota=guardardatos.getStringExtra("sexomascota");
        textView_sexomascotaseleccionado.setText(sexodemascota);

            String personalidaddelamascota=guardardatos.getStringExtra("personalidadmascota");
            textView_personalidadmascotaseleccionado.setText(personalidaddelamascota);
            String colormasc= guardardatos.getStringExtra("colormascota");
            textView_colormascota.setText(colormasc);



        volvera();
    }

    public void volvera(){
        button_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }
}