package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class UpdateToDoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_to_do)

        val selectedId = intent.getIntExtra("EXTRA_TODO_ID", 0)
        val view = toDoRepository.getToDoById(selectedId)
        val viewTitle = findViewById<TextView>(R.id.editText3)
        viewTitle.text = view!!.title
        val viewContent = findViewById<TextView>(R.id.editText4)
        viewContent.text = view.content

        val updateButton = this.findViewById<Button>(R.id.update_update_button)
        updateButton.setOnClickListener{

            val newTitle = this.findViewById<EditText>(
                R.id.editText3
            ).editableText.toString()
            val newContent = this.findViewById<EditText>(
                R.id.editText4
            ).editableText.toString()
            toDoRepository.updateToDoById(selectedId, newTitle,newContent)
            val intent = Intent(this, ViewToDoActivity::class.java)
            intent.putExtra("EXTRA_TODO_ID", selectedId)
            finish()
            startActivity(intent)

        }
    }


}
