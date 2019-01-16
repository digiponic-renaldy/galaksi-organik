package com.npe.galaxyorganic.ui.fragment.shop

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.npe.galaxyorganic.R
import com.npe.galaxyorganic.ui.model.ShopMenuModel
import kotlinx.android.synthetic.main.list_menu_shop.view.*

class AdapterShopFragment(val context : Context, val items : List<ShopMenuModel>) : RecyclerView.Adapter<AdapterShopFragment.ViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.list_menu_shop, p0, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val list = items.get(p1)

        Glide.with(context)
            .load(list.imageMenu)
            .into(p0.imageMenu)

        p0.judulMenu.text = list.judulMenu
    }

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val imageMenu = view.imgv_listMenu_shop
        val judulMenu = view.tv_listMenu_shop
    }
}