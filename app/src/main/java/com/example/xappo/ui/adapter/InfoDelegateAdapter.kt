package com.example.xappo.ui.adapter

import android.support.v7.view.menu.MenuView
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.xappo.R
import com.example.xappo.base.BaseDelegateAdapter
import com.example.xappo.base.BaseItemView
import com.example.xappo.base.inflate
import com.example.xappo.model.InfoItem
import kotlinx.android.synthetic.main.item_info.view.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class InfoDelegateAdapter : BaseDelegateAdapter, AnkoLogger {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return InfoViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: BaseItemView) {
        holder as InfoViewHolder
        holder.bind(item as InfoItem)
    }

    inner class InfoViewHolder(parent: ViewGroup)
        : RecyclerView.ViewHolder(parent.inflate(R.layout.item_info)) {
        fun bind(info: InfoItem) = with(itemView) {

            title.text = info.item.name
            description.text = info.item.description


            //info { "Title delegate adapter clicked!!" }
            //item.clickSubject.onNext("track me")

           // title.text = item.title
//
//            Glide.with(context)
//                    .load(asset.smallestImage?.url)
//                    .placeholder(ContextCompat.getDrawable(context, R.mipmap.ic_launcher_round)) // temp placeholder in real app would use a different one
//                    .into(imageView)
//
//            this.clicks().subscribe { item.clickSubject.onNext(asset.url) }
        }
    }
}