package com.example.xappo.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class RepoResult(val items: List<Item>)

@Parcelize
data class Item(
        val id: Long?,
        val name: String?,
        val owner: Owner,
        val description: String?,
        @SerializedName("html_url") val htmlUrl: String?
) : Parcelable

@Parcelize
data class Owner(
        val login: String?,
        val id: Long?,
        @SerializedName("avatar_url") val avatarUrl: String?
) : Parcelable