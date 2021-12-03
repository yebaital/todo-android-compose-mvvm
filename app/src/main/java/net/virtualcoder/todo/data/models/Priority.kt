package net.virtualcoder.todo.data.models


import androidx.compose.ui.graphics.Color
import net.virtualcoder.todo.ui.theme.HighPriorityColor
import net.virtualcoder.todo.ui.theme.LowPriorityColor
import net.virtualcoder.todo.ui.theme.MediumPriorityColor
import net.virtualcoder.todo.ui.theme.NonePriorityColor

enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}