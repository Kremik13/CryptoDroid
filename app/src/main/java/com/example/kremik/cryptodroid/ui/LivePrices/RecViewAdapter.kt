package com.example.kremik.cryptodroid.ui.LivePrices

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kremik.cryptodroid.R
import com.example.kremik.cryptodroid.data.model.CryptoCurrency
import kotlinx.android.synthetic.main.item_currency.view.*
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.textColor
import javax.inject.Inject

open class RecViewAdapter @Inject constructor(var context: Context): RecyclerView
.Adapter<RecViewAdapter.ViewHolder>(),
        RecViewAdapterContract {
    override lateinit var currencyList: List<CryptoCurrency>


    override fun setCurrencies(list: List<CryptoCurrency>) {
        currencyList = list
        this.notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            var view = LayoutInflater.from(parent.context).inflate(R.layout.item_currency,
                    parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currencyList[position])
    }

    override fun getItemCount(): Int {
        return currencyList.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(currency: CryptoCurrency) {
            itemView.symbolTV.text = currency.symbol
            itemView.changeTV.text = currency.percentChange24h
            itemView.changeTV.textColor = if (currency.percentChange24h!!.toDouble() >= 0.0)
                ContextCompat.getColor(context, R.color.positive_green)
                else  ContextCompat.getColor(context,R.color.negative_red)
        }
    }


}