package com.shaya.happid.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.shaya.happid.ui.dialog.OtpDialogFragment
import com.shaya.happid.databinding.ActivityLoginBinding
import com.shaya.happid.utils.PHONE_NUMBER_DIGIT
import com.shaya.happid.utils.generateOTPFromMobileNumber
import com.shaya.happid.utils.toggleState

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        binding.btnRequestOtp.toggleState(false)
        binding.imgBack.setOnClickListener { onBackPressed() }

        binding.inputNumber.addTextChangedListener {
            val isValid = it.toString().trim().length == PHONE_NUMBER_DIGIT
            binding.btnRequestOtp.toggleState(isValid)
        }

        binding.btnRequestOtp.setOnClickListener {
            val mob = binding.inputNumber.text.toString()
            val generatedOTP = generateOTPFromMobileNumber(mob)
            OtpDialogFragment(generatedOTP, mob).show(
                supportFragmentManager,
                OtpDialogFragment::class.java.name
            )
        }
    }


}

