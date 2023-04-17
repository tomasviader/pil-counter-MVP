package com.example.pil_mobile_basics.mvp.model

import com.example.pil_mobile_basics.mvp.contract.CounterContract


class CounterModel : CounterContract.Model {

    override var counter: Int = INITIAL_VALUE

    override fun increase(inputValue : Int) {
        counter += inputValue
    }

    override fun decrease(inputValue : Int) {
        counter -= inputValue
    }

    override fun reset() {
        counter = INITIAL_VALUE
    }

    companion object {
        private const val INITIAL_VALUE = 0
    }
}