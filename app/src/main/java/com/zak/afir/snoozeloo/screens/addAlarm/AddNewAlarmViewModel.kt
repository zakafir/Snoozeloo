@file:OptIn(ExperimentalFoundationApi::class)

package com.zak.afir.snoozeloo.screens.addAlarm

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.text2.input.textAsFlow
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import timber.log.Timber

class AddNewAlarmViewModel : ViewModel() {
    var state by mutableStateOf(NewAlarmState())
        private set

    init {
        combine(
            state.hours.textAsFlow(),
            state.minutes.textAsFlow(),
            state.alarmName.textAsFlow()
        ) { hours, minutes, alarmName ->
            state = state.copy(
                canSaveAlarm = hours.isNotEmpty() && minutes.isNotEmpty() && alarmName.isNotEmpty()
            )
        }.launchIn(viewModelScope)
    }

    fun onAction(action: NewAlarmAction) {
        when (action) {
            is NewAlarmAction.OnSaveAlarmClicked -> {
                if (state.canSaveAlarm) {
                    Timber.d("Saved Alarm, name: ${state.alarmName}, hours: ${state.hours}, minutes: ${state.minutes}")
                } else {
                    Timber.d("Cannot save Alarm")
                }
            }
            else -> {

            }
        }
    }
}
