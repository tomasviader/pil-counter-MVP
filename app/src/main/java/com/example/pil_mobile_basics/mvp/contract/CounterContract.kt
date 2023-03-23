package com.example.pil_mobile_basics.mvp.contract

interface CounterContract {

    interface Model {
        fun getCount(): String
        fun increase(value : Int )
        fun decrease(value : Int)
        fun reset()
    }

    interface View {
        fun setCount(count: String)
        fun setInputValue() : String
        fun onIncreaseButtonPressed(onClick: () -> Unit)
        fun onDecreaseButtonPressed(onClick: () -> Unit)
        fun onResetButtonPressed(onClick: () -> Unit)
    }

    interface Presenter {
        //fun onInputValueEntered()
        fun onIncreaseButtonPressed()
        fun onDecreaseButtonPressed()
        fun onResetButtonPressed()
    }

}