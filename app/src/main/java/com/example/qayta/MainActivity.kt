package com.example.qayta

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import com.example.qayta.Models.User
import com.example.qayta.Utils.MySharedPrefernce
import com.example.qayta.adapters.UserAdapter
import com.example.qayta.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var userAdapter:UserAdapter
private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.btnAdd.setOnClickListener {
            startActivity(Intent(this,AddActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        MySharedPrefernce.init(this)
        val list = MySharedPrefernce.list

        userAdapter = UserAdapter(object :UserAdapter.RvAction{
            override fun itemClic(user: User) {
                val intent = Intent(this@MainActivity,MainActivity2::class.java)
                intent.putExtra("key",user)
                startActivity(intent)
            }

            override fun clicMenu(view: View,position:Int) {
                val popupMenu = PopupMenu(this@MainActivity,view)
                popupMenu.inflate(R.menu.my_menu)
                popupMenu.setOnMenuItemClickListener {
                    when(it.itemId){
                        R.id.menu_edit->{
                            val intent = Intent(this@MainActivity,EditActivity::class.java)
                            intent.putExtra("raqam",position)
                            startActivity(intent)
                        }
                        R.id.menu_delete->{
                            list.removeAt(position)
                            MySharedPrefernce.list = list
                            onResume()
                            userAdapter.notifyItemRemoved(position)
                            val mediaPlayer = MediaPlayer.create(this@MainActivity,R.raw.music)
                            mediaPlayer.start()
                        }
                    }
                    true
                }
                popupMenu.show()
            }
        },list)
        binding.rv.adapter = userAdapter
    }
}