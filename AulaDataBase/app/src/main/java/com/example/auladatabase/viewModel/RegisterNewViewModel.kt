package com.example.auladatabase.viewModel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.auladatabase.entity.User
import com.example.auladatabase.repository.UserRepository
import io.reactivex.internal.operators.single.SingleDoOnSuccess
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class RegisterNewViewModel(private val userRepository: UserRepository): ViewModel() {

    var name by mutableStateOf("")
    var email by mutableStateOf("")
    var password by mutableStateOf("")

    var isNameValid by mutableStateOf(true)

    private val _toastMessage = MutableSharedFlow<String>()
    val toastMessage = _toastMessage.asSharedFlow()

    private fun validateFields() {
        isNameValid = name.isNotEmpty()
        if (!isNameValid) {
            throw Exception("Name is required")
        }
    }

    //registra o usuário na base de dados
    fun registrar(onSuccess: () -> Unit) {
        try {
            validateFields()
            val newUser = User(name = name, email = email, password = password)
            userRepository.addUser(newUser)
            onSuccess()
        }
        catch (e: Exception) {
            viewModelScope.launch {
                _toastMessage.emit(e.message?: "Unknown error")
            }
        }

    }

}