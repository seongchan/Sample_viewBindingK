package com.clipandbooks.sample.sampleviewbindingk

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserProfileDao {
    @Insert
    fun insert(userProfile: UserProfile)

    @Update
    fun update(userProfile: UserProfile)

    @Delete
    fun delete(userProfile: UserProfile)

    @get:Query("Select * from userProfile")
    val all: LiveData<List<UserProfile>>

}