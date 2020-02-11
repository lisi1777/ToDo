package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class CreateToDoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_to_do)


        val saveButton = this.findViewById<Button>(R.id.saveButton)
        saveButton.setOnClickListener{
            val title = this.findViewById<EditText>(
                R.id.editText
            ).editableText.toString()
            val content = this.findViewById<EditText>(
                R.id.editText2
            ).editableText.toString()

            val intent = Intent(this@CreateToDoActivity, ViewToDoActivity::class.java)
            val createId = toDoRepository.addToDo(title,content)
            intent.putExtra("EXTRA_TODO_ID", createId)


            startActivity(intent)
        }
    }
}
