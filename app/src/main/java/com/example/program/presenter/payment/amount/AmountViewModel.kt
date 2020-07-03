package com.example.program.presenter.payment.amount

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.program.domain.entity.CreditCard
import com.example.program.domain.entity.PaymentStatus
import com.example.program.presenter.common.SingleLiveEvent
import com.example.program.presenter.common.observeForever

class AmountViewModel : ViewModel() {

    val creditCard = MutableLiveData<CreditCard>()
    val cardInfo = MutableLiveData<String>()
    val amount = MutableLiveData<String>()
    val isEnable = MutableLiveData<Boolean>()

    val goNexEvent = SingleLiveEvent<PaymentStatus>()

    init {
        creditCard.observeForever {
            cardInfo.value = "VISA *" + it.number.takeLast(4)
        }
        observeForever(amount) {
            val value = it.toFloatOrNull()
            if (value == null) isEnable.value = false
            else isEnable.value = value > 0.0
        }
    }

    fun next() {
        goNexEvent.value = PaymentStatus(
            amount = amount.value!!.toFloat(),
            creditCard = creditCard.value!!
        )
    }

}