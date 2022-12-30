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
import com.shaya.happid.ui.activity.OtpActivity

class OtpDialogFragment(val otp: String, val number:String) : DialogFragment() {
private lateinit var binding:FragmentOtpDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed(
            {
                val intent = Intent(requireContext(), OtpActivity()::class.java)
                intent.putExtra("trueOtp",otp)
                intent.putExtra("mob",number)
                startActivity(intent)
            }, 2000)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOtpDialogBinding.inflate(layoutInflater)
        return binding.root




        //return inflater.inflate(R.layout.fragment_otp_dialog, container, false)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.code1.text = otp.toCharArray()[0].toString()
        binding.code2.text = otp.toCharArray()[1].toString()
        binding.code3.text = otp.toCharArray()[2].toString()
        binding.code4.text = otp.toCharArray()[3].toString()



    }




}