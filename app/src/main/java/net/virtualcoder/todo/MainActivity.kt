package net.virtualcoder.todo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import net.virtualcoder.todo.navigation.SetupNavigation
import net.virtualcoder.todo.ui.theme.ToDoTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController:NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoTheme {
                navController = rememberNavController()
                SetupNavigation(navController = navController)
            }
        }
    }
}
