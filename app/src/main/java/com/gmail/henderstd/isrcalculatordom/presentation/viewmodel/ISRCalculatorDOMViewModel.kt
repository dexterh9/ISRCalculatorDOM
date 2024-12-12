package com.gmail.henderstd.isrcalculatordom.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel

import com.gmail.henderstd.isrcalculatordom.data.repository.SalaryDiscountsRepository
import com.gmail.henderstd.isrcalculatordom.domain.usecase.GetAFPPerMonth
import com.gmail.henderstd.isrcalculatordom.domain.usecase.GetIRSPerMonth
import com.gmail.henderstd.isrcalculatordom.domain.usecase.GetSDSPerMonth
import com.gmail.henderstd.isrcalculatordom.domain.usecase.GetYearlyRate

public open class ISRCalculatorDOMViewModel : ViewModel() {

    private val  salaryRepo=SalaryDiscountsRepository()
    private val getAFP=GetAFPPerMonth()
    private val getIRS=GetIRSPerMonth()
    private val getSDS=GetSDSPerMonth()
    private val getYearlyRate= GetYearlyRate()

    fun performCalculation(salary: Double){

        salaryRepo.salary=salary

        for(range in salaryRepo.salaryRanges){

            if(salary*12>=range.rangeLowEnd && salary*12<=range.rangeHighEnd){

                salaryRepo.salaryCurrentAFPDiscountMonthly=getAFP(salaryRepo.afpDiscountPercentage,salaryRepo.salary)

                Log.d("MYPP",salaryRepo.salaryCurrentAFPDiscountMonthly.toString())

                salaryRepo.salaryCurrentSDSDiscountMonthly=getSDS(salaryRepo.sdsDiscountPercentage,salaryRepo.salary)
                salaryRepo.salaryCurrentIRSDiscountMonthly=getIRS(range.rangeDiscountRate,salaryRepo.salary,range.rangeLowEnd,range.extraDiscount)


                salaryRepo.salaryCurrentAFPDiscountYearly=getYearlyRate(salaryRepo.salaryCurrentAFPDiscountMonthly)
                salaryRepo.salaryCurrentSDSDiscountYearly=getYearlyRate(salaryRepo.salaryCurrentSDSDiscountMonthly)
                salaryRepo.salaryCurrentIRSDiscountYearly=getYearlyRate(salaryRepo.salaryCurrentIRSDiscountMonthly)

                salaryRepo.totalDiscountsPerMonth=salaryRepo.salaryCurrentAFPDiscountMonthly+salaryRepo.salaryCurrentSDSDiscountMonthly+salaryRepo.salaryCurrentIRSDiscountMonthly
                salaryRepo.totalDiscountsPerYear=salaryRepo.salaryCurrentAFPDiscountYearly+salaryRepo.salaryCurrentSDSDiscountYearly+salaryRepo.salaryCurrentIRSDiscountYearly

                salaryRepo.salary_net_monthly=salaryRepo.salary-salaryRepo.totalDiscountsPerMonth;
                salaryRepo.salary_net_yearly=salaryRepo.salary_net_monthly*12-salaryRepo.totalDiscountsPerYear;

                break
            }

        }

    }


    fun getSalaryCurrentAFPDiscountMonthly():Double=salaryRepo.salaryCurrentAFPDiscountMonthly

    fun getSalaryCurrentSDSDiscountMonthly():Double=salaryRepo.salaryCurrentSDSDiscountMonthly

    fun getSalaryCurrentIRSDiscountMonthly():Double=salaryRepo.salaryCurrentIRSDiscountMonthly
    fun getNetSalaryMonthly():Double=salaryRepo.salary_net_monthly

    fun getSalaryCurrentAFPDiscountYearly():Double=salaryRepo.salaryCurrentAFPDiscountYearly

    fun getSalaryCurrentSDSDiscountYearly():Double=salaryRepo.salaryCurrentSDSDiscountYearly

    fun getSalaryCurrentIRSDiscountYearly():Double=salaryRepo.salaryCurrentIRSDiscountYearly

    fun getTotalDiscountsPerMonth():Double=salaryRepo.totalDiscountsPerMonth

    fun getTotalDiscountsPerYear():Double=salaryRepo.totalDiscountsPerYear

    fun getAFPDiscountPercentage():Double=salaryRepo.afpDiscountPercentage

    fun getSDSDiscountPercentage():Double=salaryRepo.sdsDiscountPercentage

}