package com.example.pil_mobile_basics.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pil_mobile_basics.mvp.model.CounterModel
import com.example.pil_mobile_basics.mvp.presenter.CounterPresenter
import com.example.pil_mobile_basics.mvp.view.CounterView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CounterPresenter(CounterModel(),CounterView(this))
    }
}