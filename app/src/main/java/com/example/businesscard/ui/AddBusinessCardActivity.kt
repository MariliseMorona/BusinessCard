package com.example.businesscard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.businesscard.App
import com.example.businesscard.R
import com.example.businesscard.data.BusinessCard
import com.example.businesscard.databinding.ActivityAddBusinessCardBinding

class AddBusinessCardActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater)}

    private val mainViewModel: MainViewModel by viewModels{
        MainViewModelFactory((application as App).repository)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListeners()
    }
    private fun insertListeners(){
        binding.btnConfirm.setOnClickListener {
            val businessCard = BusinessCard(
            name = binding.textInputName.editText?.text.toString(),
            company = binding.textInputCompany.editText?.text.toString(),
            telephone = binding.textInputPhone.editText?.text.toString(),
            email = binding.textInputEmail.editText?.text.toString(),
            backgroundPersonal = binding.textInputColor.editText?.text.toString()
            )

        mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.label_show_sucess, Toast.LENGTH_SHORT).show()
                finish()
        }

        binding.mgbClose.setOnClickListener {
            finish()
        }
    }
}
