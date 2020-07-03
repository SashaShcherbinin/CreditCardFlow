package com.example.program.presenter.payment.status

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.program.R
import com.example.program.databinding.FragmentPaymentStatusBinding
import com.example.program.presenter.common.BaseFragment

class StatusFragment : BaseFragment() {

    private val args: StatusFragmentArgs by navArgs()

    private lateinit var viewModel: StatusViewModel
    private lateinit var binding: FragmentPaymentStatusBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(StatusViewModel::class.java)
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_payment_status,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.paymentStatus.value = args.paymentStatus
        initViews()
        initBinding()
    }

    private fun initBinding() {
        binding.vm = viewModel
        binding.lifecycleOwner = this
    }

    private fun initViews() {
        binding.toolbar.setNavigationOnClickListener { requireActivity().onBackPressed() }
        binding.finishBtn.setOnClickListener {
            StatusFragmentDirections.actionBackToHome().run {
                findNavController().navigate(this)
            }
        }
    }
}