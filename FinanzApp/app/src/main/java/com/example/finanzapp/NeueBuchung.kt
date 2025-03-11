package com.example.finanzapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract.Helpers.insert
import androidx.core.widget.addTextChangedListener
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_neue_buchung.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NeueBuchung : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_neue_buchung)

        bezeichnungText.addTextChangedListener {
            if (it!!.count() > 0)
                beschreibung_layout.error = null
        }
        summeText.addTextChangedListener {
            if (it!!.count() > 0)
                summe_layout.error = null
        }
        datumText.addTextChangedListener {
            if (it!!.count() > 0)
                datum_layout.error = null
        }
        artText.addTextChangedListener {
            if (it!!.count() > 0)
                art_layout.error = null
        }


        buchungspeichern.setOnClickListener {
            val bezeichnung = bezeichnungText.text.toString()
            val summe = summeText.text.toString().toDoubleOrNull()
            val datum = datumText.text.toString()
            val art = artText.text.toString()
            val info = beschreibungText.text.toString()

            if (bezeichnung.isEmpty())
                bezeichung_layout.error = "Bitte eine Bezeichnung eingeben."
            if (art.isEmpty())
                art_layout.error = "Bitte definieren: Budget, Einnahme, Ausgabe."
            if (datum.isEmpty())
                datum_layout.error = "Geben Sie ein gültiges Datum ein."
            else if (summe == null)
                summe_layout.error = "Bitte Betrag eingeben."

            else {
                val buchung = Buchung(0,bezeichnung,art,datum,summe,info)
                einfuegen(buchung)
            }
        }

        schliessen.setOnClickListener{
            finish()
        }
    }

    private fun einfuegen(buchung: Buchung){
        val  db = Room.databaseBuilder(this,
            AppDatenbank::class.java,
            "buchungen").build()

        GlobalScope.launch{
            db.buchungDao().insertAll(buchung)
            finish()
        }
    }
}