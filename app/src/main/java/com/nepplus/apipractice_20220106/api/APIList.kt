package com.nepplus.apipractice_20220106.api

import com.nepplus.apipractice_20220106.models.BasicResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.*

interface APIList {

//    api.gudoc.in 서버의 기능들을 접근하는 방법 (함수) 을 명시하는 파일

//    로그인 기능

    @FormUrlEncoded  // @Field에 데이터를 담으려면 추가로 부착해야함
    @POST("/user")
    fun postRequestLogin(
        @Field("email") email : String,
        @Field("password") pw : String,
    ) : Call<BasicResponse>  //  ( BasicResponse 형태의 응답을 받는 ) API 호출 기능을 만들어냄

//    회원가입 기능

    @FormUrlEncoded
    @PUT("/user")
    fun putRequestSignUp(
        @Field("email") email : String,
        @Field("password") pw : String,
        @Field("nick_name") nick : String,
        @Field("phone") phone : String
    ) : Call<BasicResponse>  // 회원가입도 로그인처럼 code/message/data 세 가지만 제일 바깥 {  }에 담겨 있다.

//   중복검사

    @GET("/user/check")
    fun getRequestDupleCheck(
        @Query("type") type : String,
        @Query("value") value : String
    ) : Call<BasicResponse>

    @GET("/review")
    fun getRequestAllReview() : Call<BasicResponse>


//    내 정보 가져오기 -> 토큰값 첨부
    @GET("/user")
    fun getRequestMyInfo() : Call<BasicResponse>


    @GET("/product")
    fun getRequestAllProduct(): Call<BasicResponse>
//    리뷰 등록하기

    @FormUrlEncoded
    @POST("/review")
    fun postRequestSubmitReview(
        @Field("product_id") productid : Int,
        @Field("title") title: String,
        @Field("content") content :String,
        @Field("score") score : Float,
        @Field("tag_list") tagStr : String  // 임시로 ""을 넣어줄 예정

    ) : Call<BasicResponse>

//    특정 리뷰 상세보기
    @GET("/review/{review_id}")  // {review_id}는 몇 번 리뷰를 보고 싶은지 숫자를 적어줄 공간으로 세팅
    fun getRequestReviewDetail(
        @Path("review_id") id: Int
    ) : Call<BasicResponse>

}