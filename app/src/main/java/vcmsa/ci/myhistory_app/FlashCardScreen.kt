package vcmsa.ci.myhistory_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FlashCardScreen : AppCompatActivity() {

    private val quiz = arrayOf(
        "The Great Wall of China is visible from space.",
        "The Renaissance began in the 14th century.",
        "Julius Caesar was a Roman emperor.",
        "The first Olympic Games were held in Greece.",
        "The Titanic sank in 1912."
    )

    private val answers = arrayOf(false, true, false, true, true)

    private lateinit var questionBox: TextView
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button

    private var score = 0
    private var currentIndex = 0
    private var answered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flash_card_screen)

        // Link UI elements
        questionBox = findViewById(R.id.quizBox)
        trueButton = findViewById(R.id.trueButton)
        falseButton = findViewById(R.id.falseButton)
        nextButton = findViewById(R.id.nextButton)

        // Start "loop" through questions manually
        displayQuestion()

        trueButton.setOnClickListener {
            handleAnswer(true)
        }

        falseButton.setOnClickListener {
            handleAnswer(false)
        }

        nextButton.setOnClickListener {
            // Move to next question (simulate next step in loop)
            currentIndex++

            if (currentIndex < quiz.size) {
                displayQuestion()
                resetButtons()
            } else {
                // Loop ended: Go to final screen
                val intent = Intent(this, ScoreScreen::class.java)
                intent.putExtra("score", score)
                intent.putExtra("total", quiz.size)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun displayQuestion() {
        questionBox.text = "Q${currentIndex + 1}: ${quiz[currentIndex]}"
    }

    private fun handleAnswer(userAnswer: Boolean) {
        if (answered) return

        answered = true

        val correctAnswer = answers[currentIndex]
        if (userAnswer == correctAnswer) {
            score++
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show()
        }

        trueButton.isEnabled = false
        falseButton.isEnabled = false
        nextButton.isEnabled = true
    }

    private fun resetButtons() {
        answered = false
        trueButton.isEnabled = true
        falseButton.isEnabled = true
        nextButton.isEnabled = false
    }
}
