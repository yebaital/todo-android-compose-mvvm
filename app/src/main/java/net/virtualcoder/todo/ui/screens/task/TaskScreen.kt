package net.virtualcoder.todo.ui.screens.task

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import net.virtualcoder.todo.data.models.Priority
import net.virtualcoder.todo.data.models.ToDoTask
import net.virtualcoder.todo.util.Action

@Composable
fun TaskScreen(
    selectedTask: ToDoTask?,
    navigateToListScreen: (Action) -> Unit
) {
    Scaffold(
        topBar = {
            TaskAppBar(
                selectedTask,
                navigateToListScreen = navigateToListScreen
            )
        },
        content = {
            TaskContent(
                title = "",
                onTitleChange = {},
                description = "",
                onDescriptionChange = {},
                priority = Priority.LOW,
                onPrioritySelected = {}
            )
        }
    )
}