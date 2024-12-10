package com.gmail.henderstd.isrcalculatordom.presentation.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import com.gmail.henderstd.isrcalculatordom.presentation.viewmodel.ISRCalculatorDOMViewModel

@Composable
fun ISRCalculatorView(viewmodel: ISRCalculatorDOMViewModel) {
    var salary by remember { mutableStateOf("") }
    var afpMonthly by remember { mutableDoubleStateOf(0.00) }
    var sdsMonthly by remember { mutableDoubleStateOf(0.00) }
    var irsMonthly by remember { mutableDoubleStateOf(0.00) }



    Column (
        modifier=Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TextField(value = salary,
            onValueChange = {it ->
            if(it.isNotEmpty() && it.isDigitsOnly()){
                salary=it;
                viewmodel.performCalculation(it.trim().toDouble())
                afpMonthly=viewmodel.getSalaryCurrentAFPDiscountMonthly()
                sdsMonthly=viewmodel.getSalaryCurrentSDSDiscountMonthly()
                irsMonthly=viewmodel.getSalaryCurrentIRSDiscountMonthly()

            }else{
                salary=it
                viewmodel.performCalculation(0.00)

            }
        },
            label={ Text("Salario") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        )

        TextField(value = afpMonthly.toString(),
            onValueChange = { },
            label={ Text("AFP Deducción Mensual") },
            enabled = false,
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        )

        TextField(value = sdsMonthly.toString(),
            onValueChange = { },
            label={ Text("SDS Deducción Mensual") },
            enabled = false,
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        )

        TextField(value = irsMonthly.toString(),
            onValueChange = { },
            label={ Text("IRS Deducción Mensual") },
            enabled = false,
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        )


    }



}