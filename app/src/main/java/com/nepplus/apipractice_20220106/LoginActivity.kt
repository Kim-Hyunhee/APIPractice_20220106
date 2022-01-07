package com.nepplus.apipractice_20220106

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.nepplus.apipractice_20220106.api.APIList
import com.nepplus.apipractice_20220106.api.ServerAPI
import com.nepplus.apipractice_20220106.models.BasicResponse
import com.nepplus.apipractice_20220106.utils.ContextUtil
import com.neppplus.apipractice_20220106.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener{

//            입력한 이메일 / 비번 변수에 저장
            val inputEmail = edtEmail.text.toString()
            val inputPw = edtPassword.text.toString()

//            서버 API의 로그인 기능에 활용 (ServerAPI 클래스 / APIList 인터페이스 결합)


//            실제 로그인 기능 호출 (Request) => 서버에 이거 해주세요 하고 날림
            apiList.postRequestLogin(inputEmail, inputPw).enqueue(object : Callback<BasicResponse>{
                override fun onResponse(
                    call: Call<BasicResponse>,
                    response: Response<BasicResponse>
                ) {
                    
//                    로그인 성공/실패 상관없이 응답 자체가 돌아온 경우
//                    서버가 정상 동작은 하지만 결과는 아직 모름
                    
//                    성공/실패 경우 나뉨
                    if (response.isSuccessful) {
//                        로그인 성공 => 아이디/비번 둘 다 맞은 상황
//                        Toast.makeText(this@MainActivity, "로그인 성공", Toast.LENGTH_SHORT).show()

//                        ~~님 환영합니다! 토스트 출력 => 로그인 한 사람의 닉네임 추출

                        val br = response.body()!!  // 서버의 응답 중에서 본문 : Body 를 자동 분석된 BasicResponse 형태로 저장

                        val loginUserNick = br.data.user.nick_name

                        Toast.makeText(this@LoginActivity, "${loginUserNick}님 환영합니다.", Toast.LENGTH_SHORT).show()

//                        로그인 성공 : 서버가 토큰을 발급해서 내려준다.
//                          => 본인이 누군지 알려줘야 하는 API들은 토큰값이 필요함 => 다른 (거의 모든)화면에도 전달해야함
//                          => 사용하는 기기의 보조 기억 장치에 기록해두고 -> 필요할 때 보조 기억 장치에서 꺼내다 사용

                        ContextUtil.setToken(mContext, br.data.token)  // 보조 기억 장치에 토큰값 저장

//                        메인화면으로 이동
                        val myIntent = Intent(mContext, MainActivity::class.java)
                        startActivity(myIntent)

                        finish()

                    }

                    else {
//                        로그인 실패 => 아이디나 비번이 틀림
                        Toast.makeText(this@LoginActivity, "로그인 실패", Toast.LENGTH_SHORT).show()
                    }
                    
                }

                override fun onFailure(call: Call<BasicResponse>, t: Throwable) {
                    
//                    서버 연결 자체를 실패한 경우
                    
                }

            }) 



        }


        btnSingUp.setOnClickListener{

//            단순 화면이동
            val myIntent = Intent(this,SignUpActivity::class.java)
            startActivity(myIntent)
        }
    }
}