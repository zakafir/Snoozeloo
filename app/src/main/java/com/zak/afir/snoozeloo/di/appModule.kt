package com.zak.afir.snoozeloo.di

import androidx.room.Room
import com.zak.afir.snoozeloo.data.AlarmDatabase
import com.zak.afir.snoozeloo.data.AlarmRepository
import com.zak.afir.snoozeloo.screens.addAlarm.AddNewAlarmViewModel
import com.zak.afir.snoozeloo.screens.showAlarms.AlarmsViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            AlarmDatabase::class.java,
            "alarm.db"
        ).build()
    }
    viewModelOf(::AlarmsViewModel)
    viewModelOf(::AddNewAlarmViewModel)
    single { AlarmRepository(get()) }
    single { get<AlarmDatabase>().alarmDao }
}