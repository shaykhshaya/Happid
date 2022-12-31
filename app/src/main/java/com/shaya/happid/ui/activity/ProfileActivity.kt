package com.shaya.happid.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.shaya.happid.databinding.ActivityProfileBinding
import com.shaya.happid.model.ProfileModel
import com.shaya.happid.ui.viewmodel.ProfileViewModel

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    private var viewModel : ProfileViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[ProfileViewModel::class.java]
        observeCreateProfile()

        binding.imgBack.setOnClickListener { onBackPressed() }
        binding.submitBtn.setOnClickListener {
            val formData = getFormData()
            viewModel?.createProfile(formData)
        }
    }

    private fun observeCreateProfile(){
        viewModel?.createProfileLiveData?.observe(this){
            if (it?.body()!= null){
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getFormData(): ProfileModel {
        val postalCode = binding.editPostCode.editText?.text?.trim().toString()
        val location = if (postalCode.isEmpty()) "New Delhi" else ""
        return ProfileModel(
            imgUrl = "",
            firstName = binding.firstNameLayout.editText?.text?.trim().toString(),
            lastName = binding.lastNameLayout.editText?.text?.trim().toString(),
            phone = binding.phoneTextLayout.editText?.text?.trim().toString(),
            location = location,
            postCode = postalCode
        )
    }
}