package io.github.kmehasan.mvvmretrofit2paging3template.view_model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import io.github.kmehasan.mvvmretrofit2paging3template.network.RetrofitBuilder
import io.github.kmehasan.mvvmretrofit2paging3template.repository.CharacterListDataSource
import io.github.kmehasan.mvvmretrofit2paging3template.repository.Repository
import io.github.kmehasan.mvvmretrofit2paging3template.response.charecter_model.Result
import io.github.kmehasan.mvvmretrofit2paging3template.response.charecter_model.CharecterResponse
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow

class MainScreenViewModel : ViewModel() {
    var repository = Repository()

    //for coroutine Exception
    val errorMessage = MutableLiveData<String>()
    val isLoading = MutableLiveData(false)
    var job: Job? = null
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Poor Connection")
        Log.e("TAG", "Error : ${throwable.localizedMessage}")
    }
    private fun onError(message: String) {
        errorMessage.postValue(message)
        Log.e("TAG", "onError: $message")
    }

//    fun getCharacterList(): MutableLiveData<CharecterResponse> {
//        isLoading.postValue(true)
//        val characterResponse: MutableLiveData<CharecterResponse> = MutableLiveData()
//        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
//            val response = repository.getCharacterList()
//            withContext(Dispatchers.Main) {
//                isLoading.postValue(false)
//                if (response.isSuccessful) {
//                    characterResponse.postValue(response.body())
//                } else {
//                    onError("Error :: get Product :: ${response.message()}")
//                }
//            }
//        }
//        return characterResponse
//    }

    fun getALLCharacterList(): Flow<PagingData<Result>> {
        return Pager(config = PagingConfig(
            enablePlaceholders = true, pageSize = Repository.NETWORK_PAGE_SIZE, maxSize = 826
        ), pagingSourceFactory = {
            CharacterListDataSource(RetrofitBuilder.API_SERVICE)
        }).flow.cachedIn(viewModelScope)
    }
}