package com.excample.android3homework2.ui.fragments.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.excample.android3homework2.databinding.FragmentAddBinding
import com.excample.android3homework2.ui.fragments.first.ViewModel

class AddFragment : Fragment() {

    private lateinit var binding: FragmentAddBinding
    private val viewModel by activityViewModels<ViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClickListeners()
    }

    private fun onClickListeners() {
        binding.btnSave.setOnClickListener {
            val number = binding.etName.text.toString().trim()
            val title = binding.etAge.text.toString()
            val description = binding.etEmail.text.toString().trim()

            viewModel.addNote(number = number, title = title, description = description)
            findNavController().navigateUp()
        }
    }
}