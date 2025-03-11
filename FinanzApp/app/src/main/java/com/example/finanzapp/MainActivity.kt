package com.example.finanzapp

import android.content.Intent
import android.graphics.Color.blue
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var geloeschteBuchung : Buchung
    private lateinit var buchungen : List<Buchung>
    private lateinit var altebuchungen : List<Buchung>
    private lateinit var buchungadapter: BuchungAdapter
    private lateinit var linearlayoutManager: LinearLayoutManager
    private lateinit var db : AppDatenbank

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buchungen = arrayListOf()

        buchungadapter = BuchungAdapter(buchungen)
        linearlayoutManager = LinearLayoutManager(this)
    //Datenbank aufsätzen
        db = Room.databaseBuilder(this,
        AppDatenbank::class.java,
        "buchungen").build()

        recyclerview.apply{
            adapter = buchungadapter
            layoutManager = linearlayoutManager
        }

        //Löschen von Datensätzen mittels zur Seite wischen
        val itemTouchHelper = object : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT){
            override fun onMove(
              recyclerView: RecyclerView,
              viewHolder: RecyclerView.ViewHolder,
              target: RecyclerView.ViewHolder
            ): Boolean{
                return false
            }
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int){
                loescheBuchung(buchungen[viewHolder.adapterPosition])
            }
        }

        //Wisch Hilfe initialisierung
        val wischHilfe = ItemTouchHelper(itemTouchHelper)
        wischHilfe.attachToRecyclerView(recyclerview)

        neu_hnzfg.setOnClickListener{
            val intent = Intent(this, NeueBuchung::class.java)
            startActivity(intent)
        }
    }
    //Gelöschter Datensatz wird wieder angezeigt
    private fun fetchAll(){
        GlobalScope.launch{

            buchungen = db.buchungDao().getAll()

            runOnUiThread {
                updateUeberblick()
                buchungadapter.setData(buchungen)
            }
        }
    }
    // Aktualisierung Überblick
    private fun updateUeberblick(){
        val gesamteSumme = buchungen.map{it.summe}.sum()
        val einnahmenSumme = buchungen.filter{it.summe>0}.map{it.summe}.sum()
        val ausgabenSumme = gesamteSumme - einnahmenSumme

        einnahmen.text ="%.2f €".format(einnahmenSumme)
        ausgaben.text = "%.2f €".format(ausgabenSumme)
        gesamtsumme.text = "%.2f €".format(gesamteSumme)
    }

    //Der gelöschte Datensatz wird zurückgeholt
    private fun rueckgaengig(){
        GlobalScope.launch {
            db.buchungDao().insertAll(geloeschteBuchung)

            buchungen = altebuchungen

            runOnUiThread {
                buchungadapter.setData(buchungen)
                updateUeberblick()
            }
        }
    }

    //Snackbar zur Information des Nutzers und die Möglichkeit das löschen Rückgängig machen
    private fun showSnackbar(){
        val view = findViewById<View>(R.id.coordinator)
        val snackbar = Snackbar.make(view, "Buchung wurde gelöscht!",Snackbar.LENGTH_LONG)
        snackbar.setAction("Rückgängig"){
            rueckgaengig()
        }
            .setActionTextColor(ContextCompat.getColor(this, R.color.blue))
            .setTextColor(ContextCompat.getColor(this,R.color.white))
            .show()
    }
    //Löschen der Buchung und aktualiserung der Datenbank
    private fun loescheBuchung(buchung: Buchung){
        geloeschteBuchung = buchung
        altebuchungen = buchungen

        GlobalScope.launch {
            db.buchungDao().delete(buchung)

            buchungen = buchungen.filter{it.id != buchung.id}
            runOnUiThread {
                updateUeberblick()
                buchungadapter.setData(buchungen)
                showSnackbar()
            }
        }
    }
    // nach dem einpflegen neuer datensätze wird die Hauptaktivität forgeführt
    override fun onResume() {
        super.onResume()
        fetchAll()
    }
}