package com.example.lesson1m5

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lesson1m5.databinding.ActivityCounterBinding

class CounterActivity : AppCompatActivity(), CounterContract {

    private val presenter = CounterPresenter()
    private val binding by lazy { ActivityCounterBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        presenter.attachCounterContract(this)

        binding.btnIncrement.setOnClickListener {
            presenter.onIncrement()
        }

        binding.btnDecrement.setOnClickListener {
            presenter.onDecrement()
        }
    }

    override fun showResult(count: Int) {
        binding.tvResult.text = count.toString()
    }

    override fun showToast(count: Int) {
        if (count == 10) {
            Toast.makeText(this, "Поздравляем", Toast.LENGTH_LONG).show()
        }
    }

    override fun changeColor(count: Int) {
        if (count == 15) binding.tvResult.setTextColor(getColor(R.color.green))
        else binding.tvResult.setTextColor(getColor(R.color.black))
    }
}