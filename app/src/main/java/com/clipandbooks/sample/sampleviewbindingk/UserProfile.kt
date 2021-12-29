package com.clipandbooks.sample.sampleviewbindingk

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class UserProfile {
    @PrimaryKey(autoGenerate = true)
    var id = 0
    var name : String? = null
    var phone : String? = null
    var address : String? = null
}