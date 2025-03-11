package com.example.finanzapp

import androidx.room.*


@Dao
interface BuchungDAO {
    @Query("SELECT*from buchungen")
    fun getAll(): List<Buchung>

    @Insert
    fun insertAll(vararg buchung: Buchung)

    @Delete
    fun delete(buchung:  Buchung)

    @Update
    fun update(vararg buchung: Buchung)
}