package com.zak.afir.snoozeloo.screens.addAlarm

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.zak.afir.snoozeloo.ui.theme.SnoozelooTheme
import org.koin.androidx.compose.koinViewModel

@Composable

fun AddNewAlarmScreenRoot(viewModel: AddNewAlarmViewModel = koinViewModel()) {
    AddNewAlarmScreenRootScreen()
}

@Composable
private fun AddNewAlarmScreenRootScreen() {
    Text(text = "Add New Alarm Screen")
}

@Preview
@Composable
private fun AddNewAlarmScreenRootScreenPreview() {
    SnoozelooTheme {
        AddNewAlarmScreenRootScreen()
    }
}