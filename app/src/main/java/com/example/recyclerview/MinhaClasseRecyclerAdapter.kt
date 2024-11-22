package com.example.recyclerview

//import android.R
import android.content.Context
// ??? //
//import com.example.recyclerview.R

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MinhaClasseRecyclerAdapter(val arrayItens: ArrayList<Pessoa>):
    RecyclerView.Adapter<MinhaClasseRecyclerAdapter.MyViewHolder>() {



    class MyViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        val nome: TextView = itemView.findViewById(R.id.nome)
        val idade: TextView = itemView.findViewById(R.id.idade)
        val imagem: ImageView = itemView.findViewById(R.id.imageView)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val pessoa = arrayItens[position]
        holder.nome.text = pessoa.nome
        holder.idade.text = pessoa.idade.toString()
        holder.imagem.setImageResource(pessoa.imagem)

     }

    override fun getItemCount(): Int {
        return arrayItens.size
    }


}
