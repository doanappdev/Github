package com.example.xappo.model

import com.google.gson.annotations.SerializedName

data class RepoResult(val items: List<Item>)

data class Item(
        val id: Long?,
        val name: String?,
        val owner: Owner,
        val description: String?,
        @SerializedName("html_url") val htmlUrl: String?
)

data class Owner(
        val login: String?,
        val id: Long?,
        @SerializedName("avatar_url") val avatarUrl: String?)