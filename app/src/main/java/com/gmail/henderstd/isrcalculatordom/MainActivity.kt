package com.gmail.henderstd.isrcalculatordom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gmail.henderstd.isrcalculatordom.presentation.view.ISRCalculatorView
import com.gmail.henderstd.isrcalculatordom.presentation.viewmodel.ISRCalculatorDOMViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            
            val viewModel : ISRCalculatorDOMViewModel =viewModel()
            ISRCalculatorView(viewModel)
        }
    }
}



// Composable function to separate content setup
@Composable
fun MainActivityContent() {
    val viewModel: ISRCalculatorDOMViewModel = viewModel()
    ISRCalculatorView(viewModel)
}

// Mock ViewModel for preview
class MockCalculatorViewModel : ISRCalculatorDOMViewModel() {
    init {
        performCalculation(10.0) // Simulate default result
    }
}

// Preview inside MainActivity file
@Preview(showBackground = true)
@Composable
fun MainActivityPreview() {
    val mockViewModel = MockCalculatorViewModel()
    ISRCalculatorView(mockViewModel)
}
