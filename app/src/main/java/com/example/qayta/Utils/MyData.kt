package com.example.qayta.Utils

import android.content.Context
import android.content.SharedPreferences
import com.example.qayta.Models.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object MySharedPrefernce{
    private const val NAME = "catch_file_name"
    private const val MODE = Context.MODE_PRIVATE

    private lateinit var preferences: SharedPreferences

    fun init(context: Context){
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation:(SharedPreferences.Editor)->Unit){
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var list:ArrayList<User>
        get() = gsonStringToList(preferences.getString("my_list","[]")!!)
        set(value) = preferences.edit {
            it.putString("my_list", listToGsonString(value))
        }

    private fun gsonStringToList(gsonstring:String):ArrayList<User>{
        val list = ArrayList<User>()
        val type = object : TypeToken<ArrayList<User>>(){}.type
        list.addAll(Gson().fromJson(gsonstring,type))
        return list
    }

    private fun listToGsonString(list: ArrayList<User>):String{
        return Gson().toJson(list)
    }
}