package com.clipandbooks.sample.sampleviewbindingk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.clipandbooks.sample.sampleviewbindingk.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var userProfileViewModel:UserProfieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
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

        binding!!.result.text = userListText
    }

    fun addUserProfile(view: View?) {
        val userProfile = UserProfile()
        userProfile.name = binding.name.text.toString()
        userProfile.phone = binding.phone.text.toString()
        userProfile.address = binding.address.text.toString()
        if (userProfile.name.isNullOrEmpty() || userProfile.phone.isNullOrEmpty() || userProfile.address.isNullOrEmpty()) {
            Toast.makeText(this, "누락된 값이 있습니다.", Toast.LENGTH_SHORT).show();
        } else {
            userProfileViewModel.insert(userProfile)
        }

    }
}