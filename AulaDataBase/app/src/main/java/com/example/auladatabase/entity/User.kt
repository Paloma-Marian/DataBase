package com.example.auladatabase.entity

import androidx.room.Entity;
import androidx.room.PrimaryKey;

//Tabela dos dados
@Entity(tableName = "user")
data class User (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val email: String,
    val password: String){
}