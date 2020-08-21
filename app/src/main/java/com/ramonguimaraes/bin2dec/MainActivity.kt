package com.ramonguimaraes.bin2dec

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalc.setOnClickListener {

            if(inputValidator(edtBinario.text.toString())){
                txtResultado.text = calc(edtBinario.text.toString())
            }

        }

    }


    fun inputValidator(string: String): Boolean {

        for(i in 0 until string.length) {
            if(string[i] != '1' && string[i] != '0') {
                Toast.makeText(this, "Só pode inserir 0 ou 1", Toast.LENGTH_SHORT).show()
                return false
            }
        }

        if(string.length > 8){
            Toast.makeText(this, "Informe no maximo 8 digitos", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    fun calc(binario: String): String {

        var res = 0
        val tam = binario.length - 1

        Log.e("", tam.toString())

        for (i in tam downTo 0){
            res += 2.0.pow( tam - i).toInt() * binario[i].toString().toInt()
        }

        return res.toString()
    }
}