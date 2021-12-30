package com.clipandbooks.sample.sampleroom1

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Todo {
    @PrimaryKey(autoGenerate = true)
    var id = 0
    var title : String? = null
}