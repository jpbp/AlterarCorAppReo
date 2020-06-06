package com.example.joaopauloapp

import android.app.AlertDialog
import android.content.DialogInterface
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun btnclick(view : View){
        //array de cores
        val cores = arrayOf("Amarelo","Vermelho","Azul","Verde","Preto")
        //array de checagem
        val checar = booleanArrayOf(false,false,false,false,false)
        //array de hex decimal das cores
        val hex = arrayOf(Color.YELLOW,Color.RED,Color.BLUE,Color.GREEN,Color.BLACK)
        // build alert dialog
        val dialogBuilder = AlertDialog.Builder(this)
        //variavel para salvar o indice escolhido
        var indice=0
        // set option of alert dialog
        dialogBuilder.setMultiChoiceItems(cores,checar,{dialog,escolha,verificado->
                //selecinando qual opçao das cores foi selecionada
                checar[escolha]=verificado
                //pegando a cor que foi selecionada
                indice=escolha
        })
            //// positive button text and action
            .setPositiveButton("Alterar",DialogInterface.OnClickListener{
                    //alterando a cor do texto
                    dialog, id -> alterarCor(hex[indice],cores[indice])
        })
            // negative button text and action
            .setNegativeButton("Cancelar", DialogInterface.OnClickListener {
                //alterando o texto para nenhuma cor selecionada
                dialog, id -> textView2.setText("Cor não selecionada!")
        })

        // create dialog box
        val alert = dialogBuilder.create()
        // set title for alert dialog box
        alert.setTitle("Escolher Cor")
        // show alert dialog
        alert.show()
    }

    //função para troca de cores
    fun alterarCor(indice : Int,cor : String){
        try {
            //alterando a cor do toolbox
            toolbar.setBackgroundColor(indice)
            //altarando o texto para cor selecionada
            textView2.setText("Cor alterada para "+cor)
        }catch (e: Error){
            //mostrando erro na tela
            Toast.makeText(this, "$e", Toast.LENGTH_SHORT).show()
        }
    }
}
