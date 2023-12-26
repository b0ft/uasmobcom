package com.example.mobcomuas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mobcomuas.databinding.ActivityAddNoteBinding

class AddNoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddNoteBinding
    private lateinit var notesDatabaseHelper: NotesDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        notesDatabaseHelper = NotesDatabaseHelper(this)

        binding.saveButton.setOnClickListener {
            val title = binding.noteTitle.text.toString()
            val description = binding.noteDescription.text.toString()
            val quantity = binding.noteQuantity.text.toString()
            val note = Note(
                id = 0,
                title = title,
                description = description,
                quantity = quantity
            )
            notesDatabaseHelper.addNote (note)
            finish()
            Toast.makeText(this, "Note saved", Toast.LENGTH_SHORT).show()
        }

    }
}