package com.zak.afir.snoozeloo.screens.addAlarm

sealed interface NewAlarmAction {
    data object OnSaveAlarmClicked : NewAlarmAction
    data object OnNavigateBack: NewAlarmAction
}
