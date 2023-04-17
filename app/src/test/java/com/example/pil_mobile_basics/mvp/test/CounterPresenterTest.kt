package com.example.pil_mobile_basics.mvp.test // ktlint-disable package-name

import com.example.pil_mobile_basics.mvp.contract.CounterContract
import com.example.pil_mobile_basics.mvp.model.CounterModel
import com.example.pil_mobile_basics.mvp.presenter.CounterPresenter
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
    fun onIncreaseButtonPressedTest() {
        every { view.getInputValue() } returns TEN_STRING

        presenter.onIncreaseButtonPressed()

        verify { view.setCount(TEN_STRING) }
    }

    @Test
    fun `on increment button pressed without number test`() {
        every { view.getInputValue() } returns EMPTY_STRING

        presenter.onIncreaseButtonPressed()

        verify { view.setCount(ZERO_STRING) }
    }

    @Test
    fun onDecreaseButtonPressedTest() {
        every { view.getInputValue() } returns SEVEN_STRING

        presenter.onDecreaseButtonPressed()

        verify { view.setCount(ZERO_STRING) }
    }
    @Test
    fun onResetButtonPressedTest() {
        every { view.getInputValue() } returns SEVEN_STRING

        presenter.onIncreaseButtonPressed()

        verify { view.setCount(SEVEN_STRING) }

        presenter.onResetButtonPressed()

        verify { view.setCount(ZERO_STRING) }
        verify { view.clear() }
    }

    companion object {
        private const val ZERO_STRING = "0"
        private const val TEN_STRING = "5"
        private const val SEVEN_STRING = "7"
        private const val EMPTY_STRING = ""
    }
}
