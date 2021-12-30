package com.clipandbooks.sample.sampleroom2

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Todo {
    @PrimaryKey(autoGenerate = true)
    var id = 0
    var title : String? = null
}