package com.uansari.wealthwise.navigation

import kotlinx.serialization.Serializable

@Serializable
object ExploreHome

@Serializable
data class CategoryDetail(val categoryId: Int)

@Serializable
object PortfolioHome

@Serializable
data class HoldingDetail(val holdingId: Int)

enum class AppTab { Explore, Portfolio }
