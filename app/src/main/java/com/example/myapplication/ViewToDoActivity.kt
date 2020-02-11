package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class ViewToDoActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_TODO_ID = "TODO_ID"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_to_do)

        val selectedId = intent.getIntExtra("EXTRA_TODO_ID", 0)
        val toDo = toDoRepository.getToDoById(selectedId)
        val viewTitle = findViewById<TextView>(R.id.toDo_view_title)
        viewTitle.text = toDo?.title
        val viewContent = findViewById<TextView>(R.id.toDo_view_content)
        viewContent.text = toDo?.content

        val deleteButton = this.findViewById<Button>(R.id.toDo_view_delete)
        deleteButton.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle(R.string.popup_title)
                .setMessage(R.string.popup_message)
                .setPositiveButton(
                    R.string.yes_button
                ) { dialog, whichButton ->
                    toDoRepository.deleteToDoById(selectedId)
                    val intent = Intent(this@ViewToDoActivity, MainActivity::class.java)
                    startActivity(intent)
                }.setNegativeButton(
                    R.string.no_button
                ) { dialog, NegativeButton ->

                }.show()
        }

        val updateButton = this.findViewById<Button>(R.id.toDo_view_update)
        updateButton.setOnClickListener {
            val intent = Intent(this, UpdateToDoActivity::class.java)
            intent.putExtra("EXTRA_TODO_ID", selectedId)
            startActivity(intent)
        }

        val homeButton = this.findViewById<Button>(R.id.toDo_view_home)
        homeButton.setOnClickListener {
            val intent = Intent(this@ViewToDoActivity, MainActivity::class.java)
            startActivity(intent)
        }

    }
}
