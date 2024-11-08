package com.gmail.henderstd.ISRCalculatorDOM.domain.usecase

class GetSDSPerMonth {
    operator fun invoke(sdsDiscountRate:Double, monthLySalary:Double) : Double= monthLySalary*sdsDiscountRate;

}