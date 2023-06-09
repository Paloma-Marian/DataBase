package com.example.auladatabase.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.auladatabase.database.AppDatabase
import com.example.auladatabase.repository.UserRepository

//"Fábrica" para a base de dados
class ListUserViewModelFactory(val application: Application) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val dao = AppDatabase.getDatabase(application).userDao()
        val userRepository = UserRepository(dao)
        return ListUserViewModel(userRepository) as T
    }

}