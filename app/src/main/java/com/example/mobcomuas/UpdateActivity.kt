package com.example.mobcomuas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mobcomuas.databinding.ActivityUpdateBinding

class UpdateActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUpdateBinding
    private lateinit var notesDatabaseHelper: NotesDatabaseHelper
    private var noteId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        notesDatabaseHelper = NotesDatabaseHelper(this)

        noteId = intent.getIntExtra("note_id", -1)
        if (noteId == -1) {
            finish()
            return
        }

        val note = notesDatabaseHelper.getNoteById(noteId)
        binding.noteTitle.setText(note.title)
        binding.noteDescription.setText(note.description)
        binding.noteQuantity.setText(note.quantity)

        binding.updateSaveButton.setOnClickListener {
            val title = binding.noteTitle.text.toString()
            val description = binding.noteDescription.text.toString()
            val quantity = binding.noteQuantity.text.toString()
            val note = Note(
                id = noteId,
                title = title,
                description = description,
                quantity = quantity
            )
            notesDatabaseHelper.updateNote(note)
            finish()
            Toast.makeText(this, "Note updated", Toast.LENGTH_SHORT).show()
        }
    }
}