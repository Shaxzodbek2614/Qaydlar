package com.example.qayta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.qayta.Models.User
import com.example.qayta.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private val binding by lazy { ActivityMain2Binding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val qayd = intent.getSerializableExtra("key") as User
        binding.date.text = qayd.date
        binding.title.text = qayd.title
        binding.matn.text = qayd.massege
        binding.close.setOnClickListener {
            finish()
        }
    }
}