package com.nepplus.apipractice_20220106

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nepplus.apipractice_20220106.models.BasicResponse
import com.nepplus.apipractice_20220106.utils.ContextUtil
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MyProfileActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile)

//        서버에 내 정보를 요청하자 => 기기에 저장된 토큰값 활용, 내가 누구인지? 서버에 알려주자

//        ContextUtil로 저장해둔 토큰을 가져오자

        apiList.getRequestMyInfo( ContextUtil.getToken(mContext) ).enqueue(object : retrofit2.Callback<BasicResponse>{
            override fun onResponse(call: Call<BasicResponse>, response: Response<BasicResponse>) {

            }

            override fun onFailure(call: Call<BasicResponse>, t: Throwable) {

            }

        })



    }
}