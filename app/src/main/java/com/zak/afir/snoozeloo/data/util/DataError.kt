package com.zak.afir.snoozeloo.data.util

sealed interface DataError: Error {

    enum class Local: DataError {
        DISK_FULL
    }
}