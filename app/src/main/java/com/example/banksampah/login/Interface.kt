package com.example.banksampah.login

import com.example.banksampah.model.ResponModel
import com.example.banksampah.model.dataJadwal
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Interface {
    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("nohp") nohp: String,
        @Field("password") password: String
    ): Call<ResponModel>

    //JADWAL PENGAMBILAN
    @FormUrlEncoded
    @POST("insertJP")
    fun tambahJP(
        @Field("tanggal") tanggal: String,
        @Field("id_pengurus") id_pegurus: String
    ): Call<dataJadwal>

    @FormUrlEncoded
    @POST("updateJP")
    fun ubahJP(
        @Field("id") id: String,
        @Field("tanggal") tanggal: String,
    ): Call<dataJadwal>

    @FormUrlEncoded
    @POST("deleteJP")
    fun hapusJP(
        @Field("id") id: String,
    ): Call<dataJadwal>

}