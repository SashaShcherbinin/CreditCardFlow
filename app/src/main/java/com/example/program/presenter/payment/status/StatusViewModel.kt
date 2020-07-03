package com.example.program.presenter.payment.status

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.program.domain.entity.PaymentStatus
import com.example.program.presenter.common.observeForever
import java.text.DecimalFormat

class StatusViewModel : ViewModel() {

    val paymentStatus = MutableLiveData<PaymentStatus>()
    val cardNumber = MutableLiveData<String>()
    val expiryDate = MutableLiveData<String>()
    val cvv = MutableLiveData<String>()
    val amount = MutableLiveData<String>()

    private val amountFormatter = DecimalFormat.getNumberInstance()

    init {
        observeForever(paymentStatus) {
            cardNumber.value = it.creditCard.number
            expiryDate.value = it.creditCard.date
            cvv.value = it.creditCard.cvv
            amount.value = amountFormatter.format(it.amount)
        }
    }

}