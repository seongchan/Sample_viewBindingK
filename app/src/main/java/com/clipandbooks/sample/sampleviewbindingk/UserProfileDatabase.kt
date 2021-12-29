package com.clipandbooks.sample.sampleviewbindingk

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserProfile::class], version = 1, exportSchema = false)
abstract class UserProfileDatabase : RoomDatabase() {
    abstract val userProfileDao: UserProfileDao

}