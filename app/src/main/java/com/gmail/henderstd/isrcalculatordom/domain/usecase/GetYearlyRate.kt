package com.gmail.henderstd.isrcalculatordom.domain.usecase

class GetYearlyRate  {
    operator fun invoke(rate:Double) : Double= rate*12

}