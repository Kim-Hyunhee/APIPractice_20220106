package com.neppplus.phoneorderapp_20220105.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nepplus.apipractice_20220106.R
import com.nepplus.apipractice_20220106.models.ProductData
import com.nepplus.apipractice_20220106.models.ReviewData
import com.nepplus.apipractice_20220106.models.StoreData


class ProductAdapter(
    val mContext: Context,
    val mList: List<ProductData>,
) : RecyclerView.Adapter<ProductAdapter.MyViewHolder>() {

    inner class MyViewHolder(val row: View) : RecyclerView.ViewHolder(row) {


        fun bind(data: ProductData) {


            }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val row = LayoutInflater.from(mContext).inflate(R.layout.product_list_item, parent, false)
        return MyViewHolder(row)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.bind( mList[position] )

    }

    override fun getItemCount(): Int {
        return mList.size
    }

}