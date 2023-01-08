package com.example.banksampah.User

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.banksampah.Admin.KelolaTransaksi
import com.example.banksampah.R
import kotlinx.android.synthetic.main.activity_home_user.*

class HomeUser : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_user)

        crd_jdwluser.setOnClickListener({
            startActivity(Intent(this, JadwalPengambilanUser::class.java))
        })
    }
}