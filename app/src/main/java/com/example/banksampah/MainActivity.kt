package com.example.banksampah

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.banksampah.Admin.HomeAdmin
import com.example.banksampah.User.HomeUser
import com.example.banksampah.login.ApiConfig
import com.example.banksampah.model.ResponModel
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_login.setOnClickListener({
            UserLogin()
        })

    }

    fun UserLogin()
    {
        if (edt_nohp.text.isEmpty()){
            edt_nohp.error = "Kolom NoHp Tidak boleh Kosong"
            edt_nohp.requestFocus()
            return
        }
        if (edt_password.text.isEmpty()){
            edt_password.error = "Kolom Password Tidak boleh Kosong"
            edt_password.requestFocus()
            return
        }

        ApiConfig.instanceRetrofit.login(edt_nohp.text.toString(), edt_password.text.toString())
            .enqueue(object : Callback<ResponModel>
            {
                override fun onResponse(call: Call<ResponModel>, response: Response<ResponModel>)
                {
                    val respon = response.body()!!

                    if (respon.Success == 1 && respon.id_role == 1.toBigInteger()) {

                            val intent = Intent(this@MainActivity, HomeAdmin::class.java)
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                            startActivity(intent)
                            finish()
                            Toast.makeText(this@MainActivity, "Selamat Datang Di aplikasi Bank Sampah", Toast.LENGTH_SHORT).show()
                        }else if (respon.Success == 1 && respon.id_role == 2.toBigInteger()){
                            val intent = Intent(this@MainActivity, HomeUser::class.java)
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                            startActivity(intent)
                            finish()
                            Toast.makeText(this@MainActivity, "Selamat Datang Di aplikasi Bank Sampah", Toast.LENGTH_SHORT).show()
                    }else {
                        Toast.makeText(this@MainActivity, "ERROR" + respon.Message, Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<ResponModel>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "ERROR:" + t.message, Toast.LENGTH_LONG).show()
                }

            })
    }



}