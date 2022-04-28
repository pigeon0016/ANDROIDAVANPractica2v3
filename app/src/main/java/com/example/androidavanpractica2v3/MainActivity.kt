package com.example.androidavanpractica2v3

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidavanpractica2v3.databinding.ActivityMainBinding
import com.example.androidavanpractica2v3.databinding.ListaRestBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), ResAdapter.OnItemListener {

    private lateinit var binding: ListaRestBinding
    private lateinit var adapter:ResAdapter
    private val datos = mutableListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setSupportActionBar(toolbar)
        //initRecyclerview()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://demo5556878.mockable.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api = retrofit.create(ApiServices::class.java)
        api.fetchAllRest().enqueue(object : Callback<List<DmRestaurantes>> {
            override fun onResponse(
                call: Call<List<DmRestaurantes>>,
                response: Response<List<DmRestaurantes>>
            ) {
                showData(response.body()!!)
            }

            override fun onFailure(call: Call<List<DmRestaurantes>>, t: Throwable) {

            }
        })
        //val datos = mutableListOf<DmRestaurantes>()

    }

    /*private fun initRecyclerview() {
        adapter = ResAdapter(datos)
        binding.rvRestaurantes.layoutManager=LinearLayoutManager(this)
        binding.rvRestaurantes.adapter=adapter
    }*/


    /*
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = ListaRestBinding.inflate(inflater,container,false)
        return binding.root
    }
    */


    private fun showData(variable: List<DmRestaurantes>) {
        binding.rvRestaurantes.apply{
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = ResAdapter(variable)
        }
    }

    override fun clickRestaurante(variable: DmRestaurantes) {
        val intent = Intent(activity,ResDetalle::class.java)
        intent.putExtra()
        startActivity(intent)
    }

}