package com.wonmirzo.securekey

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wonmirzo.securekey.adapter.PostAdapter
import com.wonmirzo.securekey.model.Post
import com.wonmirzo.securekey.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    lateinit var viewModel: MainViewModel

    init {
        System.loadLibrary("keys")
    }

    external fun getPublicKey(): String?
    external fun getPrivateKey(): String?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 1)

        viewModel.apiPostList()
        viewModel.allPosts.observe(this) {
            refreshAdapter(it)
        }
    }

    private fun refreshAdapter(posters: ArrayList<Post>) {
        val adapter = PostAdapter(this, posters)
        recyclerView.adapter = adapter
    }
}