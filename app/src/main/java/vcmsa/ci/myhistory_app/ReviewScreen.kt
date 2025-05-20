package vcmsa.ci.myhistory_app

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.util.Log


class ReviewScreen : AppCompatActivity() {

    // declaring again the array of questions and its corresponding answers but this time it's for a review after giving
    //the feedback to the usr so that he can improve
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
        setContentView(R.layout.activity_reviewscreen)

        val reviewQuiz = findViewById<TextView>(R.id.reviewQuiz)

        val builder = StringBuilder()
        for (i in questions.indices) {
            builder.append("Q${i + 1}: ${questions[i]}\n")
            builder.append("Answer: ${answers[i]}\n\n")
        }

        reviewQuiz.text = builder.toString()
    }
}
// OpenAI (2025) ChatGPT (May 2025 version).
// Available at: https://chatgpt.com/c/682a490b-7d5c-8004-bc3f-f552d25bad94/ (Accessed: 19 May 2025).
