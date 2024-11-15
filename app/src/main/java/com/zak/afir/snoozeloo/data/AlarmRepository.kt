package com.zak.afir.snoozeloo.data

import com.zak.afir.snoozeloo.data.util.DataError
import com.zak.afir.snoozeloo.data.util.Result
import com.zak.afir.snoozeloo.screens.addAlarm.Alarm

class AlarmRepository(
    private val alarmDao: AlarmDao
) {

    fun upsert(alarm: Alarm): Result<String, DataError.Local> {
        return try {
            val entity = alarm.toAlarmEntity()
            alarmDao.upsert(entity)
            Result.Success(entity.id.toString())
        } catch (e: Exception) {
            return Result.Error(DataError.Local.DISK_FULL)
        }
    }
}