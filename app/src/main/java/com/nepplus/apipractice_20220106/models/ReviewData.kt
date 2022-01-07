package com.nepplus.apipractice_20220106.models

import java.io.Serializable

class ReviewData(
    val id : Int,
    val title : String,
    val content : String,
    val score : Float,  // 파이썬에서는 float개념과 동일
    val thumbnail_img : String,
    val user : UserData  // 기존에 만든 UserData 재활용
) :Serializable {
}