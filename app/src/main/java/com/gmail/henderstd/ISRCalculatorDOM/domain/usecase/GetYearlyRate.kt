package com.gmail.henderstd.ISRCalculatorDOM.domain.usecase

class GetYearlyRate  {
    operator fun invoke(rate:Double) : Double= rate*12;

}