package io.github.kmehasan.mvvmretrofit2paging3template.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import io.github.kmehasan.mvvmretrofit2paging3template.R
import io.github.kmehasan.mvvmretrofit2paging3template.databinding.FragmentMainScreenBinding

/**
 * A simple [Fragment] subclass.
 * Use the [MainScreenFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainScreenFragment : Fragment() {

    lateinit var binding: FragmentMainScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMainScreenBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("Test", "Data")
            Navigation.findNavController(it).navigate(R.id.action_mainScreenFragment_to_charectersFragment2,bundle)
        }
    }

}