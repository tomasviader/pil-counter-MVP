package com.example.pil_mobile_basics.mvp.presenter

import com.example.pil_mobile_basics.mvp.contract.CounterContract

class CounterPresenter(private val model: CounterContract.Model, private val view: CounterContract.View) : CounterContract.Presenter {

    init {
        view.onIncreaseButtonPressed { onIncreaseButtonPressed() }
        view.onDecreaseButtonPressed { onDecreaseButtonPressed() }
        view.onResetButtonPressed { onResetButtonPressed() }
        view.setCount(model.counter.toString())
    }

    private fun getInputInt(): Int = view.getInputValue().ifEmpty { ZERO_STRING }.toInt()

    override fun onIncreaseButtonPressed() {
        model.increase(getInputInt())
        view.setCount(model.counter.toString())
    }

    override fun onDecreaseButtonPressed() {
        model.decrease(getInputInt())
        view.setCount(model.counter.toString())
    }

    override fun onResetButtonPressed() {
        model.reset()
        view.setCount(model.counter.toString())
        view.clear()
    }

    companion object {
        private const val ZERO_STRING = "0"
    }
}