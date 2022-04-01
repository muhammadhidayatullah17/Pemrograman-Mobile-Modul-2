package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener{
            rollDice()
        }

        // Do a roll when the app starts
        rollDice()
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll the dice
        val dice1 = Dice1(6)
        val dice2 = Dice2(6)
        val diceRoll1 = dice1.roll()
        val diceRoll2 = dice2.roll()

        // Find the ImageView in the layout
        val diceImage1: ImageView = findViewById(R.id.imageView)
        val diceImage2: ImageView = findViewById(R.id.imageView2)

        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource1 = when (diceRoll1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // Update the ImageView with the correct drawable resource ID
        diceImage1.setImageResource(drawableResource1)

        val drawableResource2 = when (diceRoll2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        if (diceRoll1 == diceRoll2){
            Toast.makeText(this, "Selamat anda dapat dadu double!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Anda belum beruntung!", Toast.LENGTH_SHORT).show()
        }

        diceImage2.setImageResource(drawableResource2)

        // Update the content description
        diceImage1.contentDescription = diceRoll1.toString()
        diceImage2.contentDescription = diceRoll2.toString()
    }
}

class Dice1 (val numSides1: Int) {
    var sides1 = 6
    fun roll(): Int {
        return (1..numSides1).random()
    }
}

class Dice2 (val numSides2: Int) {
    var sides2 = 6
    fun roll(): Int {
        return (1..numSides2).random()
    }
}