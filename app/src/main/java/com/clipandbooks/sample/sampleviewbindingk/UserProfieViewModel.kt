package com.clipandbooks.sample.sampleviewbindingk

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.Room

class UserProfieViewModel(application: Application) : AndroidViewModel(application) {

    var userProfileList:LiveData<List<UserProfile>>
    var userProfileDao:UserProfileDao

    init {
        val db  = Room.databaseBuilder(application, UserProfileDatabase::class.java,"userProfile").allowMainThreadQueries().build()
        userProfileDao = db.userProfileDao
        userProfileList = userProfileDao.all
    }


    fun insert(userProfile:UserProfile) {
        userProfileDao.insert(userProfile)
    }
}