package net.virtualcoder.todo.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import net.virtualcoder.todo.util.Action
import net.virtualcoder.todo.util.Constants.TASK_ARGUMENT_KEY
import net.virtualcoder.todo.util.Constants.TASK_SCREEN

fun NavGraphBuilder.taskComposable(navigateToListScreen: (Action) -> Unit) {
    composable(
        route = TASK_SCREEN,
        arguments = listOf(navArgument(TASK_ARGUMENT_KEY) {
            type = NavType.IntType
        })
    ) {

    }
}