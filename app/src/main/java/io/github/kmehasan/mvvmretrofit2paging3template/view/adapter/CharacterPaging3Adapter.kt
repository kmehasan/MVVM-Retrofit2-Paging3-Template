package io.github.kmehasan.mvvmretrofit2paging3template.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import io.github.kmehasan.mvvmretrofit2paging3template.databinding.ItemRowBinding
import io.github.kmehasan.mvvmretrofit2paging3template.response.charecter_model.Result
import io.github.kmehasan.mvvmretrofit2paging3template.view.adapter.holder.CharacterViewHolder

class CharacterPaging3Adapter :PagingDataAdapter<Result,CharacterViewHolder>(DiffUtilCallback()){


    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {

        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return CharacterViewHolder(binding)

    }

    class DiffUtilCallback: DiffUtil.ItemCallback<Result>(){

        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.id==newItem.id &&
                    oldItem.name==newItem.name
        }
    }

}