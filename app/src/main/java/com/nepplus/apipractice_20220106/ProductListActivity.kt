package com.nepplus.apipractice_20220106

import android.net.DnsResolver
import android.os.Bundle
import com.nepplus.apipractice_20220106.models.BasicResponse
import com.nepplus.apipractice_20220106.models.ProductData
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class ProductListActivity : BaseActivity() {

    val mPoductList = ArrayList<ProductData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        apiList.getRequestAllProduct().enqueue(object : Callback<BasicResponse>,
            retrofit2.Callback<BasicResponse> {
            override fun onResponse(call: Call<BasicResponse>, response: Response<BasicResponse>) {

                if (response.isSuccessful) {

                    val br = response.body()!!

                    mPoductList.addAll( br.data.poducts )

                }

            }

            override fun onFailure(call: Call<BasicResponse>, t: Throwable) {

            }


        }
}