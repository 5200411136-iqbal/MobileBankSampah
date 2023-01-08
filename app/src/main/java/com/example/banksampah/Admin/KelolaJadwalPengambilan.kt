package com.example.banksampah.Admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.banksampah.R
import com.example.banksampah.login.ApiConfig
import com.example.banksampah.model.dataJadwal
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_kelola_jadwal_pengambilan.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KelolaJadwalPengambilan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kelola_jadwal_pengambilan)

        btn_inputJP.setOnClickListener({
            InputJP()
        })

        btn_updateJP.setOnClickListener({
            UpdateJP()
        })

        btn_deleteJP.setOnClickListener({
            DeleteJP()
        })
    }

    private fun DeleteJP() {
        if(edt_idkeljadwal.text.isEmpty()){
            edt_idkeljadwal.error = "Kolom ID Harus diisi"
            edt_idkeljadwal.requestFocus()
            return
        }

        ApiConfig.instanceRetrofit.hapusJP(edt_idkeljadwal.text.toString())
            .enqueue(object : Callback<dataJadwal>{
                override fun onResponse(call: Call<dataJadwal>, response: Response<dataJadwal>) {
                    startActivity(Intent(this@KelolaJadwalPengambilan, ListJadwalPengambilan::class.java))
                    Toast.makeText(this@KelolaJadwalPengambilan, "Data berhasil dihapus", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<dataJadwal>, t: Throwable) {
                    Toast.makeText(this@KelolaJadwalPengambilan, "ERROR" + t.message, Toast.LENGTH_SHORT).show()
                }

            })

    }

    private fun InputJP() {
        if(edt_idkeljadwal.text.isEmpty()){
            edt_idkeljadwal.error = "Kolom ID pengurus Tidak boleh kosong"
            edt_idkeljadwal.requestFocus()
            return
        }
        if(edt_tanggaljadwal.text.isEmpty()){
            edt_tanggaljadwal.error = "Kolom tanggal Tidak boleh kosong"
            edt_tanggaljadwal.requestFocus()
            return
        }

        ApiConfig.instanceRetrofit.tambahJP(edt_tanggaljadwal.text.toString(),edt_idkeljadwal.text.toString())
            .enqueue(object : Callback<dataJadwal>{
                override fun onResponse(call: Call<dataJadwal>, response: Response<dataJadwal>) {
                    val respon = response.body()!!
                    var pesan = respon.Message.toString()
                    Toast.makeText(this@KelolaJadwalPengambilan, pesan, Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<dataJadwal>, t: Throwable) {
                    Toast.makeText(this@KelolaJadwalPengambilan, "ERROR" + t.message, Toast.LENGTH_SHORT).show()
                }
            })
    }

    private fun UpdateJP(){
        if(edt_idkeljadwal.text.isEmpty()){
            edt_idkeljadwal.error = "Kolom id Tidak boleh kosong"
            edt_idkeljadwal.requestFocus()
            return
        }
        if(edt_tanggaljadwal.text.isEmpty()){
            edt_tanggaljadwal.error = "Kolom tanggal Tidak boleh kosong"
            edt_tanggaljadwal.requestFocus()
            return
        }

        ApiConfig.instanceRetrofit.ubahJP(edt_idkeljadwal.text.toString(),edt_tanggaljadwal.text.toString())
            .enqueue(object : Callback<dataJadwal>{
                override fun onResponse(call: Call<dataJadwal>, response: Response<dataJadwal>) {
                    startActivity(Intent(this@KelolaJadwalPengambilan, ListJadwalPengambilan::class.java))
                    Toast.makeText(this@KelolaJadwalPengambilan, "Data berhasil Diganti", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<dataJadwal>, t: Throwable) {
                    Toast.makeText(this@KelolaJadwalPengambilan, "ERROR" + t.message, Toast.LENGTH_SHORT).show()
                }

            })
    }
}

