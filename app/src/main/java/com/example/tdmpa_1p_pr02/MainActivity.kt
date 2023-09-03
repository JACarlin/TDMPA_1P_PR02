package com.example.tdmpa_1p_pr02

import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import android.widget.Toast
import androidx.annotation.RequiresApi

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date
import kotlin.Error

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btnClick = findViewById<Button>(R.id.btnClick);

        btnClick.setOnClickListener {
            try{
                var txtFecha = findViewById<TextView>(R.id.txtDate);
                var fecha = LocalDate.parse(txtFecha.text.toString(), DateTimeFormatter.ISO_DATE )
                obtenerZodiaco(fecha);
                obtenerChino(fecha);
            }catch (e:Exception){
                Toast.makeText(this@MainActivity ,
                    "Formato Invalido",
                    Toast.LENGTH_SHORT).show()

            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun obtenerZodiaco(fecha:LocalDate){
        var mes = fecha.monthValue
        var dia = fecha.dayOfMonth
        var texto: String
        when {
            (mes == 3 && dia >= 21) || (mes == 4 && dia <= 19) -> texto = "♈ Aries ♈︎"
            (mes == 4 && dia >= 20) || (mes == 5 && dia <= 20) -> texto = "♉ Tauro ♉︎"
            (mes == 5 && dia >= 21) || (mes == 6 && dia <= 20) -> texto = "♊ Géminis ♊︎"
            (mes == 6 && dia >= 21) || (mes == 7 && dia <= 22) -> texto = "♋ Cáncer ♋︎"
            (mes == 7 && dia >= 23) || (mes == 8 && dia <= 22) -> texto = "♌ Leo ♌︎"
            (mes == 8 && dia >= 23) || (mes == 9 && dia <= 22) -> texto = "♍ Virgo ♍︎"
            (mes == 9 && dia >= 23) || (mes == 10 && dia <= 22) -> texto = "♎ Libra ♎︎"
            (mes == 10 && dia >= 23) || (mes == 11 && dia <= 21) -> texto = "♏ Escorpio ♏︎"
            (mes == 11 && dia >= 22) || (mes == 12 && dia <= 21) -> texto = "♐ Sagitario ♐︎"
            (mes == 12 && dia >= 22) || (mes == 1 && dia <= 19) -> texto = "♑ Capricornio ♑︎"
            (mes == 1 && dia >= 20) || (mes == 2 && dia <= 18) -> texto = "♒ Acuario ♒︎"
            else -> texto = "♓ Piscis ♓︎"
        }
        var txtZodiaco = findViewById<TextView>(R.id.txtZodiaco)
        txtZodiaco.text = "Tu eres "+ texto
    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun obtenerChino(fecha:LocalDate){
            val anio = fecha.year
            val signosChinos = arrayOf( "https://www.clarin.com/img/2019/11/07/dYEoQZR1_720x0__1.jpg", "https://www.clarin.com/img/2019/11/07/7Stk4ozR_720x0__1.jpg", "https://www.clarin.com/img/2019/11/07/uGGFO0AL_720x0__1.jpg", "https://www.clarin.com/img/2019/11/07/vQ_hjIAx_720x0__1.jpg", "https://www.clarin.com/img/2019/11/07/527JMh0C_720x0__1.jpg", "https://www.clarin.com/img/2019/11/07/k5StzBC5_720x0__1.jpg", "https://www.clarin.com/img/2019/11/07/lgo7KfuE_720x0__1.jpg", "https://www.clarin.com/img/2019/11/07/SXAqxMwA_720x0__1.jpg","https://www.clarin.com/img/2019/11/07/SsWZ5w8S_720x0__1.jpg", "https://www.clarin.com/img/2019/11/07/_fkAEN_n_720x0__1.jpg", "https://www.clarin.com/img/2019/11/07/nwKaI1UW_720x0__1.jpg","https://www.clarin.com/img/2019/11/07/4lfKnT3M_720x0__1.jpg")
        val nombres = arrayOf(  "Rata", "Buey", "Tigre", "Conejo", "Dragón", "Serpiente", "Caballo", "Cabra","Mono", "Gallo", "Perro","Cerdo")
            val indice = (anio - 1900) % 12
        var txtnameChino = findViewById<TextView>(R.id.txtnameChino)
        txtnameChino.text = "Tu eres del año del " + nombres[indice]
        changeBackground(signosChinos[indice])
        }
    fun changeBackground(url: String){
        var urlFondoParse: Uri = Uri.parse(url)
        var imgFondo = findViewById<ImageView>(R.id.imgChino)
        Glide.with(applicationContext).load(urlFondoParse).into(imgFondo)
    }


}