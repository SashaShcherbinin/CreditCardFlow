package com.example.program.presenter.payment.creditcard

import android.content.res.Resources
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.program.R
import com.example.program.domain.entity.CreditCard
import com.example.program.domain.utils.CreditCardValidator
import com.example.program.presenter.common.SingleLiveEvent
import com.example.program.presenter.common.observeArgForeverNullable

class CreditCardViewModel : ViewModel() {

    private val validator = CreditCardValidator()

    val theme = MutableLiveData<Resources.Theme>()

    val cardNumber = MutableLiveData<String>()
    val date = MutableLiveData<String>()
    val cvv = MutableLiveData<String>()
    val cardNumberError = MutableLiveData<String>()
    val dateError = MutableLiveData<String>()
    val cvvError = MutableLiveData<String>()
    val isEnable = MutableLiveData<Boolean>()

    val continueEvent = SingleLiveEvent<CreditCard>()

    init {
        observeArgForeverNullable(cardNumber, date, cvv, theme) { list ->
            if (list[3] == null) return@observeArgForeverNullable
            val theme = list[3] as Resources.Theme
            isEnable.value =
                validateCardNumber(list[0] as String?, theme) &&
                        validateDate(list[1] as String?, theme) &&
                        validateCvv(list[2] as String?, theme)
        }
    }

    private fun validateCvv(cvv: String?, theme: Resources.Theme): Boolean {
        return validator.validateCvv(cvv).apply {
            if (this || cvv.isNullOrEmpty()) cvvError.value = null
            else cvvError.value = theme.resources.getString(R.string.payment_error_incorrectCvv)
        }
    }

    private fun validateDate(date: String?, theme: Resources.Theme): Boolean {
        return validator.validateDate(date).apply {
            if (this || date.isNullOrBlank()) dateError.value = null
            else dateError.value = theme.resources.getString(R.string.payment_error_incorrectDate)
        }
    }

    private fun validateCardNumber(cardNumber: String?, theme: Resources.Theme): Boolean {
        return validator.validateCardNumber(cardNumber).apply {
            if (this || cardNumber.isNullOrEmpty()) cardNumberError.value = null
            else cardNumberError.value =
                theme.resources.getString(R.string.payment_error_incorrectCardNumber)
        }
    }

    fun next() {
        continueEvent.value =
            CreditCard(
                number = cardNumber.value!!,
                date = date.value!!,
                cvv = cvv.value!!
            )
    }

}