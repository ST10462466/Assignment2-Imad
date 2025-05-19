package vcmsa.ci.myhistory_app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class WelcomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_screen)

        // Declaring the textView where the welcome message should appear as well as the start button
        val welcomeMessage = findViewById<TextView>(R.id.welcomeMessage)
        val startButton = findViewById<Button>(R.id.startButton)
        // Moving to the next screen by clicking the start button
        startButton.setOnClickListener {
            val intent = Intent(this, FlashCardScreen::class.java)
            startActivity(intent)
        }
    }
}
