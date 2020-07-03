package com.example.program.domain.utils

import java.util.regex.Matcher
import java.util.regex.Pattern

class CreditCardValidator {
    private var patternCreditCard: Pattern = Pattern.compile("^\\d{4}\\s\\d{4}\\s\\d{4}\\s\\d{4}$")
    private var patternDate: Pattern = Pattern.compile("^\\d{2}/\\d{2}$")
    private var patternCvv: Pattern = Pattern.compile("^\\d{3}$")

    fun validateCardNumber(value: String?): Boolean {
        if (value == null) return false
        val matcher: Matcher = patternCreditCard.matcher(value)
        return matcher.matches()
    }

    fun validateDate(value: String?): Boolean {
        if (value == null) return false
        val matcher: Matcher = patternDate.matcher(value)
        return matcher.matches()
    }

    fun validateCvv(value: String?): Boolean {
        if (value == null) return false
        val matcher: Matcher = patternCvv.matcher(value)
        return matcher.matches()
    }
}