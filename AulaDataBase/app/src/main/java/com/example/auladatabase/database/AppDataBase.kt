package com.example.auladatabase.database

import android.content.Context
import androidx.room.Database;
import androidx.room.Room.databaseBuilder
import com.example.auladatabase.dao.UserDao
import com.example.auladatabase.entity.User
import kotlin.jvm.Volatile;

@Database(entities = [User::class], version = 1)
abstract class AppDataBase:RoomDataBase() {

    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase = INSTANCE ?: synchronized(this) {
            val instance = databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "my-db1"
            ).build()
            INSTANCE = instance
            instance
        }
    }
}
