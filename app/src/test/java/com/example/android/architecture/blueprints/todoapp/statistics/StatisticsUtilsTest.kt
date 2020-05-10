package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Test

class StatisticsUtilsTest {
    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero() {

        // Create an active task (the false makes this active)
        val tasks = listOf(
                Task("title", "desc", isCompleted = false)
        )
        // Call your function
        val result = getActiveAndCompletedStats(tasks)
        // Check the result
        assertThat(result.completedTasksPercent, `is`(0f))
        assertThat(result.activeTasksPercent, `is`(100f))

    }
    @Test
    fun getActiveAndCompleteStats_threeActiveTwoComplete_returnSixtyFourty(){
        val tasks1 = listOf(
                Task("title", "desc", isCompleted = false),
                Task("title", "desc", isCompleted = false),
                Task("title", "desc", isCompleted = false),
                Task("title", "desc", isCompleted = true),
                Task("title", "desc", isCompleted = true)
        )

        val result1 = getActiveAndCompletedStats(tasks1)

        assertThat(result1.activeTasksPercent, `is`(60f))
        assertThat(result1.completedTasksPercent, `is`(40f))


    }
    @Test
    fun getActiveAndCompleteStats_emptylist_returnZeros(){
        val emptyList = listOf<Task>()

        val result2 = getActiveAndCompletedStats(emptyList)
        assertThat(result2.activeTasksPercent, `is`(0f))
        assertThat(result2.completedTasksPercent, `is`(0f))
    }

    @Test
    fun getActiveAndCompletedStats_error_returnsZeros() {
        // When there's an error loading stats
        val result = getActiveAndCompletedStats(null)

        // Both active and completed tasks are 0
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }
}