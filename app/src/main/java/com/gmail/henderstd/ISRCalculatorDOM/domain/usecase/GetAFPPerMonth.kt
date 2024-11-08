package com.gmail.henderstd.ISRCalculatorDOM.domain.usecase

class GetAFPPerMonth {
    operator fun invoke(afpDiscountRate:Double, monthLySalary:Double) : Double= monthLySalary*afpDiscountRate;

}