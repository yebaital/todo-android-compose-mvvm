package net.virtualcoder.todo.navigation

import androidx.navigation.NavHostController
import net.virtualcoder.todo.util.Action
import net.virtualcoder.todo.util.Constants.LIST_SCREEN
import net.virtualcoder.todo.util.Constants.SPLASH_SCREEN

class Screens(navController: NavHostController) {

    val splash: () -> Unit = {
        navController.navigate(route = "list/${Action.NO_ACTION}") {
            //remove splash screen from backstack
            popUpTo(SPLASH_SCREEN) { inclusive = true }
        }
    }

    val list: (Int) -> Unit = { taskId ->
        navController.navigate("task/$taskId")
    }

    val task: (Action) -> Unit = { action ->
        //IMPORTANT: NO SLASH AT THE START OF THE ROUTE
        navController.navigate("list/${action.name}") {
            popUpTo(LIST_SCREEN) { inclusive = true }
        }
    }

}