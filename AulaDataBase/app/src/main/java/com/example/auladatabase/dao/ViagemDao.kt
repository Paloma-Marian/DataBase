package com.example.auladatabase.dao

import androidx.room.*
import com.example.auladatabase.entity.Viagem

//Movimentação da base de dados para Deletar, Inserir, Selecionar ...
@Dao
interface ViagemDao {

    @Insert
    fun insert(viagem: Viagem)

    @Update
    suspend fun update(viagem: Viagem)

    @Delete
    suspend fun delete(viagem: Viagem)

    @Query("select * from viagem v order by v.idUsu ")
    suspend fun getAll(): List<Viagem>

    @Query("select * from viagem v where v.idUsu = :idUsu")
    suspend fun findByName(idUsu: Integer): Viagem

}

/*
    val id: Int = 0,
    val idUsu: Int = 0,
    val tipo: Char, //Negocio ou Laser
    val orcamento: Double,
    val destino: String,
    val dataIni: String,
    val dataFim: String

*/