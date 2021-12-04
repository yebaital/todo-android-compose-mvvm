package net.virtualcoder.todo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import net.virtualcoder.todo.navigation.destinations.listComposable
import net.virtualcoder.todo.navigation.destinations.taskComposable
import net.virtualcoder.todo.util.Constants.LIST_SCREEN

@Composable
fun SetupNavigation(navController: NavHostController) {

    //save backstack throughout application with remember
    val screen = remember(navController) {
        Screens(navController)
    }

    NavHost(
        navController = navController,
        startDestination = LIST_SCREEN
    ) {
        listComposable(navigateToTaskScreen = screen.task)
        taskComposable(navigateToListScreen = screen.list)
    }

}