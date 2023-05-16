package com.example.auladatabase.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.auladatabase.dao.UserDao
import com.example.auladatabase.entity.User

//faz a instância da base...
@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(application: Application): AppDatabase = INSTANCE ?: synchronized(this){
            val instance = Room.databaseBuilder(
                application,
                AppDatabase::class.java,
                "my-db1"
            ).build()
            INSTANCE = instance
            instance
        }
    }

}
