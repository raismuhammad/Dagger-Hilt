package com.raisproject.localdatacrud.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "data_table")
data class Data(
    @PrimaryKey
    val nik: Int,
    val nama: String,
    val umur: Int,
    val kota: String
)
