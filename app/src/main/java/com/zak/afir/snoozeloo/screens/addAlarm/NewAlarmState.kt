@file:OptIn(ExperimentalFoundationApi::class)

package com.zak.afir.snoozeloo.screens.addAlarm

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.text2.input.TextFieldState
import com.zak.afir.snoozeloo.data.AlarmEntity

data class NewAlarmState(
    val hours: TextFieldState = TextFieldState(),
    val minutes: TextFieldState = TextFieldState(),
    val alarmName: TextFieldState = TextFieldState(),
    val canSaveAlarm: Boolean = false
)

data class Alarm(
    val id: Int,
    val hour: Int,
    val minute: Int,
    val label: String,
    val ringtone: String? = null,
    val ringtoneUri: String? = null
) {
    fun toAlarmEntity(): AlarmEntity {
        return AlarmEntity(
            id = id,
            hour = hour,
            minute = minute,
            label = label,
            ringtone = ringtone,
            ringtoneUri = ringtoneUri
        )
    }
}