package com.febatis.minhasnotas.activities

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.febatis.minhasnotas.R

class ContentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)

        val id = intent.getIntExtra("id", 0)
        val note = intent.getStringExtra("note")

        val tvId: TextView = findViewById(R.id.tv_id)
        val tvNote: TextView = findViewById(R.id.tv_note)

        tvId.text = id.toString()
        tvNote.text = note
    }
}