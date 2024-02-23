package com.example.qayta.Models

import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.Date

data class User(var title:String, var massege:String,var time:String = SimpleDateFormat("HH:mm").format(
    Date()
),var date:String = SimpleDateFormat("dd.MM.yyyy HH:mm").format(Date())):Serializable
