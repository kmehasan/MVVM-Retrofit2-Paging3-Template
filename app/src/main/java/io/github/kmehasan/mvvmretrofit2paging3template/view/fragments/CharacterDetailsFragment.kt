package io.github.kmehasan.mvvmretrofit2paging3template.view.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.load
import io.github.kmehasan.mvvmretrofit2paging3template.R
import io.github.kmehasan.mvvmretrofit2paging3template.databinding.FragmentCharacterDetailsBinding
import io.github.kmehasan.mvvmretrofit2paging3template.response.charecter_model.Result

class CharacterDetailsFragment : Fragment() {
    lateinit var binding: FragmentCharacterDetailsBinding
    lateinit var character: Result
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCharacterDetailsBinding.inflate(inflater)
        character = requireActivity().intent.getParcelableExtra("character")!!
        Log.d("TAG", "onCreateView: $character")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(character){
            binding.name.text = resources.getString(R.string.name_value).format(name)
            binding.status.text = resources.getString(R.string.status_value).format(status)
            binding.species.text = resources.getString(R.string.species_value).format(species)
            binding.gender.text = resources.getString(R.string.gender_value).format(gender)
            binding.image.load(image)
        }
    }


}