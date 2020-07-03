package com.example.program.presenter.payment.creditcard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.program.databinding.FragmentPaymentCreditCardBinding
import com.example.program.presenter.common.BaseFragment
import com.example.program.presenter.common.text.CreditCardDateFormattingTextWatcher
import com.example.program.presenter.common.text.CreditCardNumberFormattingTextWatcher

class CreditCardFragment : BaseFragment() {

    private lateinit var viewModel: CreditCardViewModel
    private lateinit var binding: FragmentPaymentCreditCardBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(CreditCardViewModel::class.java)
        viewModel.theme.value = requireActivity().theme
        binding = FragmentPaymentCreditCardBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpBinding()
        initViews()
        observerVents()
    }

    private fun setUpBinding() {
        binding.vm = viewModel
        binding.lifecycleOwner = this
    }

    private fun initViews() {
        binding.toolbar.setNavigationOnClickListener { requireActivity().onBackPressed() }
        binding.cardNumberEt.addTextChangedListener(CreditCardNumberFormattingTextWatcher())
        binding.dateEt.addTextChangedListener(CreditCardDateFormattingTextWatcher())
    }

    private fun observerVents() {
        viewModel.continueEvent.observe(this, Observer {
            CreditCardFragmentDirections.actionPaymentAmount(it).run {
                findNavController().navigate(this)
            }
        })
    }
}