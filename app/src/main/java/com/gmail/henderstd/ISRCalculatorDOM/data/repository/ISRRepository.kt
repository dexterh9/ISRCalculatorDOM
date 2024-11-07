package com.gmail.henderstd.ISRCalculatorDOM.data.repository

import com.gmail.henderstd.ISRCalculatorDOM.data.model.ISRRangesModel

class ISRRepository {

    /*discounts*/
    private var _afpDiscountPercentage : Double = 0.0287
        get()=field
        set(value){field = value};

    private var _sdsDiscountPercentage : Double = 0.0304
        get()=field
        set(value){field = value};

    private var _salaryRanges = arrayOf(
        ISRRangesModel(416220.01, 624329.00,0.15),
        ISRRangesModel(624329.01, 867123.00,0.20),
        ISRRangesModel(867123.01,20842780.00, 0.25)
    )

    var salaryRanges : Array<ISRRangesModel>
        get() = this._salaryRanges.copyOf()
        set(value) {_salaryRanges=value.copyOf()};

    init{
        //check saved files on default

    }

}