package com.gmail.henderstd.ISRCalculatorDOM.data.repository

import com.gmail.henderstd.ISRCalculatorDOM.data.model.ISRRangesModel

class SalaryDiscountsRepository {

    /*user salary, current discounts per period*/
    private var _salary : Double = 0.0
        get() = field
        set(value) {field = value};

    private var _salaryCurrentAFPDiscountMonthly : Double = 0.0
        get() = field
        set(value) {field = value};

    private var _salaryCurrentSDSDiscountMonthly : Double = 0.0
        get() = field
        set(value) {field = value};

    private var _salaryCurrentIRSDiscountMonthly : Double = 0.0
        get() = field
        set(value) {field = value};

    private var _salaryCurrentAFPDiscountYearly : Double = 0.0
        get() = field
        set(value) {field = value};

    private var _salaryCurrentSDSDiscountYearly : Double = 0.0
        get() = field
        set(value) {field = value};

    private var _salaryCurrentIRSDiscountYearly : Double = 0.0
        get() = field
        set(value) {field = value};

    private var _totalDiscountsPerMonth : Double = 0.0
        get() = field
        set(value) {field = value};

    private var _totalDiscountsPerYear : Double = 0.0
        get() = field
        set(value) {field = value};

    /*discounts*/
    private var _afpDiscountPercentage : Double = 0.0287
        get()=field
        set(value){field = value};

    private var _sdsDiscountPercentage : Double = 0.0304
        get()=field
        set(value){field = value};

    private var _salaryRanges = arrayOf(
        ISRRangesModel(416220.01, 624329.00,0.15,0.00),
        ISRRangesModel(624329.01, 867123.00,0.20,31216.00),
        ISRRangesModel(867123.01,20842780.00, 0.25,79776.00)
    )

    var salaryRanges : Array<ISRRangesModel>
        get() = this._salaryRanges.copyOf()
        set(value) {_salaryRanges=value.copyOf()};

    init{
        //check saved files on default

    }

}