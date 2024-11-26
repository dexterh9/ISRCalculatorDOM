package com.gmail.henderstd.isrcalculatordom.presentation.view

import androidx.lifecycle.ViewModel
import com.gmail.henderstd.isrcalculatordom.data.repository.SalaryDiscountsRepository
import com.gmail.henderstd.isrcalculatordom.domain.usecase.GetAFPPerMonth
import com.gmail.henderstd.isrcalculatordom.domain.usecase.GetIRSPerMonth
import com.gmail.henderstd.isrcalculatordom.domain.usecase.GetSDSPerMonth
import com.gmail.henderstd.isrcalculatordom.domain.usecase.GetYearlyRate

class ISRCalculatorDOMViewModel : ViewModel() {

    private val  salaryRepo=SalaryDiscountsRepository()
    private val getAFP=GetAFPPerMonth()
    private val getIRS=GetIRSPerMonth()
    private val getSDS=GetSDSPerMonth()
    private val getYearlyRate= GetYearlyRate()

    fun performCalculation(salary:Double){

        salaryRepo.salary=salary

        for(range in salaryRepo.salaryRanges){

            if(salary>=range.rangeLowEnd && salary<=range.rangeHighEnd){

                salaryRepo.salaryCurrentAFPDiscountMonthly=getAFP(salaryRepo.afpDiscountPercentage,salaryRepo.salary)
                salaryRepo.salaryCurrentSDSDiscountMonthly=getSDS(salaryRepo.sdsDiscountPercentage,salaryRepo.salary)
                salaryRepo.salaryCurrentIRSDiscountMonthly=getIRS(range.rangeDiscountRate,salaryRepo.salary,range.rangeLowEnd,range.extraDiscount)


                salaryRepo.salaryCurrentAFPDiscountYearly=getYearlyRate(salaryRepo.salaryCurrentAFPDiscountMonthly)
                salaryRepo.salaryCurrentSDSDiscountYearly=getYearlyRate(salaryRepo.salaryCurrentSDSDiscountMonthly)
                salaryRepo.salaryCurrentIRSDiscountYearly=getYearlyRate(salaryRepo.salaryCurrentIRSDiscountMonthly)

                salaryRepo.totalDiscountsPerMonth=salaryRepo.salaryCurrentAFPDiscountMonthly+salaryRepo.salaryCurrentSDSDiscountMonthly+salaryRepo.salaryCurrentIRSDiscountMonthly
                salaryRepo.totalDiscountsPerYear=salaryRepo.salaryCurrentAFPDiscountYearly+salaryRepo.salaryCurrentSDSDiscountYearly+salaryRepo.salaryCurrentIRSDiscountYearly

                break
            }

        }

    }


}