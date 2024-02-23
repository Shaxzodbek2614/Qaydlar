package com.example.qayta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.qayta.Models.User
import com.example.qayta.Utils.MySharedPrefernce
import com.example.qayta.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    private val binding by lazy { ActivityEditBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val position = intent.getIntExtra("raqam",-1)
        binding.apply {
            var list = MySharedPrefernce.list
            val model = list[position]
            title.setText(model.title)
            matn.setText(model.massege)
            btnSave.setOnClickListener {
                val user = User(title.text
                    .toString(),matn.text.toString())
                list[position] = user
                MySharedPrefernce.list = list
                finish()
            }

            close.setOnClickListener {
                finish()
            }
        }
    }
}