package com.example.crazyhackathon.data

data class PostData(
    var title: String,
    var name: String,
    var location: String,
    var heart: Int,
    var time: Int
): java.io.Serializable
