package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listView = this.findViewById<ListView>(R.id.ListView)
        listView.adapter = ArrayAdapter<ToDo>(
            this,
            android.R.layout.simple_list_item_1,
            android.R.id.text1,
            toDoRepository.getAllToDos()
        )
        listView.setOnItemClickListener{parent, view, position, id ->
            val selectToDo:ToDo = listView.adapter.getItem(position) as ToDo
            val intent = Intent(this, ViewToDoActivity::class.java)
            intent.putExtra("EXTRA_TODO_ID", selectToDo.id)
            startActivity(intent)
        }
        val createButton = this.findViewById<Button>(R.id.createButton)
        createButton.setOnClickListener{
            val intent = Intent(this@MainActivity, CreateToDoActivity::class.java)
            startActivity(intent)
        }



    }
}
