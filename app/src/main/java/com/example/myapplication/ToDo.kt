package com.example.myapplication

data class ToDo(
    val id: Int,
    var title: String,
    var content: String
){

    override fun toString() = title

}

