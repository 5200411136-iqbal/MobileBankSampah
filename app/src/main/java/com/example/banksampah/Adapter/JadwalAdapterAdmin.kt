package com.example.banksampah.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.banksampah.R
import com.example.banksampah.model.dataJadwal
import kotlinx.android.synthetic.main.item_list_jadwal.view.*
import org.w3c.dom.Text

class JadwalAdapterAdmin (val context: Context) : RecyclerView.Adapter<JadwalAdapterAdmin.ViewHolder>(){

    private val listjadwaladm:MutableList<dataJadwal> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =  ViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.item_list_jadwal, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindModel(listjadwaladm[position])

    }

    override fun getItemCount() = listjadwaladm.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var tanggaladm: TextView = view.itm_tgltransadm
        var rolenameadm: TextView = view.itm_rlnameadm

        fun bindModel(b : dataJadwal){
            tanggaladm.text = b.tanggal
            rolenameadm.text = b.role_name
        }
    }
    fun setDataadm(data: List<dataJadwal>){
        listjadwaladm.clear()
        listjadwaladm.addAll(data)
        notifyDataSetChanged()
    }
}