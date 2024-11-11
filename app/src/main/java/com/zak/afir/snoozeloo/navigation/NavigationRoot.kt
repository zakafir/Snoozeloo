package com.zak.afir.snoozeloo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.zak.afir.snoozeloo.screens.addAlarm.AddNewAlarmScreenRoot
import com.zak.afir.snoozeloo.screens.showAlarms.AlarmsScreenRoot

@Composable
fun NavigationRoot(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = "alarms"
    ) {
        alarmsGraph(navController)
    }
}

fun NavGraphBuilder.alarmsGraph(navController: NavHostController) {
    composable(route = "alarms") {
        AlarmsScreenRoot(
            onAddNewAlarmClick = {
                navController.navigate("addNewAlarm")
            }
        )
    }
    composable(route = "addNewAlarm") {
        AddNewAlarmScreenRoot(
            onNavigateBack = {
                navController.navigateUp()
            }
        )
    }
}
