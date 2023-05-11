package com.multimedia.boletin2_carolinamesamartinez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button_guardar;
    String[] opcionescolor={"Multicolor","Marrón","Negro","Blanco","Manchas","Blanco roto","Naranja"};
    private EditText editText_nombremascota;
    private Spinner spinner2_tipomascota;
    String[] opciones={"","Perro","Gato","Conejo","Humano","Caballo","Serpiente"};
    String [] opcionarray=new String[4];
    private RadioGroup radioGroup_sexomascota;
    private RadioButton radioButton8_smmacho,radioButton9_smhembra;
    private CheckBox checkBox_pcariñoso,checkBox3_pactivo,checkBox6_ptranquilo,checkBox2_pagresivo;
    private TextView textView_todovacio;
    private AutoCompleteTextView autoCompleteTextView_colormacota;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_guardar=(Button) findViewById(R.id.button_guardar);
        editText_nombremascota=(EditText) findViewById(R.id.editText_nombremascota);
        textView_todovacio=(TextView) findViewById(R.id.textView_todovacio);
        autoCompleteTextView_colormacota=(AutoCompleteTextView) findViewById(R.id.autoCompleteTextView_colormascota);
        spinner2_tipomascota=(Spinner)findViewById(R.id.spinner2_tipomascota);
        radioGroup_sexomascota=(RadioGroup) findViewById(R.id.radioGroup_sexomascota);
        radioButton8_smmacho=(RadioButton) findViewById(R.id.radioButton8_smmacho);
        radioButton9_smhembra=(RadioButton) findViewById(R.id.radioButton9_smhembra);
        checkBox_pcariñoso=(CheckBox) findViewById(R.id.checkBox_pcariñoso);
        checkBox3_pactivo=(CheckBox) findViewById(R.id.checkBox3_pactivo);
        checkBox6_ptranquilo=(CheckBox) findViewById(R.id.checkBox6_ptranquilo);
        checkBox2_pagresivo=(CheckBox) findViewById(R.id.checkBox2_pagresivo);
        ArrayAdapter<String> adaptadorcolor = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,opcionescolor);
        autoCompleteTextView_colormacota.setAdapter(adaptadorcolor);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, R.layout.spinnerper,opciones);
        spinner2_tipomascota.setAdapter(adaptador);


        guardardatos();
    }

    public void guardardatos(){
        button_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent guardardatos=new Intent(v.getContext(),Resultadodatos.class);
                if(editText_nombremascota.getText().toString().equalsIgnoreCase("")){
                    guardardatos.putExtra("nombremascota","No se ha insertado un nombre");
                }else{
                    guardardatos.putExtra("nombremascota",editText_nombremascota.getText().toString());
                }

                if(spinner2_tipomascota.getSelectedItem()==opciones[0]){
                    guardardatos.putExtra("tipomascota","No se ha seleccionado un tipo de mascota");
                }else{
                    guardardatos.putExtra("tipomascota",spinner2_tipomascota.getSelectedItem().toString());
                }

                if(radioButton8_smmacho.isChecked()){
                    guardardatos.putExtra("sexomascota","Macho");
               }else if(radioButton9_smhembra.isChecked()){
                    guardardatos.putExtra("sexomascota","Hembra");
                }else if(!radioButton8_smmacho.isChecked() && !radioButton9_smhembra.isChecked()){
                    guardardatos.putExtra("sexomascota","No se ha seleccionado el sexo de la mascota");

                }

                if(autoCompleteTextView_colormacota.getText().toString().equalsIgnoreCase("")){
                    guardardatos.putExtra("colormascota","No se ha seleccionado un color para la mascota");
                }else{
                    guardardatos.putExtra("colormascota",autoCompleteTextView_colormacota.getText().toString());
                }


                String opcion="";

                if(checkBox_pcariñoso.isChecked())
                    opcion=opcion+"Cariñoso/a"+"\n";
                  //  guardardatos.putExtra("personalidadmascota","Cariñoso/a");
                 if(checkBox3_pactivo.isChecked())
                    opcion=opcion+"Activo/a"+"\n";
                   // guardardatos.putExtra("personalidadmascota","Activo/a");
                 if(checkBox6_ptranquilo.isChecked())
                    opcion=opcion+"Tranquilo/a"+"\n";
                   // guardardatos.putExtra("personalidadmascota","Tranquilo/a");
                 if(checkBox2_pagresivo.isChecked())
                    opcion=opcion+"Agresivo/a"+"\n";
                   // guardardatos.putExtra("personalidadmascota","Agresivo/a");
                if(!checkBox_pcariñoso.isChecked()&&!checkBox3_pactivo.isChecked()&&!checkBox6_ptranquilo.isChecked()&&!checkBox2_pagresivo.isChecked())
                    opcion="No se ha seleccionado la personalidad";

                guardardatos.putExtra("personalidadmascota",opcion);


                if(!checkBox_pcariñoso.isChecked()&&!checkBox3_pactivo.isChecked()&&!checkBox6_ptranquilo.isChecked()&&!checkBox2_pagresivo.isChecked()&&!radioButton8_smmacho.isChecked() && !radioButton9_smhembra.isChecked()&&editText_nombremascota.getText().toString().equalsIgnoreCase("")&&spinner2_tipomascota.getSelectedItem()==opciones[0]&&autoCompleteTextView_colormacota.getText().toString().equalsIgnoreCase("")){
                    textView_todovacio.setText("El cuestionario está vacio");
                }else{
                    startActivity(guardardatos);
                    textView_todovacio.setText("");
                }

                checkBox_pcariñoso.setChecked(false);
                checkBox3_pactivo.setChecked(false);
                checkBox6_ptranquilo.setChecked(false);
                checkBox2_pagresivo.setChecked(false);
                radioGroup_sexomascota.clearCheck();
                editText_nombremascota.setText("");
                autoCompleteTextView_colormacota.setText("");
                spinner2_tipomascota.setSelection(0);

            }
        });
    }
}