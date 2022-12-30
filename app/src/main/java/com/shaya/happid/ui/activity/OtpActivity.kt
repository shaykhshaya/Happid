 package com.shaya.happid.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.shaya.happid.databinding.ActivityOtpBinding

 class OtpActivity() : AppCompatActivity() {

    private lateinit var binding: ActivityOtpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOtpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        intent.getStringExtra("trueOtp")
        val otp = intent?.extras?.getString("trueOtp").toString()
        val mobileNumber = intent?.extras?.getString("mob").toString()

        binding.number.text = mobileNumber



        binding.submitOtp.setOnClickListener {

            val otpEntered = binding.inputCode.text.toString()

            if(otpEntered != otp){
                binding.inputCode.setError("Please Enter Correct OTP")
            }
            else{

                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
            }


        }








    }
}