package vcmsa.ci.myhistory_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ScoreScreen : AppCompatActivity() {

    private val questions = arrayOf(
        "The Great Wall of China is visible from space.",
        "Kotlin was developed by JetBrains.",
        "Microsoft was founded before Apple.",
        "The first Olympic Games were held in Greece.",
        "The Titanic sank in 1912."
    )

    private val answers = arrayOf(
        "False",
        "True",
        "False",
        "True",
        "True"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score_screen)

        val score = intent.getIntExtra("score", 0)
        val total = intent.getIntExtra("total", 5)

        val scoreText = findViewById<TextView>(R.id.scoreBox)
        val feedbackText = findViewById<TextView>(R.id.feedbackBox)
        val reviewButton = findViewById<Button>(R.id.reviewButton)

        scoreText.text = "Your score: $score / $total"

        feedbackText.text = if (score >= 3) "Great job !!" else "Keep practicing"

        reviewButton.setOnClickListener {
            val intent = Intent(this, ReviewActivity::class.java)
            startActivity(intent)
        }
    }
}
// OpenAI (2025) ChatGPT (May 2025 version).
// Available at: https://chatgpt.com/c/682a490b-7d5c-8004-bc3f-f552d25bad94/ (Accessed: 19 May 2025).
