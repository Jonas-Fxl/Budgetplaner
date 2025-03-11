package com.example.finanzapp

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.android.material.datepicker.DateSelector
import java.util.*


@Entity(tableName = "buchungen")
data class Buchung(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val bezeichnung: String,
    val art: String,
    val datum: String,
    val summe: Double,
    val info: String){
}