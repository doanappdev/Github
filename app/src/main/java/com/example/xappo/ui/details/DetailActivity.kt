package com.example.xappo.ui.details

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.xappo.R
import com.example.xappo.base.loadAvatar
import com.example.xappo.model.Item
import kotlinx.android.synthetic.main.activity_detail.*

const val KEY_ITEM = "key_item"

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        intent?.extras?.getParcelable<Item>(KEY_ITEM)?.let {item ->
            item.owner.avatarUrl?.let { url -> avatar.loadAvatar(url) }
            item.owner.login?.let { ownerLogin -> login.text = ownerLogin }
            item.description?.let { desc -> description.text = desc }
        }
    }
}
