package com.example.fetchingapi

import android.icu.text.CaseMap.Title
import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("id")
    val id: Int,

    @SerializedName("userId")
    val userId: Int,

    @SerializedName("title")
    val title: String
)
