package com.example.banksampah.Adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.banksampah.R
import com.example.banksampah.model.dataJadwal
import kotlinx.android.synthetic.main.activity_jadwal_pengambilan_user.view.*
import kotlinx.android.synthetic.main.item_carry.view.*

class JadwalAdapter(val context: Context) : RecyclerView.Adapter<JadwalAdapter.ViewHolder>() {

    private val datalistjadwal:MutableList<dataJadwal> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.item_carry, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindModel(datalistjadwal[position])
    }

    override fun getItemCount() = datalistjadwal.size

    class ViewHolder (view: View): RecyclerView.ViewHolder(view){

        var tanggal: TextView = view.itm_tanggaltransaksi

        fun bindModel(b : dataJadwal){
            tanggal.text = b.tanggal
        }

    }
    fun setData(data: List<dataJadwal>){
        datalistjadwal.clear()
        datalistjadwal.addAll(data)
        notifyDataSetChanged()

    }

}