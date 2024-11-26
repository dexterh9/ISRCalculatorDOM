package com.gmail.henderstd.isrcalculatordom.domain.usecase

class GetSDSPerMonth {
    operator fun invoke(sdsDiscountRate:Double, monthLySalary:Double) : Double= monthLySalary*sdsDiscountRate

}