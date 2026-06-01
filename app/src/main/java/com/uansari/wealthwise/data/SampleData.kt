package com.uansari.wealthwise.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.TrendingUp
import androidx.compose.material.icons.outlined.AccountBalance
import androidx.compose.material.icons.outlined.BarChart
import androidx.compose.material.icons.outlined.Computer
import androidx.compose.material.icons.outlined.CurrencyBitcoin
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.PhoneIphone
import androidx.compose.ui.graphics.Color
import com.uansari.wealthwise.model.Holding
import com.uansari.wealthwise.model.InvestmentCategory
import com.uansari.wealthwise.model.InvestmentRiskLevel

object SampleData {

    val categories = listOf(
        InvestmentCategory(
            id = 1,
            name = "ETFs",
            tagline = "Diversified, low-cost index funds",
            description = "Exchange-traded funds track an index or sector, giving you broad market exposure in a single trade. Ideal for long-term, passive investors seeking diversification without stock-picking.",
            icon = Icons.Outlined.BarChart,
            returnRate = "Avg. 10.2% p.a.",
            riskLevel = InvestmentRiskLevel.LOW,
            riskColor = Color(0xFF4CAF50),
            items = listOf(
                "Vanguard S&P 500 ETF", "iShares FTSE 100", "SPDR MSCI World", "Invesco QQQ Trust"
            )
        ),
        InvestmentCategory(
            id = 2,
            name = "Stocks",
            tagline = "Own a piece of the world's best companies",
            description = "Individual equities offer direct ownership in a company. Higher potential returns come with higher volatility. Suitable for investors who want targeted exposure to specific businesses.",
            icon = Icons.AutoMirrored.Outlined.TrendingUp,
            returnRate = "Avg. 12.5% p.a.",
            riskLevel = InvestmentRiskLevel.MEDIUM,
            riskColor = Color(0xFFFFC107),
            items = listOf("Apple (AAPL)", "Microsoft (MSFT)", "Nvidia (NVDA)", "Amazon (AMZN)")
        ),
        InvestmentCategory(
            id = 3,
            name = "Bonds",
            tagline = "Stable, predictable income",
            description = "Fixed-income securities pay regular interest and return principal at maturity. Lower returns than equities but provide portfolio stability and income, especially valuable in volatile markets.",
            icon = Icons.Outlined.AccountBalance,
            returnRate = "Avg. 4.1% p.a.",
            riskLevel = InvestmentRiskLevel.LOW,
            riskColor = Color(0xFF4CAF50),
            items = listOf(
                "UK Gilts", "US Treasury 10Y", "Corporate Bond Fund", "Inflation-Linked Bonds"
            )
        ),
        InvestmentCategory(
            id = 4,
            name = "Crypto",
            tagline = "High risk, high reward digital assets",
            description = "Cryptocurrency assets are highly volatile and speculative. While they offer potential for significant gains, they can lose substantial value quickly. Only invest what you can afford to lose.",
            icon = Icons.Outlined.CurrencyBitcoin,
            returnRate = "Variable",
            riskLevel = InvestmentRiskLevel.HIGH,
            riskColor = Color(0xFFF44336),
            items = listOf("Bitcoin (BTC)", "Ethereum (ETH)", "Solana (SOL)", "Chainlink (LINK)")
        ),
        InvestmentCategory(
            id = 5,
            name = "Real Estate",
            tagline = "Property exposure without the mortgage",
            description = "Real Estate Investment Trusts (REITs) allow you to invest in property portfolios that generate rental income. Provides inflation protection and portfolio diversification with regular dividends.",
            icon = Icons.Outlined.Home,
            returnRate = "Avg. 7.8% p.a.",
            riskLevel = InvestmentRiskLevel.MEDIUM,
            riskColor = Color(0xFFFFC107),
            items = listOf("Segro REIT", "Land Securities", "British Land", "LondonMetric Property")
        ),
    )

    val holdings = listOf(
        Holding(
            id = 1,
            ticker = "VUSA",
            name = "Vanguard S&P 500 ETF",
            shares = 12.0,
            currentPrice = 98.45,
            purchasePrice = 82.10,
            icon = Icons.Outlined.BarChart
        ),
        Holding(
            id = 2,
            ticker = "AAPL",
            name = "Apple Inc.",
            shares = 5.0,
            currentPrice = 189.30,
            purchasePrice = 145.00,
            icon = Icons.Outlined.PhoneIphone
        ),
        Holding(
            id = 3,
            ticker = "MSFT",
            name = "Microsoft Corp.",
            shares = 3.0,
            currentPrice = 415.20,
            purchasePrice = 380.00,
            icon = Icons.Outlined.Computer
        ),
        Holding(
            id = 4,
            ticker = "BTC",
            name = "Bitcoin",
            shares = 0.15,
            currentPrice = 62400.00,
            purchasePrice = 45000.00,
            icon = Icons.Outlined.CurrencyBitcoin
        ),
        Holding(
            id = 5,
            ticker = "SGRO",
            name = "Segro REIT",
            shares = 20.0,
            currentPrice = 8.92,
            purchasePrice = 9.45,
            icon = Icons.Outlined.Home
        ),
    )

    val totalPortfolioValue get() = holdings.sumOf { it.totalValue }
    val totalPortfolioCost get() = holdings.sumOf { it.totalCost }
    val totalGainLoss get() = totalPortfolioValue - totalPortfolioCost
    val totalGainLossPercent get() = (totalGainLoss / totalPortfolioCost) * 100
}