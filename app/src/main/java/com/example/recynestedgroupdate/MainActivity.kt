package com.example.recynestedgroupdate

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val TAG : String = MainActivity::class.java.canonicalName!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val apiInterface : ApiInterface = ApiKlien.ambilKlien().create(ApiInterface::class.java)
        ambilJSON(apiInterface)

    }

    fun ambilJSON(apiInterface: ApiInterface) {

        val call : Call<List<ModelNya>> = apiInterface.getPerson()

        call.enqueue(object : Callback<List<ModelNya>> {

            @SuppressLint("WrongConstant")
            override fun onResponse(call: Call<List<ModelNya>>?, response: Response<List<ModelNya>>?) {
                Log.d("$TAG", "hasil ${response!!.body()}")

                val rv = findViewById<RecyclerView>(R.id.locationDatesList)
                rv.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayout.VERTICAL, false)

                // Access RecyclerView Adapter and load the data
                val adapter = AdapterKategori(response!!.body() as ArrayList<ModelNya>)
                rv.adapter = adapter

            }

            override fun onFailure(call: Call<List<ModelNya>>?, t: Throwable?) {
                Log.d("$TAG", "hasil " + t)
            }

        })
    }


}
