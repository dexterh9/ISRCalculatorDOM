package com.gmail.henderstd.ISRCalculatorDOM.domain.usecase

class GetIRSPerMonth {
    operator fun invoke(irsDiscount:Double, salary:Double,rangeLowEnd:Double,extraDiscount : Double) : Double
    {
        return ((((salary*12)-rangeLowEnd)*irsDiscount)+extraDiscount)/12;
    }

}