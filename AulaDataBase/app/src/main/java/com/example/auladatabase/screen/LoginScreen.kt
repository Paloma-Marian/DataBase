package com.example.auladatabase.screen

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.auladatabase.viewModel.LoginViewModel
import com.example.auladatabase.viewModel.LoginViewModelFactory
import com.example.auladatabase.viewModel.RegisterNewViewModel
import com.example.auladatabase.viewModel.RegisterNewUserViewModelFactory
import kotlinx.coroutines.flow.collectLatest

@Composable
fun LoginScreen(onAfterLogin:()->Unit, onBack:() -> Unit) {
    val application = LocalContext.current.applicationContext as Application
    val viewModel: LoginViewModel = viewModel(
        factory = LoginViewModelFactory(application)
    )
    val ctx = LocalContext.current

    val scaffoldState = rememberScaffoldState()
    LaunchedEffect(Unit) {
        viewModel.toastMessage.collectLatest {
            scaffoldState.snackbarHostState.showSnackbar(
                message = it,
                duration = SnackbarDuration.Long
            )
            // opção para mostrar as mensagens
            // Toast.makeText(ctx, it, Toast.LENGTH_SHORT).show()
        }
    }


    val focusManager = LocalFocusManager.current


    Scaffold(scaffoldState = scaffoldState ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues = it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            OutlinedTextField(
                value = viewModel.name,
                onValueChange = { viewModel.name = it},
                label = {
                    Text(text = "Name")
                }
            )

            OutlinedTextField(
                value = viewModel.password,
                onValueChange = { viewModel.password = it},
                label = {
                    Text(text = "Password")
                }
            )
            Row() {
                Button(onClick = {
                    focusManager.clearFocus()
                    viewModel.validateLogin(onResult = {
                        if (it) {
                            onAfterLogin()
                        }
                    })
                }) {
                    Text(text = "Login")
                }
                Spacer(modifier = Modifier.size(8.dp))
                Button(
                    onClick = {
                        onBack()
                    }) {
                    Text(text = "Back")
                }


            }

        }
    }

}