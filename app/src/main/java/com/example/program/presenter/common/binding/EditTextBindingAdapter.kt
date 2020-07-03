package com.example.program.presenter.common.binding

import androidx.databinding.BindingMethod
import androidx.databinding.BindingMethods
import com.google.android.material.textfield.TextInputLayout

@BindingMethods(
    BindingMethod(
        type = TextInputLayout::class,
        attribute = "bind_til_error",
        method = "setError"
    ),
    BindingMethod(
        type = TextInputLayout::class,
        attribute = "bind_til_hint",
        method = "setHint"
    )
)
object EditTextBindingAdapter {

//    @JvmStatic
//    @BindingAdapter(value = ["bind_til_error"], requireAll = false)
//    fun bindError(view: TextInputLayout, string: CharSequence?) {
//        view.error = string
//    }

}