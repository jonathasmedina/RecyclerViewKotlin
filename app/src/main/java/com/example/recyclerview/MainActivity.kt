package com.example.recyclerview

import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper


class MainActivity : AppCompatActivity() {

    private lateinit var searchView_: SearchView
    private lateinit var recyclerView_: RecyclerView

    private var arrayItens = ArrayList<Pessoa>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchView_ = findViewById(R.id.searchView)
        recyclerView_ = findViewById(R.id.recyclerView)

        popularArrayList();

        configurarAdapter();

        val snapHelper: SnapHelper = LinearSnapHelper() // ou PagerSnapHelper(); para simular ViewPager - elemento tela toda
        snapHelper.attachToRecyclerView(recyclerView_)
    }

    private fun popularArrayList() {
        arrayItens.add(Pessoa("joão", 31, R.mipmap.ic_launcher_person))
        arrayItens.add(Pessoa("joão 2", 131, R.mipmap.ic_launcher_person))
        arrayItens.add(Pessoa("joão 3", 231, R.mipmap.ic_launcher_person))
    }

    private fun configurarAdapter() {
        var meuRecyclerAdapter: MinhaClasseRecyclerAdapter = MinhaClasseRecyclerAdapter(arrayItens)
        // ou só var meuRecyclerAdapter = MinhaClasseRecyclerAdapter(), sem o tipo

        val layoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        recyclerView_.setLayoutManager(layoutManager)
        //companion object
        recyclerView_.setAdapter(meuRecyclerAdapter)

    }


}