package com.uansari.wealthwise.model

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class InvestmentCategory(
    val id: Int,
    val name: String,
    val tagline: String,
    val description: String,
    val icon: ImageVector,
    val returnRate: String,
    val riskLevel: InvestmentRiskLevel,
    val riskColor: Color,
    val items: List<String>
)
