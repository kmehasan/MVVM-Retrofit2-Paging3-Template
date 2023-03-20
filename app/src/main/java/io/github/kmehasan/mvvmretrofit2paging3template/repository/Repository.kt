package io.github.kmehasan.mvvmretrofit2paging3template.repository

import io.github.kmehasan.mvvmretrofit2paging3template.network.RetrofitBuilder

class Repository {
    var api = RetrofitBuilder.API_SERVICE

    suspend fun getCharacterList() = api.getCharacterList(1)

    companion object {
        val NETWORK_PAGE_SIZE: Int = 20
    }
}