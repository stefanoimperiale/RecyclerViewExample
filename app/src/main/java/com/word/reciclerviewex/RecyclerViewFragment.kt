package com.word.reciclerviewex

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.word.reciclerviewex.databinding.FragmentRecyclerviewBinding


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class RecyclerViewFragment : Fragment() {

    private val viewModel: ExampleItemViewModel by activityViewModels()
    private var _binding: FragmentRecyclerviewBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentRecyclerviewBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. get a reference to recyclerView
        val recyclerView = binding.recyclerView
        // 2. create an adapter
        val mAdapter = RecyclerViewAdapter { exampleItem -> viewModel.deleteItem(exampleItem) }
        // 3. set adapter
        recyclerView.adapter = mAdapter
        viewModel.itemList.observe(viewLifecycleOwner, {
            mAdapter.submitList(it)
        })


        val exampleData =
            listOf(ExampleItem(1, "First element", "This is the first element description"))
        viewModel.initData(exampleData)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}