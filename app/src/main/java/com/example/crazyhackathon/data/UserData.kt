package com.example.crazyhackathon.data

data class UserData(
    var name: String,
    var id: String,
    var pw: String,
    var gender: String,
    var age: Int
): java.io.Serializable
