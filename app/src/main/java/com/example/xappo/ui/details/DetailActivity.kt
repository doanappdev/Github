package com.example.xappo.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.xappo.R
import com.example.xappo.XappoApp
import com.example.xappo.base.BaseItemView
import com.example.xappo.model.InfoItem
import com.example.xappo.ui.main.adapter.MainContract
import com.example.xappo.ui.MainPresenter
import com.example.xappo.ui.adapter.GithubAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View {

    @Inject lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        XappoApp.appComponent.inject(this)
        presenter.attach(this)
        presenter.subscribe()
    }

    override fun showProgressBar() {
       // call this to show progress bar
    }

    override fun hideProgressBar() {
        // call this to hide progress bar
    }

    override fun setAdapter(viewItems: List<BaseItemView>) {
        recyclerView.apply {
            adapter = GithubAdapter(viewItems)
        }
    }

    override fun navigateToDetails(item: InfoItem) {
        toast("Display details activity")
        //val intent = Intent(this, )
    }
}
