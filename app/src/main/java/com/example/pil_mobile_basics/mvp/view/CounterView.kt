package com.example.pil_mobile_basics.mvp.view

import androidx.core.widget.addTextChangedListener
import com.example.pil_mobile_basics.activity.MainActivity
import com.example.pil_mobile_basics.databinding.ActivityMainBinding
import com.example.pil_mobile_basics.mvp.contract.CounterContract
import com.example.pil_mobile_basics.mvp.view.base.ActivityView

class CounterView(activity: MainActivity) : ActivityView(activity), CounterContract.View {

    private var binding: ActivityMainBinding = ActivityMainBinding.inflate(activity.layoutInflater)

    init { activity.setContentView(binding.root) }

    override fun setCount(count: String) {
        binding.counterValue.text = count
    }

    override fun setInputValue() : String= binding.inputValue.text.toString()

    override fun onInputValueEntered( onChange: () -> Unit ){
        binding.inputValue.addTextChangedListener{ onChange() }
    }

    override fun onIncreaseButtonPressed(onClick: () -> Unit) {
        binding.increaseButton.setOnClickListener{ onClick() }
    }

    override fun onDecreaseButtonPressed(onClick: () -> Unit) {
        binding.decreaseButton.setOnClickListener{ onClick() }
    }

    override fun onResetButtonPressed(onClick: () -> Unit) {
        binding.resetButton.setOnClickListener{ onClick() }
    }
}