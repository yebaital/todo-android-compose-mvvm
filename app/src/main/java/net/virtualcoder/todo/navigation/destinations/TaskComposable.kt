package net.virtualcoder.todo.navigation.destinations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.composable
import net.virtualcoder.todo.ui.screens.task.TaskScreen
import net.virtualcoder.todo.ui.viewmodels.SharedViewModel
import net.virtualcoder.todo.util.Action
import net.virtualcoder.todo.util.Constants.TASK_ARGUMENT_KEY
import net.virtualcoder.todo.util.Constants.TASK_SCREEN

@ExperimentalAnimationApi
fun NavGraphBuilder.taskComposable(
    sharedViewModel: SharedViewModel,
    navigateToListScreen: (Action) -> Unit
) {
    composable(
        route = TASK_SCREEN,
        arguments = listOf(navArgument(TASK_ARGUMENT_KEY) {
            type = NavType.IntType
        }),
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { fullWidth -> -fullWidth },
                animationSpec = tween(durationMillis = 600)
            )
        }
    ) { navBackStackEntry ->
        val taskId = navBackStackEntry.arguments!!.getInt(TASK_ARGUMENT_KEY)
        LaunchedEffect(key1 = taskId) {
            sharedViewModel.getSelectedTask(taskId)
        }
        val selectedTask by sharedViewModel.selectedTask.collectAsState()

        /*
        put selectedTask as key instead of taskId to prevent empty task screen caused by
        LaunchEffect executing before selectedTask is retrieved
        */
        LaunchedEffect(key1 = selectedTask) {
            //to prevent undo bug execute updateTaskFields only when conditions below
            if (selectedTask != null || taskId == -1) {
                sharedViewModel.updateTaskFields(selectedTask = selectedTask)
            }

        }

        TaskScreen(
            selectedTask = selectedTask,
            navigateToListScreen = navigateToListScreen,
            sharedViewModel = sharedViewModel
        )
    }
}