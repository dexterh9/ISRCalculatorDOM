package com.gmail.henderstd.isrcalculatordom.domain.usecase

public class GetIRSPerMonth {
    operator fun invoke(irsDiscount:Double, salary:Double,rangeLowEnd:Double,extraDiscount : Double) : Double
    {
        return ((((salary*12)-rangeLowEnd)*irsDiscount)+extraDiscount)/12
    }

}