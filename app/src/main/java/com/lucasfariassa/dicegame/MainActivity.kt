package com.lucasfariassa.dicegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.lucasfariassa.dicegame.databinding.ActivityMainBinding
import java.util.Random

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // imageView = findViewById(R.id.main_image)
        binding.mainButton.text = "Play"
        val button : Button = findViewById<Button>(R.id.main_button)

        button.setOnClickListener {
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
            play()
        }
    }

    private fun play() {
        var number : Int = Random().nextInt(6) + 1
        val drawableResource = when (number) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        //imageView.setImageResource(drawableResource)
        binding.mainImage.setImageResource(drawableResource)
    }
}