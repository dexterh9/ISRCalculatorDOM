package com.gmail.henderstd.isrcalculatordom.domain.usecase

class GetAFPPerMonth {
    operator fun invoke(afpDiscountRate:Double, monthLySalary:Double) : Double= monthLySalary*afpDiscountRate

}