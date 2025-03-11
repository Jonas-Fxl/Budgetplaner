package com.example.finanzapp

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = arrayOf(Buchung::class), version = 1)
abstract class AppDatenbank : RoomDatabase() {
    abstract fun buchungDao() : BuchungDAO
}