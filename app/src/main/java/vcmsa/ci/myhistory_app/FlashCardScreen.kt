package vcmsa.ci.myhistory_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FlashCardScreen : AppCompatActivity() {

    // declaring and initializing my array containing my questions
    private val quiz = arrayOf(
        "The Great Wall of China is visible from space.",
        "Kotlin was developed by JetBrains.",
        "Microsoft was founded before Apple.",
        "The first Olympic Games were held in Greece.",
        "The Titanic sank in 1912."
    )
    // Author : Zahra Bulbulia
    // url : https://www.youtube.com/watch?v=LeLwyl2WQgY

    // declaring and initializing my array containing the corresponding answers to the questions
    private val answers = arrayOf(false, true, false, true, true)

    // declaring all my elements
    private lateinit var questionBox: TextView
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button
    // OpenAI (2025) ChatGPT (May 2025 version).
    // Available at: https://chatgpt.com/c/682a490b-7d5c-8004-bc3f-f552d25bad94/ (Accessed: 19 May 2025).

    // initializing the score counter to 0 as well as the index
    private var score = 0
    private var currentIndex = 0
    // Author : Zahra Bulbulia
    // url : https://www.youtube.com/watch?v=LeLwyl2WQgY
    private var answered = false
    // OpenAI (2025) ChatGPT (May 2025 version).
    // Available at: https://chatgpt.com/c/682a490b-7d5c-8004-bc3f-f552d25bad94/ (Accessed: 19 May 2025)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flash_card_screen)

        // Linking UI elements to the code
        questionBox = findViewById(R.id.quizBox)
        trueButton = findViewById(R.id.trueButton)
        falseButton = findViewById(R.id.falseButton)
        nextButton = findViewById(R.id.nextButton)

        // Integration of an if statement through the questions
        displayQuestion()

        trueButton.setOnClickListener {
            handleAnswer(true)
        }

        falseButton.setOnClickListener {
            handleAnswer(false)
        }

        nextButton.setOnClickListener {

            // Moving to the next question while increasing the index
            currentIndex++

            if (currentIndex < quiz.size) {
                displayQuestion()
                resetButtons()
            } else {
                // The end of the If statement and moving to the final screen
                val intent = Intent(this, ScoreScreen::class.java)
                intent.putExtra("score", score)
                intent.putExtra("total", quiz.size)
                startActivity(intent)
                finish()
            }
        }
    }
    // OpenAI (2025) ChatGPT (May 2025 version).
    // Available at: https://chatgpt.com/c/682a490b-7d5c-8004-bc3f-f552d25bad94/ (Accessed: 19 May 2025).

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

    //Integrating a rest Button which allows the user to restart  the quiz
    private fun resetButtons() {
        answered = false
        trueButton.isEnabled = true
        falseButton.isEnabled = true
        nextButton.isEnabled = false
    }
}
// OpenAI (2025) ChatGPT (May 2025 version).
// Available at: https://chatgpt.com/c/682a490b-7d5c-8004-bc3f-f552d25bad94/ (Accessed: 19 May 2025).
