@file:OptIn(ExperimentalFoundationApi::class)

package com.zak.afir.snoozeloo.screens.addAlarm

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.text2.input.textAsFlow
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zak.afir.snoozeloo.data.AlarmRepository
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import timber.log.Timber

class AddNewAlarmViewModel(
    private val alarmRepository: AlarmRepository
) : ViewModel() {
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
                    val alarm = Alarm(
                        id = 0,
                        hour = state.hours.text.toString().toInt(),
                        minute = state.minutes.text.toString().toInt(),
                        label = state.alarmName.text.toString()
                    )
                    // TODO: save alarm
                    alarmRepository.saveAlarm(alarm)
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
