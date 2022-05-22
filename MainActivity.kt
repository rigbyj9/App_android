package com.example.colorguessinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.EditText



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Code links to app layout
        val editText = findViewById<EditText>(R.id.enter_color)
        val submitButton: Button = findViewById(R.id.submit_button)
        val colorImage: ImageView = findViewById(R.id.imageView)

        // When submit is hit, it will run main function
        submitButton.setOnClickListener {main(colorImage)}
    }
}

fun main(colorImage: ImageView) {
    //Generates and selects the colors at random
    val colorGenerator = Colors(9)
    val colorSelector = colorGenerator.randomize()

    //Each number matches to a different color
    val drawableResource = when (colorSelector) {
        1 -> R.drawable.red
        2 -> R.drawable.orange
        3 -> R.drawable.yellow
        4 -> R.drawable.green
        5 -> R.drawable.blue
        6 -> R.drawable.purple
        7 -> R.drawable.pink
        8 -> R.drawable.brown
        else -> R.drawable.gray
     }
    //Corresponds with color from when statement and changes layout
     colorImage.setImageResource(drawableResource)
     colorImage.contentDescription = colorSelector.toString()


 }

class Colors (private val numColors: Int) {

    //Generates randomizer
    fun randomize(): Int {
        return (1..numColors).random()
    }
}
