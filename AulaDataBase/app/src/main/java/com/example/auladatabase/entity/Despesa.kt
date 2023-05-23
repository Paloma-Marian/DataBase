package com.example.auladatabase.entity

import android.provider.ContactsContract
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.sql.RowId

//Tabela dos dados de uma despesa pra uma viagem
@Entity(tableName = "user")
data class Despesa (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val data: ContactsContract.RawContacts.Data,
    val tipo: String,
    val valor: Double
){
}