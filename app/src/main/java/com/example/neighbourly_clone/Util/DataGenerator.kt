package com.example.neighbourly_clone.Util

import com.example.neighbourly_clone.Model.RecyclerData

class DataGenerator {


    val name = arrayListOf("Anupam", "Rohan", "Somesh", "Sohan", "Adi", "Abhi")
    val location = arrayListOf("New Delhi", "Goa", "Ranchi", "Deoghar", "Kolkata")
    val url = arrayListOf("https://live.staticflickr.com/65535/51127885981_7e36d09c27_m.jpg",
            "https://live.staticflickr.com/65535/51128102703_db2e3ca9d4_m.jpg",
            "https://live.staticflickr.com/65535/51129001140_aec85f3973_m.jpg",
            "https://live.staticflickr.com/65535/51127926027_844b21ac5f_m.jpg",
            "https://live.staticflickr.com/65535/51127925012_c9eb9ff171_m.jpg")
    val title = arrayListOf("What's in your mind?", "How are you", "The answer is not upto mark", "Hello Everone to the world of Android Development")
    val time = arrayListOf("5 days ago", "4 days ago", "6 days ago", "9 days ago", "10 days ago")
    val answercount = arrayListOf("10 answers", "20 answers", "45 answers", "3 answers", "0 answers", "4 answers")

    fun GenerateData(): RecyclerData {

        return RecyclerData(

                mainimage = url.random(),
                image = url.random(),
                name = name.random(),
                timeago = time.random(),
                location = location.random(),
                titleorquestion = title.random(),
                answercount = answercount.random(),
                titleorimage = false
        )


    }



}