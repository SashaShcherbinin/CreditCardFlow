package com.example.program.presenter.payment.amount

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.program.R
import com.example.program.databinding.FragmentPaymentAmountBinding
import com.example.program.databinding.FragmentPaymentTypeListBinding
import com.example.program.presenter.common.BaseFragment

class AmountFragment : BaseFragment() {

    private val args: AmountFragmentArgs by navArgs()

    private lateinit var viewModel: AmountViewModel
    private lateinit var binding: FragmentPaymentAmountBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(AmountViewModel::class.java)
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_payment_amount,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.creditCard.value = args.creditCard
        initViews()
        initBinding()
        viewModel.goNexEvent.observe(viewLifecycleOwner, Observer {
            AmountFragmentDirections.actionPaymentStatus(it).run {
                findNavController().navigate(this)
            }
        })
    }

    private fun initBinding() {
        binding.vm = viewModel
        binding.lifecycleOwner = this
    }

    private fun initViews() {
        binding.toolbar.setNavigationOnClickListener { requireActivity().onBackPressed() }
        binding.changeBtn.setOnClickListener { requireActivity().onBackPressed() }
    }
}