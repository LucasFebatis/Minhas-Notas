package com.febatis.minhasnotas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ContentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)

        val textView : TextView = findViewById(R.id.textView)

        val messageText = intent.getStringExtra("message")

        textView.text = messageText

    }
}