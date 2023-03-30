package com.example.pil_mobile_basics.mvp.model

import com.example.pil_mobile_basics.mvp.contract.CounterContract
import com.example.pil_mobile_basics.util.Constants.Constants.INITIAL_VALUE

class CounterModel : CounterContract.Model {

    private var count = INITIAL_VALUE

    override fun getCount(): String = count.toString()

    override fun setInitialValue(inputValue : Int) {
        count = inputValue
    }

    override fun increase(inputValue : Int) {
        count += inputValue
    }

    override fun decrease(inputValue : Int) {
        count -= inputValue
    }

    override fun reset() {
        count = INITIAL_VALUE
    }
}