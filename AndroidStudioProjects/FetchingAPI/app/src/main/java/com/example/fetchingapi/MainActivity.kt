package com.example.fetchingapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.example.fetchingapi.databinding.ActivityMainBinding
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val retrofitService = Retrofit.getRetrofit().create(AlbumService::class.java)

        val responseLiveData: LiveData<Response<Album>> =
            liveData {
            val response = retrofitService.getAlbums()
            emit(response)
        }

        responseLiveData.observe(this, Observer {
            val albumList = it.body()?.listIterator()
            if (albumList != null){
                val albumItem = albumList.next()

                val albumTitle = "Album Title: ${albumItem.title} \n"
                binding.titleTextView.append(albumTitle)
            }
        })

    }
}