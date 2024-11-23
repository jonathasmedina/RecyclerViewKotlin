package com.example.recyclerview

import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    private lateinit var searchView_: SearchView
    private lateinit var recyclerView_: RecyclerView

    private var arrayItens = ArrayList<Pessoa>()

    lateinit var meuRecyclerAdapter: MinhaClasseRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchView_ = findViewById(R.id.searchView)
        recyclerView_ = findViewById(R.id.recyclerView)

        searchView_.isIconified = false

        popularArrayList();

        configurarAdapter();

        //busca com searchview
        searchView_.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false;
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                meuRecyclerAdapter.filtrar(p0.toString())
                return false;
            }
        })
    }

    private fun popularArrayList() {
        arrayItens.add(Pessoa("João da Silva", "CEO", R.drawable.aiphoto))
        arrayItens.add(Pessoa("Maria José", "Desenvolvedor Senior", R.drawable.aiphoto))
        arrayItens.add(Pessoa("Pedro Paulo", "Desenvolvedor Junior", R.drawable.aiphoto))

        arrayItens.add(Pessoa("João da Silva", "Desenvolvedor Pleno", R.drawable.aiphoto))
        arrayItens.add(Pessoa("Francisca", "Full Stacker", R.drawable.aiphoto))
        arrayItens.add(Pessoa("Edilene Pereira", "Back-end Developer", R.drawable.aiphoto))
    }

    private fun configurarAdapter() {
        meuRecyclerAdapter = MinhaClasseRecyclerAdapter(arrayItens)

        val layoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        recyclerView_.setLayoutManager(layoutManager)
        //companion object
        recyclerView_.setAdapter(meuRecyclerAdapter)

    }


}