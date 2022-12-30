package com.shaya.happid.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.shaya.happid.ui.dialog.OtpDialogFragment
import com.shaya.happid.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    lateinit var mobNum: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.imgBack.setOnClickListener { onBackPressed() }


        binding.requestOtp.setOnClickListener {


            mobNum = binding.inputNumber.text.toString()




            OtpDialogFragment(genOTP(mobNum), mobNum).show(
                supportFragmentManager,
                OtpDialogFragment::class.java.name
            )


        }
    }

    private fun genOTP(mobNum: String): String {
        //  val num = mobNum.toList()
        val num = mobNum.substring(0, 2) + mobNum.substring(8, 10)
        // val otp = (listOf(num[0],num[1],num[8],num[9])).toString()
        return num
    }


}

