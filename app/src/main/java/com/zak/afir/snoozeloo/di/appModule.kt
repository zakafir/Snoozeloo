package com.zak.afir.snoozeloo.di

import com.zak.afir.snoozeloo.screens.addAlarm.AddNewAlarmViewModel
import com.zak.afir.snoozeloo.screens.showAlarms.AlarmsViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::AlarmsViewModel)
    viewModelOf(::AddNewAlarmViewModel)
}