package com.shaya.happid.ui.dialog

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.shaya.happid.databinding.FragmentOtpDialogBinding
import com.shaya.happid.ui.activity.OtpVerifyActivity
import com.shaya.happid.utils.OTP_DISPLAY_DURATION
import com.shaya.happid.utils.Otp_keys
import com.shaya.happid.utils.setRoundedWidth

class OtpDialogFragment(private val otp: String, val mob: String) : DialogFragment() {
    private lateinit var binding: FragmentOtpDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOtpDialogBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog?.setRoundedWidth()
        showOTP()
        navigateToOTPVerify()
    }

    private fun showOTP() {
        binding.apply {
            val otpChars = otp.toCharArray()
            for (index in otpChars.indices) {
                when (index) {
                    0 -> code1.text = otpChars[index].toString()
                    1 -> code2.text = otpChars[index].toString()
                    2 -> code3.text = otpChars[index].toString()
                    3 -> code4.text = otpChars[index].toString()
                }
            }
        }
    }

    private fun navigateToOTPVerify() {
        Handler(Looper.getMainLooper()).postDelayed(
            {
                if (context == null){
                    return@postDelayed
                }
                val intent = Intent(context, OtpVerifyActivity::class.java)
                    .apply {
                        putExtra(Otp_keys.OTP_KEY, otp)
                        putExtra(Otp_keys.MOB_KEY, mob)
                    }
                startActivity(intent)
            }, OTP_DISPLAY_DURATION
        )
    }


}