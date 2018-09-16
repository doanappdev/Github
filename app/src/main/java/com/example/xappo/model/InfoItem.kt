package com.example.xappo.model

import com.example.xappo.base.BaseItemView
import io.reactivex.subjects.PublishSubject

const val ITEM_INFO = 0


data class InfoItem(val item: Item) : BaseItemView {
    val clickSubject: PublishSubject<Item> = PublishSubject.create()
    override fun getItemType() = ITEM_INFO
}