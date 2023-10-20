package com.jantonioc.mymovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.jantonioc.mymovies.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("Main","OnCreate")
        binding.txtmessage.text = "Hola Android"
    }

    //Vuelve de un bloqueo
    override fun onResume() {
        super.onResume()
    }

    //Algo pausa la aplicacion
    override fun onPause() {
        super.onPause()
    }

    //Cuando pasa a Segundo Plano
    override fun onStop() {
        super.onStop()
    }

    //Pasa a Primer plano
    override fun onStart() {
        super.onStart()
    }

    //Cuando se va a destruir
    override fun onDestroy() {
        super.onDestroy()
        Log.d("Main","OnDestroy")
    }
}