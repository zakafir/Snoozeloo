@file:OptIn(ExperimentalFoundationApi::class)

package com.zak.afir.snoozeloo.screens.addAlarm
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.text2.input.TextFieldState

data class NewAlarmState(
    val hours: TextFieldState = TextFieldState(),
    val minutes: TextFieldState = TextFieldState(),
    val alarmName: TextFieldState = TextFieldState(),
    val canSaveAlarm: Boolean = false
)
