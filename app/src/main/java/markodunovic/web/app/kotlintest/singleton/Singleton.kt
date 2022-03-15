package markodunovic.web.app.kotlintest.singleton

import android.content.Context
import android.util.Log
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

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

    fun getTestData(result:Result){
        dataRetro.enqueue(object : Callback<List<Int>?> {
            override fun onResponse(call: Call<List<Int>?>, response: Response<List<Int>?>) {
                val resp = response.body()
                if (resp != null){
                    var lst:List<Int> = resp
                    for (a:Int in lst){
                        Log.d("SingletonResponse", "onResponse: $a")
                    }
                    result.onSuccess(lst)
                }
            }

            override fun onFailure(call: Call<List<Int>?>, t: Throwable) {
                Log.d("SingletonResponse", "Failed")
                //result.onError("I dun goffed")
            }
        })
    }

    interface Result{
        fun onSuccess(o: List<Int>)
        fun onError(error:String)
    }
}