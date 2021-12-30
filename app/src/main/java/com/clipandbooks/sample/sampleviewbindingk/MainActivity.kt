package com.clipandbooks.sample.sampleviewbindingk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.clipandbooks.sample.sampleviewbindingk.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var mBinding : ActivityMainBinding
    lateinit var userProfileViewModel:UserProfieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        userProfileViewModel = ViewModelProvider(this).get(UserProfieViewModel::class.java)
        userProfileViewModel.userProfileList.observe(this, { userProfiles -> updateUserProfileList(userProfiles) })
    }

    fun updateUserProfileList(userProfileList: List<UserProfile>) {
        var userListText = "사용자 목록\n"
        for (userProfile in userProfileList) {
            userListText += """
                
                ${userProfile.name}, ${userProfile.phone}, ${userProfile.address} 
            """.trimIndent()
        }

        mBinding.result.text = userListText
    }

    fun addUserProfile(view: View?) {
        val userProfile = UserProfile()
        userProfile.name = mBinding.name.text.toString()
        userProfile.phone = mBinding.phone.text.toString()
        userProfile.address = mBinding.address.text.toString()
        if (userProfile.name.isNullOrEmpty() || userProfile.phone.isNullOrEmpty() || userProfile.address.isNullOrEmpty()) {
            // Toast 출력
            //Toast.makeText(this, "누락된 값이 있습니다.", Toast.LENGTH_SHORT).show()
            // Snackbar 출력
            Snackbar.make(mBinding.mainLayout,"누락된 값이 있습니다.", Snackbar.LENGTH_SHORT ).show()
        } else {
            userProfileViewModel.insert(userProfile)
        }

    }
}