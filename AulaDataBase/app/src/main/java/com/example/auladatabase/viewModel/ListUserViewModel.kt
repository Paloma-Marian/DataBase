package com.example.auladatabase.viewModel

import androidx.compose.runtime.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.auladatabase.entity.User
import com.example.auladatabase.repository.UserRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class ListUserViewModel(private val userRepository: UserRepository): ViewModel() {

    var users: MutableState<List<User>> = mutableStateOf(listOf())

    var showDialogDelete = mutableStateOf(false)

    var userForDelete: User? by mutableStateOf(null)

    //Faz um select na base para trazer os dados salvos na base de usuários
    fun loadAllUsers(){
        viewModelScope.launch {
            users.value = userRepository.loadAllUsers()
        }
    }

    //Deleta na base de dados o usuário selecionado
    fun deleteUser() {
        viewModelScope.launch {
            userForDelete?.let {
                userRepository.delete(it)
                loadAllUsers()
            }
        }
    }
}