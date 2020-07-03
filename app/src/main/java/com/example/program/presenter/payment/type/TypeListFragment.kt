package com.example.program.presenter.payment.type

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.program.R
import com.example.program.databinding.FragmentPaymentTypeListBinding
import com.example.program.presenter.common.BaseFragment

class TypeListFragment : BaseFragment() {

    private lateinit var viewModel: TypeListViewModel
    private lateinit var binding: FragmentPaymentTypeListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(TypeListViewModel::class.java)
        binding = FragmentPaymentTypeListBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbar.setNavigationOnClickListener { requireActivity().onBackPressed() }
        binding.creditCardTypeTv.setOnClickListener {
            findNavController().navigate(R.id.action_fill_credit_card)
        }
    }
}