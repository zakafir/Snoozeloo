package com.zak.afir.snoozeloo.data

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface AlarmDao {

    @Upsert
    fun upsert(alarmEntity: AlarmEntity)

    @Query("SELECT * FROM alarms WHERE id = :id")
    fun getAlarmById(id: Int): Flow<AlarmEntity?>

    @Query("SELECT * FROM alarms")
    fun getAllAlarms(): Flow<List<AlarmEntity>>


    @Query("DELETE FROM alarms WHERE id = :id")
    fun deleteAlarmById(id: Int)


}