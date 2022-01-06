package com.nepplus.apipractice_20220106.api

import retrofit2.Retrofit

class ServerAPI {

//    서버 통신을 하게 도와주는 클래스 (Retrofit)를 객체로 만들어주는 기능

//    함수 한 번만 호출 하면 => 편하게 가져다 쓸 수 있게 함수로 만들어두자

//    클래스 이름.기능() => @classmethod 에 대응되는 기능 활용

    companion object{

//    이 { } 안에 적는 변수 / 함수들은 => ServerAPI.변수/함수로 활용 가능

        private val BASE_URL = "https://api.gudoc.in"   // 기본 보안 처리는 되어있는 서버 http"s" => 이 클래스 내부에서만 사용예정
        private var retrofit : Retrofit? = null  // 서버 연결 전담 변수 => 기본적으로는 아직 만들지 않은 상태(null)

//        retrofit 변수에 환경 설정 + 객체화 => 가져다 쓸 수 있게 하는 기능 (함수)

        fun getRetrofit() : Retrofit {

        }


    }

}