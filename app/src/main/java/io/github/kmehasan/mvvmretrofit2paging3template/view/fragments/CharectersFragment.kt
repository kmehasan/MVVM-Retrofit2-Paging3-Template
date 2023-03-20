package io.github.kmehasan.mvvmretrofit2paging3template.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.lifecycleScope
import io.github.kmehasan.mvvmretrofit2paging3template.databinding.FragmentCharectersBinding
import io.github.kmehasan.mvvmretrofit2paging3template.view.adapter.CharacterListAdapter
import io.github.kmehasan.mvvmretrofit2paging3template.view_model.MainScreenViewModel
import io.github.kmehasan.mvvmretrofit2paging3template.response.charecter_model.Result
import io.github.kmehasan.mvvmretrofit2paging3template.view.adapter.CharacterPaging3Adapter
import kotlinx.coroutines.flow.collectLatest

class CharectersFragment : Fragment() {
    lateinit var mainScreenViewModel: MainScreenViewModel
    lateinit var characterListAdapter: CharacterPaging3Adapter
    lateinit var binding: FragmentCharectersBinding
    private val resultList = mutableListOf<Result>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mainScreenViewModel = ViewModelProvider(this).get()
        characterListAdapter = CharacterPaging3Adapter()
        binding = FragmentCharectersBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.RecyclerView.apply {
            adapter = characterListAdapter
        }
        mainScreenViewModel.isLoading.observe(viewLifecycleOwner) {
            binding.progressbar.visibility = if (it) View.VISIBLE else View.GONE
        }
//        if (resultList.isEmpty()) mainScreenViewModel.getCharacterList()
//            .observe(viewLifecycleOwner, Observer {
//                resultList.addAll(it.results)
//                characterListAdapter.notifyItemRangeInserted(0, it.results.size)
//            })
        lifecycleScope.launchWhenCreated {
            mainScreenViewModel.getALLCharacterList().let {
                it.collectLatest { it ->
                    characterListAdapter.submitData(it)

                }
            }
        }
    }

}