package com.example.xappo.ui.main.adapter

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.xappo.R
import com.example.xappo.base.BaseDelegateAdapter
import com.example.xappo.base.BaseItemView
import com.example.xappo.base.inflate
import com.example.xappo.base.loadAvatar
import com.example.xappo.model.InfoItem
import com.example.xappo.ui.details.DetailActivity
import com.example.xappo.ui.details.KEY_ITEM
import com.jakewharton.rxbinding2.view.clicks
import kotlinx.android.synthetic.main.item_info.view.*
import org.jetbrains.anko.AnkoLogger

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
            info.item.owner.avatarUrl?.let { icon.loadAvatar(it) }
            constraintLayout.clicks().subscribe {
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra(KEY_ITEM, info.item)
                context.startActivity(intent)
            }
        }
    }
}