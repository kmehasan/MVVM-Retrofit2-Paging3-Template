package io.github.kmehasan.mvvmretrofit2paging3template.repository

import ApiService
import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import java.io.IOException
import io.github.kmehasan.mvvmretrofit2paging3template.response.charecter_model.Result

class CharacterListDataSource(private val apiService: ApiService) :
    PagingSource<Int, Result>()
{

    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {

        return try {

            val nextPage=params.key?: FIRST_PAGE_INDEX

            val response=apiService.getCharacterList(nextPage)

            var nextPageNumber:Int?= null

            if (response != null){
                nextPageNumber=if(response.info.next != null) response.info.next.replace("https://rickandmortyapi.com/api/character?page=","").toInt() else null
            }
            Log.d("TAG", "load: $nextPageNumber")
            LoadResult.Page(data = response.results,
                prevKey = null,
                nextKey = nextPageNumber)
        }
        catch (e:Exception){
            Log.e("TAG1", "load: Exception :"+e )
            e.printStackTrace()
            LoadResult.Error(e)

        }
        catch (e:IOException){
            Log.e("TAG1", "load: IO Exception :"+e )
            LoadResult.Error(e)

        }

    }

    companion object{
        private const val FIRST_PAGE_INDEX=1
    }
}