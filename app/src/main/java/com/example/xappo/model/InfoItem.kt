package com.example.xappo.model

import com.example.xappo.base.BaseItemView

const val ITEM_INFO = 0


data class InfoItem(val item: Item) : BaseItemView {
    override fun getItemType() = ITEM_INFO
}