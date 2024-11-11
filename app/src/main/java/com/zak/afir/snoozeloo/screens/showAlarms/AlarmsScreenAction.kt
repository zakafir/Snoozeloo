package com.zak.afir.snoozeloo.screens.showAlarms

sealed interface AlarmsScreenAction {
    data object OnAddNewAlarmClick : AlarmsScreenAction
}