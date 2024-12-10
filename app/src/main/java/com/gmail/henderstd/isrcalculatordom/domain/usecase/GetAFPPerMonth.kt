package com.gmail.henderstd.isrcalculatordom.domain.usecase

public class GetAFPPerMonth {
    operator fun invoke(afpDiscountRate:Double, monthLySalary:Double) : Double= monthLySalary*afpDiscountRate

}