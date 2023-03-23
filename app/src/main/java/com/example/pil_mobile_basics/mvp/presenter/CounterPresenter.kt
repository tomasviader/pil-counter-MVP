package com.example.pil_mobile_basics.mvp.presenter

import com.example.pil_mobile_basics.mvp.contract.CounterContract

class CounterPresenter(private val model: CounterContract.Model, private val view: CounterContract.View) : CounterContract.Presenter {

    init {
        view.onIncreaseButtonPressed { onIncreaseButtonPressed() }
        view.onDecreaseButtonPressed { onDecreaseButtonPressed() }
        view.onResetButtonPressed { onResetButtonPressed() }
        view.onInputValueEntered { onInputValueEntered() }
    }

    override fun onInputValueEntered() {
        model.setInitialValue(view.setInputValue().toInt())
        view.setCount(model.getCount())
    }

    override fun onIncreaseButtonPressed() {
        model.increase(view.setInputValue().toInt())
        view.setCount(model.getCount())
    }

    override fun onDecreaseButtonPressed() {
        model.decrease(view.setInputValue().toInt())
        view.setCount(model.getCount())
    }

    override fun onResetButtonPressed() {
        model.reset()
        view.setCount(model.getCount())
    }
}