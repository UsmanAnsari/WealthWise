package com.uansari.wealthwise.navigation


data object ExploreHome

data class CategoryDetail(val categoryId: Int)

data object PortfolioHome

data class HoldingDetail(val holdingId: Int)

enum class AppTab { Explore, Portfolio }