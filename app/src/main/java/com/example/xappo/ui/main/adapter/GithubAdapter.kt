package com.example.xappo.ui.main.adapter

import android.support.v4.app.FragmentManager
import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.xappo.base.BaseDelegateAdapter
import com.example.xappo.base.BaseItemView
import com.example.xappo.model.ITEM_INFO

class GithubAdapter(private val viewItems: List<BaseItemView>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var delegateAdapters = SparseArrayCompat<BaseDelegateAdapter>()

    init {
        // Note: this is an example of using the delegate pattern to display
        //       multiple item view types in recycler view
        delegateAdapters.put(ITEM_INFO, InfoDelegateAdapter())
//        delegateAdapters.put(ITEM_TITLE, TitleDelegateAdapter())
//        delegateAdapters.put(ITEM_SUPPORT, SupportRequestDelegateAdapter())
//        delegateAdapters.put(ITEM_SERVICE, EmergencyServiceDelegateAdapter())
//        delegateAdapters.put(ITEM_SUPPORT_GUIDE, SupportGuidesDelegateAdapter())
//        delegateAdapters.put(ITEM_ABOUT, AboutDelegateAdapter())
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            delegateAdapters.get(viewType)!!.onCreateViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegateAdapters.get(getItemViewType(position))?.onBindViewHolder(holder, viewItems[position])
    }

    override fun getItemViewType(position: Int) = viewItems[position].getItemType()
    override fun getItemCount(): Int = viewItems.count()
}