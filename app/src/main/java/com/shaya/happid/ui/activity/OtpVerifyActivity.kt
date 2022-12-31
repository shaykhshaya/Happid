package com.shaya.happid.ui.activity


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.shaya.happid.databinding.ActivityOtpVerifyBinding
import com.shaya.happid.utils.*

class OtpVerifyActivity : AppCompatActivity(){

    private lateinit var binding: ActivityOtpVerifyBinding
    private var validOTP: String? = null
    private var mobileNumber: String? = null
    private var enteredOTP: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOtpVerifyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        jumpCursor()
        clearCursor()

        intent?.let {
            validOTP = it.getStringExtra(Otp_keys.OTP_KEY)
            mobileNumber = it.getStringExtra(Otp_keys.MOB_KEY)
        }

        binding.imgBack.setOnClickListener { onBackPressed() }
        binding.number.text = appendCountryCode(mobileNumber)
        binding.submitOtp.toggleState(false)

        binding.submitOtp.setOnClickListener {
            if (isValidOTP(enteredOTP = enteredOTP, correctOTP = validOTP)) {
                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Invalid OTP", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun jumpCursor(){
        binding.otpView.editText1.addTextChangedListener {
            if (it.toString().length == 1){
                binding.otpView.editText2.requestFocus()
                setEnteredOTP()
            }
        }

        binding.otpView.editText2.addTextChangedListener {
            if (it.toString().length == 1){
                binding.otpView.editText3.requestFocus()
                setEnteredOTP()
            }
        }

        binding.otpView.editText3.addTextChangedListener {
            if (it.toString().length == 1){
                binding.otpView.editText4.requestFocus()
                setEnteredOTP()
            }
        }

        binding.otpView.editText4.addTextChangedListener {
            if (it.toString().length == 1){
                setEnteredOTP()
            }
        }

    }

    private fun clearCursor() {
        binding.otpView.editText4.setOnKeyListener { view, keyCode, keyEvent ->
           if (keyEvent.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_DEL){
               binding.otpView.editText4.text = null
               binding.otpView.editText3.requestFocus()
               setEnteredOTP()
               return@setOnKeyListener true
           }
            return@setOnKeyListener false
        }

        binding.otpView.editText3.setOnKeyListener { view, keyCode, keyEvent ->
            if (keyEvent.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_DEL){
                binding.otpView.editText3.text = null
                binding.otpView.editText2.requestFocus()
                setEnteredOTP()
                return@setOnKeyListener true
            }
            return@setOnKeyListener false
        }

        binding.otpView.editText2.setOnKeyListener { view, keyCode, keyEvent ->
            if (keyEvent.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_DEL){
                binding.otpView.editText2.text = null
                binding.otpView.editText1.requestFocus()
                setEnteredOTP()
                return@setOnKeyListener true
            }
            return@setOnKeyListener false
        }

        binding.otpView.editText1.setOnKeyListener { view, keyCode, keyEvent ->
            if (keyEvent.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_DEL){
                binding.otpView.editText1.text = null
                setEnteredOTP()
                return@setOnKeyListener true
            }
            return@setOnKeyListener false
        }

    }

    private fun setEnteredOTP() {
        enteredOTP = binding.otpView.editText1.text.toString() +
                binding.otpView.editText2.text.toString() +
                binding.otpView.editText3.text.toString() +
                binding.otpView.editText4.text.toString()
        binding.submitOtp.toggleState(enteredOTP?.length == 4)
    }

}