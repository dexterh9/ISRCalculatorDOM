package com.gmail.henderstd.isrcalculatordom.domain.usecase

public class GetYearlyRate  {
    operator fun invoke(rate:Double) : Double= rate*12

}