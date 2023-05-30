package com.example.auladatabase.entity

import androidx.room.Entity;
import androidx.room.PrimaryKey;

//Tabela dos dados 1 usuário pra muitas viagens
@Entity(tableName = "viagem")
data class Viagem (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val idUsu: Int = 0,
    val tipo: Char, //Negocio ou Laser
    val orcamento: Double,
    val destino: String,
    val dataIni: String,
    val dataFim: String){
}