package com.example.banksampah.User

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.banksampah.Adapter.JadwalAdapter
import com.example.banksampah.R
import com.example.banksampah.model.dataJadwal
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_home_user.*
import kotlinx.android.synthetic.main.activity_jadwal_pengambilan_user.*
import kotlinx.android.synthetic.main.activity_list_jadwal_pengambilan.*
import kotlinx.android.synthetic.main.item_carry.*
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

class JadwalPengambilanUser : AppCompatActivity() {

    lateinit var jdwlAdapter: JadwalAdapter
    var lm = LinearLayoutManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jadwal_pengambilan_user)

        setupRecyeclerView()
        getDataAPI()
    }

    private fun getDataAPI() {
        val request = Request.Builder()
            .url("http://10.0.2.2:8000/api/listJP")
            .build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object : okhttp3.Callback{
            override fun onFailure(call: okhttp3.Call, e: IOException) {
                Log.e("Hasil", e.message.toString())
            }

            override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
                val body = response.body!!.string()
                var gson = GsonBuilder().create()
                var result = gson.fromJson(body,Array<dataJadwal>::class.java).toList()

                this@JadwalPengambilanUser?.runOnUiThread({
                    jdwlAdapter.setData(result!!)
                })
            }
        })
    }
    private fun setupRecyeclerView() {
        recyclerview.layoutManager = lm
        jdwlAdapter = JadwalAdapter(this!!)
        recyclerview.adapter = jdwlAdapter

        }
    }
