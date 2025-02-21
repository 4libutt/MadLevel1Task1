package com.example.madlevel1task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.madlevel1task1.databinding.ActivityHigherLowerBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHigherLowerBinding
    private var currentThrow: Int = 1
    private var lastThrow: Int = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHigherLowerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    /**
     * Set the initial (UI) state of the game.
     */
    private fun initViews() {
        binding.HigherButton.setOnClickListener{
            onHigherClick()
        }

        binding.equalsButton.setOnClickListener{
            onEqualClick()
        }

        binding.lowerButton.setOnClickListener{
            onLowerClick()
        }
        updateUI()
    }

    /**
     * Update the last throw text and the dice image resource drawable with the current throw.
     */
    private fun updateUI() {
        binding.lastThrow.text = getString(R.string.last_throw, lastThrow)

        when (currentThrow) {
            1 -> binding.diceImage.setImageResource(R.drawable.dice1)
            2 -> binding.diceImage.setImageResource(R.drawable.dice2)
            3 -> binding.diceImage.setImageResource(R.drawable.dice3)
            4 -> binding.diceImage.setImageResource(R.drawable.dice4)
            5 -> binding.diceImage.setImageResource(R.drawable.dice5)
            6 -> binding.diceImage.setImageResource(R.drawable.dice6)
        }
    }

    private fun rollDice() {
        lastThrow = currentThrow
        currentThrow = (1..6).random()
        updateUI()
    }

    /**
     * Calls [rollDice] and checks if the answer is correct.
     */
    private fun onHigherClick() {
        rollDice()
        if (currentThrow > lastThrow) {
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }
    }

    /**
     * Calls [rollDice] and checks if the answer is correct.
     */
    private fun onLowerClick() {
        rollDice()
        if (currentThrow < lastThrow) {
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }
    }

    /**
     * Calls [rollDice] and checks if the answer is correct.
     */
    private fun onEqualClick() {
        rollDice()
        if (currentThrow == lastThrow) {
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }
    }

    /**
     * Displays a successful Toast message.
     */
    private fun onAnswerCorrect() {
        Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_LONG).show()
    }

    /**
     * Displays an incorrect Toast message.
     */
    private fun onAnswerIncorrect() {
        Toast.makeText(this, getString(R.string.incorrect), Toast.LENGTH_LONG).show()
    }

}