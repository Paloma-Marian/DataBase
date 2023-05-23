package com.example.auladatabase.entity

import android.provider.ContactsContract.RawContacts.Data
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//Tabela dos dados uma viagem pra uma despesa e muitas viagens pra um usuário.
@Entity(tableName = "user")
data class Viagem(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val destino: String,
    val tipo: String ,
    val Orçamento: Double,
    val DataInicial: Data,
    val DataFinal: Data,
){
}