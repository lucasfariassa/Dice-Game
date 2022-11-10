package com.lucasfariassa.dicegame

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Item(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "move") val value: Int)
