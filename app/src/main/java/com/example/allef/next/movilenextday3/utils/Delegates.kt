package com.example.allef.next.movilenextday3.utils

import android.app.Activity
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import kotlin.reflect.KProperty

/**
 * delegate para inicializar databiding
 */
fun <T : ViewDataBinding> contentView(@LayoutRes layoutRes:
                                      Int): SetContentView<T> {
    return SetContentView(layoutRes)
}
class SetContentView<out T : ViewDataBinding>(
        @LayoutRes private val layoutRes: Int) {
    private var value : T? = null
    operator fun getValue(thisRef: Activity, property:
    KProperty<*>): T {
        value = value ?: DataBindingUtil.setContentView(thisRef,
                layoutRes)
        return value!!
    }
}