package com.npe.galaxyorganic.ui.fragment.shop.DetailMenu

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.npe.galaxyorganic.R
import com.npe.galaxyorganic.ui.model.datum.DatumShopDetailMenuModel
import kotlinx.android.synthetic.main.list_detail_menu_shop.view.*

class AdapterDetailMenuShop(
    val context: Context,
    val items: List<DatumShopDetailMenuModel>
) : RecyclerView.Adapter<AdapterDetailMenuShop.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.list_detail_menu_shop, p0, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val list = items.get(p1)

            Glide.with(context)
                .load(list.image)
                .into(p0.imageBarang)

            p0.namaBarang?.text = list.name
            p0.hargaBarang?.text = list.sell_price

    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageBarang = view.imgv_detailMenu_shop
        val namaBarang = view.tv_namaBarangDetailMenu_shop
        val hargaBarang = view.tv_hargaBarangDetailMenu_shop
    }
}