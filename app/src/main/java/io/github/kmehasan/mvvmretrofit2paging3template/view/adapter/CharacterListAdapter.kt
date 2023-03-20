package io.github.kmehasan.mvvmretrofit2paging3template.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.kmehasan.mvvmretrofit2paging3template.databinding.ItemRowBinding
import io.github.kmehasan.mvvmretrofit2paging3template.response.charecter_model.Result
import io.github.kmehasan.mvvmretrofit2paging3template.view.adapter.holder.CharacterViewHolder

class CharacterListAdapter(private val characterList: List<Result>): RecyclerView.Adapter<CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = ItemRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CharacterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(characterList[position])
    }
}