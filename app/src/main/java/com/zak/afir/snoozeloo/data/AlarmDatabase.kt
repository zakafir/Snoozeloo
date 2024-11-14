package com.zak.afir.snoozeloo.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [AlarmEntity::class],
    version = 1
)
abstract class AlarmDatabase : RoomDatabase() {
    abstract val alarmDao: AlarmDao
}
