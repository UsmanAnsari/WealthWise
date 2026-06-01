package com.uansari.wealthwise.model

import androidx.compose.ui.graphics.vector.ImageVector

data class Holding(
    val id: Int,
    val ticker: String,
    val name: String,
    val shares: Double,
    val currentPrice: Double,
    val purchasePrice: Double,
    val icon: ImageVector
) {
    val totalValue get() = shares * currentPrice
    val totalCost get() = shares * purchasePrice
    val gainLoss get() = totalValue - totalCost
    val gainLossPercent get() = (gainLoss / totalCost) * 100
    val isProfit get() = gainLoss >= 0
}
