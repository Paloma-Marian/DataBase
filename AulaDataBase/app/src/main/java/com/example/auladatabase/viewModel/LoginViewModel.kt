package com.example.auladatabase.viewModel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.auladatabase.entity.User
import com.example.auladatabase.repository.UserRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch


class LoginViewModel(private val userRepository: UserRepository): ViewModel() {

    var name by mutableStateOf("")
    var password by mutableStateOf("")

    private val _toastMessage = MutableSharedFlow<String>()
    val toastMessage = _toastMessage.asSharedFlow()


    fun validateLogin(onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            val user = userRepository.findByName(name)
            val result = user != null && user.password == password
            onResult(result)
            if (!result )
                _toastMessage.emit("Invalid login")
        }

    }








}