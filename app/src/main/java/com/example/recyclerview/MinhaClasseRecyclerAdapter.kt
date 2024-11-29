package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MinhaClasseRecyclerAdapter(val arrayItens: ArrayList<Pessoa>): RecyclerView.Adapter<MinhaClasseRecyclerAdapter.MyViewHolder>() {

    //variável para usar no filtro
    //duplicamos a lista...
    //MutableList = List, mas pode ser reescrita, redimensionada, etc
    private var listaCopia: MutableList<Pessoa> = arrayItens.toMutableList()

    //classe que representa um item da lista e suas views correspondentes
    class MyViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        val nome: TextView = itemView.findViewById(R.id.nome)
        val cargo: TextView = itemView.findViewById(R.id.cargo)
        val imagem: ImageView = itemView.findViewById(R.id.imageView)
    }

    //cria o item da lista e retorna o MyViewHolder contendo a view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(view)
    }

    //popula o item da lista com os dados do array de itens e a posição do item na lista
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val pessoa = arrayItens[position]
        holder.nome.text = pessoa.nome
        holder.cargo.text = pessoa.cargo
        holder.imagem.setImageResource(pessoa.imagem)
    }

    //retorna o tamanho do array de itens
    override fun getItemCount(): Int {
        return arrayItens.size
    }

    //função criada para filtrar lista de acordo com o que foi digitado na searchView
    fun filtrar(query: String) {
        //limpando array que monta a lista ao buscar algum termo na searchView
        arrayItens.clear()
        //digitou algo e apagou = trazer todos
        if (query.isEmpty()) {
            arrayItens.addAll(listaCopia)
        } else {
            //algum texto digitado na busca
            //converte para letra minúscula para não haver conflito com letras maiúsculas
            var newTextMin = query.lowercase()
            //percorre o array com os dados originais e busca o termo digitado na searchView
            for (item in listaCopia) {
                //caso, nos dados originais, exista o termo procurado, popule o array vazio com o item
                if (item.nome.lowercase().contains(newTextMin)) {
                    arrayItens.add(item)
                }
            }
        }
        //notifica o adapter que os dados mudaram e atualiza a lista
        notifyDataSetChanged()
    }
}
