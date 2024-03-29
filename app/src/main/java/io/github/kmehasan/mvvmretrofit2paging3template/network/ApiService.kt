import io.github.kmehasan.mvvmretrofit2paging3template.response.charecter_model.CharecterResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("character")
    suspend fun getCharacterList(@Query("page") page:Int):CharecterResponse
}