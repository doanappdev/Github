package com.example.xappo.ui

import android.support.v7.view.menu.MenuView
import com.example.xappo.base.BaseItemView
import com.example.xappo.model.InfoItem
import com.example.xappo.repository.GithubRepository
import org.jetbrains.anko.error
import org.jetbrains.anko.info
import javax.inject.Inject

class MainPresenter @Inject constructor(val repository: GithubRepository) : MainContract.Presenter {
    override fun getRepoResults() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override lateinit var view: MainContract.View

    override fun attach(view: MainContract.View) {
        this.view = view
    }

    override fun subscribe() {
        repository.getGithubRepository().subscribe ({
            info { "$it" }
            val viewItems = mutableListOf<BaseItemView>()
            it?.let {result ->
                result.items.map {
                    viewItems.add(InfoItem(it))
                }
            }
            view.setAdapter(viewItems)
        }, {
            // todo: handle error correctly by displaying popup message
            error { "Error fetching data : ${it.message}" }
        })
    }
}