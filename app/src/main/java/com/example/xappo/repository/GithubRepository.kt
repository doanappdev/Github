package com.example.xappo.repository

import com.example.xappo.service.GithubService
import com.example.xappo.model.RepoResult
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

interface GithubRepository {
    fun getGithubRepository() : Observable<RepoResult>
}

class GithubRepositoryImpl(val service: GithubService) : GithubRepository {
    override fun getGithubRepository(): Observable<RepoResult> {
        return service.getSearchResults().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }
}