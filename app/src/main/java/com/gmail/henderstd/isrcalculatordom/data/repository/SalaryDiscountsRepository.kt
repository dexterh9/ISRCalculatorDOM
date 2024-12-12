package com.gmail.henderstd.isrcalculatordom.data.repository

import com.gmail.henderstd.isrcalculatordom.data.model.ISRRangesModel

public class SalaryDiscountsRepository {


    /*user salary, current discounts per period*/
    private var _salary : Double = 0.0

    var salary: Double
        get() = _salary
        set(value) {
            _salary = value
        }


    private var _salary_net_monthly : Double = 0.0

    var salary_net_monthly: Double
        get() = _salary_net_monthly
        set(value) {
            _salary_net_monthly = value
        }

    private var _salary_net_yearly : Double = 0.0

    var salary_net_yearly: Double
        get() = _salary_net_yearly
        set(value) {
            _salary_net_yearly = value
        }


    private var _salaryCurrentAFPDiscountMonthly : Double = 0.0

    var salaryCurrentAFPDiscountMonthly: Double
        get() = _salaryCurrentAFPDiscountMonthly
        set(value) {
            _salaryCurrentAFPDiscountMonthly = value
        }

    private var _salaryCurrentSDSDiscountMonthly : Double = 0.0

    var salaryCurrentSDSDiscountMonthly: Double
        get() = _salaryCurrentSDSDiscountMonthly
        set(value) {
            _salaryCurrentSDSDiscountMonthly = value
        }


    private var _salaryCurrentIRSDiscountMonthly : Double = 0.0

    var salaryCurrentIRSDiscountMonthly: Double
        get() = _salaryCurrentIRSDiscountMonthly
        set(value) {
            _salaryCurrentIRSDiscountMonthly = value
        }

    private var _salaryCurrentAFPDiscountYearly : Double = 0.0

    var salaryCurrentAFPDiscountYearly: Double
        get() = _salaryCurrentAFPDiscountYearly
        set(value) {
            _salaryCurrentAFPDiscountYearly = value
        }

    private var _salaryCurrentSDSDiscountYearly : Double = 0.0

    var salaryCurrentSDSDiscountYearly: Double
        get() = _salaryCurrentSDSDiscountYearly
        set(value) {
            _salaryCurrentSDSDiscountYearly = value
        }

    private var _salaryCurrentIRSDiscountYearly : Double = 0.0

    var salaryCurrentIRSDiscountYearly: Double
        get() = _salaryCurrentIRSDiscountYearly
        set(value) {
            _salaryCurrentIRSDiscountYearly = value
        }

    private var _totalDiscountsPerMonth : Double = 0.0

    var totalDiscountsPerMonth: Double
        get() = _totalDiscountsPerMonth
        set(value) {
            _totalDiscountsPerMonth = value
        }

    private var _totalDiscountsPerYear : Double = 0.0

    var totalDiscountsPerYear: Double
        get() = _totalDiscountsPerYear
        set(value) {
            _totalDiscountsPerYear = value
        }

    /*discounts*/
    private var _afpDiscountPercentage : Double = 0.0287

    var afpDiscountPercentage: Double
        get() = _afpDiscountPercentage
        set(value) {
            _afpDiscountPercentage = value
        }


    private var _sdsDiscountPercentage : Double = 0.0304

    var sdsDiscountPercentage: Double
        get() = _sdsDiscountPercentage
        set(value) {
            _sdsDiscountPercentage = value
        }


    private var _salaryRanges = arrayOf(
        ISRRangesModel(416220.01, 624329.00,0.15,0.00),
        ISRRangesModel(624329.01, 867123.00,0.20,31216.00),
        ISRRangesModel(867123.01,20842780.00, 0.25,79776.00)
    )

    var salaryRanges : Array<ISRRangesModel>
        get() = this._salaryRanges.copyOf()
        set(value) {_salaryRanges=value.copyOf()}

    init{
        //check saved files on default


    }

}