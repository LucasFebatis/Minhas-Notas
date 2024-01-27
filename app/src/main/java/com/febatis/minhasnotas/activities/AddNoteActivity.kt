package com.febatis.minhasnotas.activities

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.febatis.minhasnotas.R
import com.febatis.minhasnotas.room.AppDatabase
import com.febatis.minhasnotas.room.Note
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddNoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        val noteEditText : TextInputEditText = findViewById(R.id.note_edit_text)
        val saveNoteButton : Button = findViewById(R.id.save_note_button)

        saveNoteButton.setOnClickListener {
            val note = Note(note = noteEditText.text.toString())
            saveNote(note)
        }
    }

    private fun saveNote(note: Note) {

        lifecycleScope.launch {

            withContext(Dispatchers.IO) {
                val db = Room.databaseBuilder(
                    applicationContext,
                    AppDatabase::class.java, "database-name"
                )
                    .fallbackToDestructiveMigration()
                    .build()

                val noteDao = db.noteDao()
                noteDao.insertAll(note)
            }
        }
    }

}