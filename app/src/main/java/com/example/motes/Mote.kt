package com.example.motes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "motes_table")
class Mote (@ColumnInfo(name = "text")val text:String)
{
    @PrimaryKey(autoGenerate = true) var id=0
}
