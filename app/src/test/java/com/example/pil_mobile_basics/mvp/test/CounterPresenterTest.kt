package com.example.pil_mobile_basics.mvp.test // ktlint-disable package-name

import com.example.pil_mobile_basics.mvp.contract.CounterContract
import com.example.pil_mobile_basics.mvp.model.CounterModel
import com.example.pil_mobile_basics.mvp.presenter.CounterPresenter
import com.example.pil_mobile_basics.util.Constants.Constants.INITIAL_VALUE
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

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxed = true)
        presenter = CounterPresenter(CounterModel(), view)
    }

    @Test
    fun onInputValueEnteredTest() {
        val number = "10"
        every { view.setInputValue() } returns number
        every { view.onInputValueEntered { view.setInputValue() } } returns view.setCount(number)
        presenter.onInputValueEntered()
        verify { view.setCount(number) }
    }

    @Test
    fun onIncreaseButtonPressedTest() {
        val number = "25"
        val increasedNumber = "50"
        every { view.setInputValue() } returns number
        every { view.onIncreaseButtonPressed { view.setInputValue() } } returns view.setCount(
            increasedNumber,
        )
        presenter.onIncreaseButtonPressed()
        verify { view.setCount(increasedNumber) }
    }

    @Test
    fun onDecreaseButtonPressedTest() {
        val number = "25"
        val decreasedNumber = INITIAL_VALUE
        every { view.setInputValue() } returns number
        every { view.onDecreaseButtonPressed { view.setCount(number) } } returns view.setCount(
            decreasedNumber.toString(),
        )
        presenter.onDecreaseButtonPressed()
        verify { view.setCount(decreasedNumber.toString()) }
    }

    @Test
    fun onResetButtonPressedTest() {
        val number = "30"
        every { view.setInputValue() } returns number
        every { view.onResetButtonPressed { view.setCount(number) } } returns view.setCount(
            INITIAL_VALUE.toString(),
        )
        presenter.onResetButtonPressed()
        verify { view.setCount(INITIAL_VALUE.toString()) }
    }
}
