package markodunovic.web.app.kotlintest.singleton

import android.content.Context
import android.util.Log
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

// companion replacement for  static
class Singleton private constructor(context: Context) {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CallInterface::class.java)

    private val dataRetro = retrofit.getData()

    companion object{
        private var instance:Singleton? = null
        fun getInstance(context: Context) = synchronized(this){
            if (instance == null){
                instance = Singleton(context)
            }
            instance
        }
    }

    fun getTestData(){
        dataRetro.enqueue(object : Callback<List<Int>?> {
            override fun onResponse(call: Call<List<Int>?>, response: Response<List<Int>?>) {
                if (response.body()!= null){
                    var lst:List<Int> = response.body()!!
                    for (a:Int in lst){
                        Log.d("SingletonResponse", "onResponse: $a")
                    }
                }
            }

            override fun onFailure(call: Call<List<Int>?>, t: Throwable) {
                Log.d("SingletonResponse", "Failed")

            }
        })
    }

    interface Result{
        fun onSuccess(o:Objects)
        fun onError(error:String)
    }
}