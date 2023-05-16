package com.example.auladatabase.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.auladatabase.entity.User

@Dao
interface UserDao {

    @Insert
    fun insert(user: User)

    @Update
    suspend fun update(user: User)

    @Delete
    suspend fun delete(user: User)

    @Query("select * from user u order by u.name ")
    suspend fun getAll(): List<User>

    @Query("select * from user u where u.name = :name")
    suspend fun findByName(name: String): User



}
