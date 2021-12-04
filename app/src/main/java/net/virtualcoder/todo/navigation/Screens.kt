package net.virtualcoder.todo.navigation

import androidx.navigation.NavHostController
import net.virtualcoder.todo.util.Action
import net.virtualcoder.todo.util.Constants.LIST_SCREEN

class Screens(navController: NavHostController) {

    val list: (Action) -> Unit = { action ->
        navController.navigate("/list/${action.name}") {
            popUpTo(LIST_SCREEN) { inclusive = true }
        }
    }

    val task: (Int) -> Unit = { taskId ->
        navController.navigate("task/$taskId")
    }

}