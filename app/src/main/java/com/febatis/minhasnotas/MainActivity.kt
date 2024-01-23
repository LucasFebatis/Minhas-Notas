package com.febatis.minhasnotas

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fabAddNote : FloatingActionButton = findViewById(R.id.fab_add_note)

        fabAddNote.setOnClickListener {
            val intent = Intent(this, AddNoteActivity::class.java)
            startActivity(intent)
        }

        recoverNotes()
    }

    private fun recoverNotes() {
        lifecycleScope.launch {

            val listNotes = mutableListOf<Note>()

            withContext(Dispatchers.IO) {
                val db = Room.databaseBuilder(
                    applicationContext,
                    AppDatabase::class.java, "database-name"
                )
                    .fallbackToDestructiveMigration()
                    .build()

                val noteDao = db.noteDao()
                listNotes.addAll(noteDao.getAll())
            }

            withContext(Dispatchers.Main) {

                val notesTextView : TextView = findViewById(R.id.notes_text_view)
                notesTextView.text = listNotes.joinToString { it.note ?: "<Sem Valor>" }

            }
        }
    }
}