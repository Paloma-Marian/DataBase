package com.example.auladatabase.entity

import androidx.room.Entity;
import androidx.room.PrimaryKey;

//Tabela dos dados 1 viagem pra muitos gastos
@Entity(tableName = "despesa")
data class Despesa (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val idViagem: Int = 0,
    val data: String,
    val tipo: Char, //alimentação, ospedagem, turismo
    val descricao: String,
    val valor: Double){
}