package com.example.finanzapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BuchungAdapter(private var buchungen: List<Buchung>) :
    RecyclerView.Adapter<BuchungAdapter.BuchungHolder>() {

    class BuchungHolder(view: View) : RecyclerView.ViewHolder(view){
        val bezeichnung : TextView = view.findViewById(R.id.bezeichnung)
        val datum : TextView = view.findViewById(R.id.datum)
        val summe : TextView = view.findViewById(R.id.summe)
        val art : TextView = view.findViewById(R.id.art)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuchungHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.buchung_layout, parent, false)
        return BuchungHolder(view)
    }

    override fun onBindViewHolder(holder: BuchungHolder, position: Int) {
        val buchung = buchungen[position]
        val context = holder.summe.context

        if(buchung.summe >= 0){
            holder.summe.text = "+ %.2f".format(buchung.summe)
            holder.summe.setTextColor((androidx.core.content.ContextCompat.getColor(context, R.color.green)))
            }else {
                holder.summe.text = "%.2f".format(buchung.summe)
                holder.summe.setTextColor((androidx.core.content.ContextCompat.getColor(context, R.color.red)))
            }
        holder.bezeichnung.text = buchung.bezeichnung
        holder.art.text = buchung.art
        holder.datum.text = buchung.datum
    }

    override fun getItemCount(): Int {
        return buchungen.size
    }

    fun setData(buchungen: List<Buchung>){
        this.buchungen = buchungen
        notifyDataSetChanged()
    }
}