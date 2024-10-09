package com.example.lesson1m5

class CounterPresenter {

    private val model = CounterModel()
    private var counterContract: CounterContract? = null

    fun attachCounterContract(counterContract: CounterContract) {
        this.counterContract = counterContract
        counterContract.showResult(model.getResult())
    }

    fun onIncrement() {
        model.increment()
        counterContract?.showResult(model.getResult())
        counterContract?.showToast(model.getResult())
        counterContract?.changeColor(model.getResult())
    }

    fun onDecrement() {
        model.decrement()
        counterContract?.showResult(model.getResult())
        counterContract?.showToast(model.getResult())
        counterContract?.changeColor(model.getResult())
    }


}