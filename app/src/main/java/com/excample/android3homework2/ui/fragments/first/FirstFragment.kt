package com.excample.android3homework2.ui.fragments.first

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.excample.android3homework2.R
import com.excample.android3homework2.databinding.FragmentFirstBinding
import com.excample.android3homework2.ui.adapters.Adapter

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private val viewModel by activityViewModels<ViewModel>()
    private var adapter = Adapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setOnClickListeners()
        setupObserves()
    }

    private fun initialize() {
        binding.recyclerView.adapter = adapter
    }

    private fun setOnClickListeners() {
        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_addFragment)
        }
    }

    private fun setupObserves() {
        viewModel.liveData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }
}
