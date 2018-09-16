package com.example.xappo.service

import com.example.xappo.model.RepoResult
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.GET

interface GithubService {
    @GET("search/repositories?q=android+language:kotlin&sort=stars&order=desc")
    fun getSearchResults() : Observable<RepoResult>
}