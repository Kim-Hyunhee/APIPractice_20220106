package com.nepplus.apipractice_20220106.models

class DataResponse(
    val user : UserData,
    val token : String,
    val reviews : List<ReviewData>,
    val poducts : List<ProductData>,
    val review : ReviewData
) {
}