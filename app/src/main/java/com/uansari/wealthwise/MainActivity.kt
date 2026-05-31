package com.uansari.wealthwise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.uansari.wealthwise.theme.WealthWiseTheme
import com.uansari.wealthwise.ui.WealthWiseApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WealthWiseTheme {
                WealthWiseApp()
            }
        }
    }
}