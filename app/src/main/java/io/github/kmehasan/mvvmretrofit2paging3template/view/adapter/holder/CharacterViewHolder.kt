package io.github.kmehasan.mvvmretrofit2paging3template.view.adapter.holder

import android.content.Intent
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import coil.Coil
import coil.load
import io.github.kmehasan.mvvmretrofit2paging3template.R
import io.github.kmehasan.mvvmretrofit2paging3template.databinding.ItemRowBinding
import io.github.kmehasan.mvvmretrofit2paging3template.response.charecter_model.Result
import io.github.kmehasan.mvvmretrofit2paging3template.view.activity.CharacterDetailsActivity

class CharacterViewHolder(val view: ItemRowBinding): RecyclerView.ViewHolder(view.root) {
    fun bind(result:Result){
        view.name.text = result.name
        view.image.load(result.image)
        view.location.text = result.location?.name

        view.root.setOnClickListener {
            val bundle = Bundle()
            val intent = Intent(view.root.context,CharacterDetailsActivity::class.java)
//            bundle.putParcelable("test",result)
            intent.putExtra("character", result)
            view.name.context.startActivity(intent)
//            Navigation.findNavController(view.root).navigate(R.id.action_charectersFragment_to_characterDetailsFragment,bundle)
        }
    }
}