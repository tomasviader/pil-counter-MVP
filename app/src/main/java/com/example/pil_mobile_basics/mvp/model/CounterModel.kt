package com.example.pil_mobile_basics.mvp.model

import com.example.pil_mobile_basics.mvp.contract.CounterContract

class CounterModel : CounterContract.Model {


    private var count = 0

    override fun getCount(): String = count.toString()


    override fun increase(value : Int) {
        count = (count + value) + 1
    }

    override fun decrease(value : Int) {
        count -= value
    }

    override fun reset() {
        count = 0
    }

}