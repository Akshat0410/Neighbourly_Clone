package com.example.neighbourly_clone.Model

data class RecyclerData(
    var mainimage: String = "",
    var image: String = "",
    var name: String = "",
    var timeago: String = "",
    var location: String = "",
    var titleorquestion: String = "",
    val titleorimage: Boolean = false,
//    val answer:List<Answer>,
    var answercount: String = ""
)
