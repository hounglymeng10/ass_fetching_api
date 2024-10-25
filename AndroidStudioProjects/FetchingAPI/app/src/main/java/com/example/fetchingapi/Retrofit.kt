package com.example.fetchingapi

import com.google.gson.GsonBuilder
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit

class Retrofit {

    companion object{
        val mainURL = "https://jsonplaceholder.typicode.com/"

        fun getRetrofit(): Retrofit{
            return Retrofit.Builder()
                .baseUrl(mainURL)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()
        }
    }
}