package net.virtualcoder.todo.navigation.destinations

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import net.virtualcoder.todo.ui.screens.task.TaskScreen
import net.virtualcoder.todo.ui.viewmodels.SharedViewModel
import net.virtualcoder.todo.util.Action
import net.virtualcoder.todo.util.Constants.TASK_ARGUMENT_KEY
import net.virtualcoder.todo.util.Constants.TASK_SCREEN

fun NavGraphBuilder.taskComposable(
    sharedViewModel: SharedViewModel,
    navigateToListScreen: (Action) -> Unit
) {
    composable(
        route = TASK_SCREEN,
        arguments = listOf(navArgument(TASK_ARGUMENT_KEY) {
            type = NavType.IntType
        })
    ) { navBackStackEntry ->
        val taskId = navBackStackEntry.arguments!!.getInt(TASK_ARGUMENT_KEY)
        sharedViewModel.getSelectedTask(taskId)
        val selectedTask by sharedViewModel.selectedTask.collectAsState()

        TaskScreen(
            selectedTask,
            navigateToListScreen = navigateToListScreen
        )
    }
}