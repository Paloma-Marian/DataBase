package com.example.auladatabase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.auladatabase.ui.theme.AulaDataBaseTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import com.example.auladatabase.screen.FormScreen
import com.example.auladatabase.screen.ListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AulaDataBaseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar() {
                Button(onClick = { navController.navigate("form") }) {
                    Text(text = "Add")
                }
            }
        }
    ) {
        Column(modifier = Modifier.padding(paddingValues = it)) {
            NavHost(
                navController = navController,
                startDestination = "list" ) {
                composable("list") {
                    ListScreen()
                }
                composable("form") {
                    FormScreen(onAfterSave = {
                        navController.navigateUp()
                        coroutineScope.launch {
                            scaffoldState.snackbarHostState.showSnackbar(
                                message = "User registered"
                            )
                        }
                    },
                        onBack = {
                            navController.navigateUp()
                        }
                    )
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AulaDataBaseTheme {
        MyApp()
    }
}