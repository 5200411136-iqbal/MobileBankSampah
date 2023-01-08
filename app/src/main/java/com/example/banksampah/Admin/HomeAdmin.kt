package com.example.banksampah.Admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.banksampah.R
import kotlinx.android.synthetic.main.activity_home_admin.*

class HomeAdmin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_admin)

        crd_transaksi.setOnClickListener({
            startActivity(Intent(this, KelolaTransaksi::class.java))
        })
        crd_listjadwalpengambilan.setOnClickListener({
            startActivity(Intent(this, ListJadwalPengambilan::class.java))
        })
        crd_jadwalpengambilan.setOnClickListener({
            startActivity(Intent(this, KelolaJadwalPengambilan::class.java))
        })
        crd_rwyttransaksi.setOnClickListener({
            startActivity(Intent(this, ListJadwalPengambilan::class.java))
        })
    }
}