package com.lucasfariassa.dicegame

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.room.Room
import com.lucasfariassa.dicegame.databinding.ActivityMainBinding
import java.util.Random

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var sharedPref : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main) // setContentView(R.layout.activity_main)
        binding.mainButton.text = "Play"
        val button : Button = findViewById<Button>(R.id.main_button) // imageView = findViewById(R.id.main_image)

        // Definição de conexão com o banco de dados - Database connection definition:
//        val db = Room.databaseBuilder(
//            applicationContext,
//            Database::class.java, "DGDb"
//        ).build()


        // Capturar a última jogada - Capture the last move:
        sharedPref = getSharedPreferences(getString(R.string.archive_name), Context.MODE_PRIVATE)
        val number : Int = sharedPref.getInt(getString(R.string.keyPref_lastMove), 0)
        setImage(number)
        binding.mainButton.setOnClickListener {
            play()
        }

        // Ação ao clicar no botão - Action on clicking the button:
        button.setOnClickListener {
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
            play()
        }
    }

    // Execução da função principal - Execution of the main function:
    private fun play() {
        var number : Int = Random().nextInt(6) + 1
        with(sharedPref.edit()) {
            putInt(getString(R.string.keyPref_lastMove), number)
            apply()
        }
        setImage(number)
    }

    // Definição das imagens por número sorteado - Definition of images by number drawn:
    private fun setImage(number: Int) {
        val drawableResource = when (number) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }
        binding.mainImage.setImageResource(drawableResource) // imageView.setImageResource(drawableResource)
    }
}