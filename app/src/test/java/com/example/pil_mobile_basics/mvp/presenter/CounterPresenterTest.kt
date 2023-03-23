package com.example.pil_mobile_basics.mvp.presenter

import com.example.pil_mobile_basics.mvp.contract.CounterContract
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test


internal class CounterPresenterTest {

    private lateinit var presenter: CounterContract.Presenter

    @MockK
    private lateinit var view: CounterContract.View

    @MockK
    private lateinit var model: CounterContract.Model


    @Before
    fun setUp() {
        MockKAnnotations.init(this,relaxed = true)
        presenter = CounterPresenter(model,view)
    }

    @Test
    fun onIncreaseButtonPressedTest() {
        /*val value = 1

        every { model.getCount() } returns value.toString()
        presenter.onIncreaseButtonPressed()

        verify { model.increase(value) }
        verify { view.setCount(model.getCount()) }*/

    }

}