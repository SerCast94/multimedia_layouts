package com.example.tablayout

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration

class InformacionLegalActivity : AppCompatActivity() {

    private lateinit var botonAceptar : Button
    private lateinit var botonCancelar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_informacion_legal)

        botonAceptar = findViewById(R.id.btnAceptar)
        botonCancelar = findViewById(R.id.btnCancelar)

        //boton al que le doy acción

        botonAceptar.setOnClickListener(){
            val intent = Intent()
            intent.putExtra("Resultado","Sergio")
            setResult(Activity.RESULT_OK, intent)
            finish()

        }

        botonCancelar.setOnClickListener(){
            val intent = Intent()
            intent.putExtra("Resultado","Sergio")
            setResult(Activity.RESULT_CANCELED, intent)
            finish()

        }

    }

}