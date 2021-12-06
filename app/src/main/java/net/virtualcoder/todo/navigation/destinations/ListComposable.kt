package net.virtualcoder.todo.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import net.virtualcoder.todo.ui.screens.list.ListScreen
import net.virtualcoder.todo.ui.viewmodels.SharedViewModel
import net.virtualcoder.todo.util.Constants.LIST_ARGUMENT_KEY
import net.virtualcoder.todo.util.Constants.LIST_SCREEN

fun NavGraphBuilder.listComposable(
    navigateToTaskScreen: (taskId: Int) -> Unit,
    sharedViewModel: SharedViewModel
) {
    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY) {
            type = NavType.StringType
        })
    ) {
        ListScreen(navigateToTaskScreen, sharedViewModel)
    }
}