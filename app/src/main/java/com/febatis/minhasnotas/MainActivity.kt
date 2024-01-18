package com.febatis.minhasnotas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val editText : EditText = findViewById(R.id.editText)
        val button : Button = findViewById(R.id.button)


        button.setOnClickListener {
            // intent = Uma instância do tipo Intent
            val intent = Intent(this, ContentActivity::class.java)

            intent.putExtra("message", editText.text.toString())

            startActivity(intent)
        }

    }
}