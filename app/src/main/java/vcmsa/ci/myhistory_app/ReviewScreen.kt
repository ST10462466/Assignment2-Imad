package vcmsa.ci.myhistory_app

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ReviewActivity : AppCompatActivity() {

    private val questions = arrayOf(
        "The Great Wall of China is visible from space.",
        "The Renaissance began in the 14th century.",
        "Julius Caesar was a Roman emperor.",
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

        val reviewText = findViewById<TextView>(R.id.reviewQuiz)

        val builder = StringBuilder()
        for (i in questions.indices) {
            builder.append("Q${i + 1}: ${questions[i]}\n")
            builder.append("Answer: ${answers[i]}\n\n")
        }

        reviewText.text = builder.toString()
    }
}
