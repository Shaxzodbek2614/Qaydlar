package com.example.qayta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.qayta.Models.User
import com.example.qayta.Utils.MySharedPrefernce
import com.example.qayta.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {
    private val binding by lazy { ActivityAddBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        MySharedPrefernce.init(this)
        var list = MySharedPrefernce.list
        binding.apply {
            btnSave.setOnClickListener {
                val user = User(title.text.toString(),matn.text.toString())
                list.add(user)
                MySharedPrefernce.list = list
                Toast.makeText(this@AddActivity, "Saqlandi", Toast.LENGTH_SHORT).show()
                finish()
            }
            close.setOnClickListener {
                finish()
            }
        }
    }
}