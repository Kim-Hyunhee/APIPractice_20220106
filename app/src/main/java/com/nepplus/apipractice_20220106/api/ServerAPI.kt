package com.nepplus.apipractice_20220106.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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

//            retrofit 변수가 null이라면 => 새 객체를 만들어주자
//            null이 아니라면 => 이미 만들어 둔 것이 있다. => 있는 객체를 사용하게 하자
//            하나의 객체를 계속 재활용하게 유도 => 디자인 패턴: 싱글턴 패턴 적용

            if (retrofit == null)  {

//                실제 레트로핏 객체 생성
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)  //  어느 서버 안에서 움직일 것인지 알려주는 것
                    .addConverterFactory(GsonConverterFactory.create())  //  JSON -> 자동 분석 도구 설치
                    .build()

            }

//            retrofit이 null이라면 채워주고 아니라면 있는 객체 사용
            return retrofit!!  //  절대 null일리가 없다 => 리턴 (재활용)

        }


    }

}