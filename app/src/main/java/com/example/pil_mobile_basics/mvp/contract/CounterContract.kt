package com.example.pil_mobile_basics.mvp.contract

interface CounterContract {

    interface Model {
        var counter: Int
        fun increase(inputValue : Int )
        fun decrease(inputValue : Int)
        fun reset()
    }

    interface View {
        fun setCount(counter: String)
        fun getInputValue() : String
        fun clear()
        fun onIncreaseButtonPressed(onClick: () -> Unit)
        fun onDecreaseButtonPressed(onClick: () -> Unit)
        fun onResetButtonPressed(onClick: () -> Unit)
    }

    interface Presenter {
        fun onIncreaseButtonPressed()
        fun onDecreaseButtonPressed()
        fun onResetButtonPressed()
    }

}