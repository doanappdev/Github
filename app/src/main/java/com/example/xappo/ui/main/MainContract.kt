package com.example.xappo.ui.main

import com.example.xappo.base.BaseContract
import com.example.xappo.base.BaseItemView
import com.example.xappo.model.InfoItem
import com.example.xappo.model.Item
import org.jetbrains.anko.AnkoLogger

interface MainContract {
    interface View : BaseContract.View, AnkoLogger {
        fun showProgressBar()
        fun hideProgressBar()
        fun setAdapter(viewItems: List<BaseItemView>)
    }


    interface Presenter : BaseContract.Presenter<View> {
        fun getRepoResults()
    }
}