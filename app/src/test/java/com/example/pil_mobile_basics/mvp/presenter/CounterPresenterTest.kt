package com.example.pil_mobile_basics.mvp.presenter

import com.example.pil_mobile_basics.mvp.contract.CounterContract
import com.example.pil_mobile_basics.mvp.model.CounterModel
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test


class CounterPresenterTest {


    @MockK
    private lateinit var view: CounterContract.View

    private lateinit var presenter: CounterContract.Presenter

    private lateinit var model: CounterContract.Model


    @Before
    fun setUp() {
        MockKAnnotations.init(this,relaxed = true)
        presenter = CounterPresenter(CounterModel(),view)
        model = CounterModel()
    }

    @Test
    fun onInputValueEntered() {
        val number = "10"
        every { view.setInputValue() } returns number
        every { view.onInputValueEntered { view.setInputValue() } } returns view.setCount(number)
        presenter.onInputValueEntered()
        model.setInitialValue(number.toInt())
        verify { view.setCount(model.getCount()) }

    }


    @Test
    fun onIncreaseButtonPressedTest() {
        val number = "25"
        val increasedNumber = "50"
        every { view.setInputValue() } returns number
        every { view.onIncreaseButtonPressed { view.setInputValue() } } returns view.setCount(increasedNumber)
        presenter.onIncreaseButtonPressed()
        model.increase(number.toInt())
        verify { view.setCount(model.getCount()) }
    }

    @Test
    fun onDecreaseButtonPressedTest() {
        val number = "25"
        val decreasedNumber = "0"
        every { view.setInputValue() } returns number
        every { view.onDecreaseButtonPressed { view.setCount(number) } } returns view.setCount(decreasedNumber)
        presenter.onDecreaseButtonPressed()
        model.decrease(number.toInt())
        verify { view.setCount(model.getCount()) }
    }
    @Test
    fun onResetButtonPressedTest() {
        val number = "30"
        val initialNumber = "0"
        every { view.setInputValue() } returns number
        every { view.onResetButtonPressed { view.setCount(number) } } returns view.setCount(initialNumber)
        presenter.onResetButtonPressed()
        verify { view.setCount(model.getCount()) }
    }

}