package com.zak.afir.snoozeloo.data

import com.zak.afir.snoozeloo.data.util.DataError
import com.zak.afir.snoozeloo.data.util.Result

class SaveAlarmRepository(
    private val alarmDao: AlarmDao
) {

    fun saveAlarm(alarmEntity: AlarmEntity): Result<String, DataError.Local> {
        return try {
            val entity = alarm.toAlarmEntity
            alarmDao.upsert(alarmEntity)
            Result.Success("Alarm saved successfully")
        } catch (e: Exception) {
            return Result.Error(DataError.Local.DISK_FULL)
        }
    }

    fun updateAlarm(alarmEntity: AlarmEntity): Result<String, DataError.Local> {
        alarmDao.upsert(alarmEntity)
    }
}