package markodunovic.web.app.kotlintest.singleton

import retrofit2.Call
import retrofit2.http.GET

interface CallInterface {

    @GET("/v2/gliders")
    fun getData(): Call<List<Int>>

}