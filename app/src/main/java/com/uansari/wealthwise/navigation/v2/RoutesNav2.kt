package com.uansari.wealthwise.navigation.v2

import kotlinx.serialization.Serializable


@Serializable
object ExploreHome

@Serializable
data class CategoryDetail(val categoryId: Int)

@Serializable
object PortfolioHome

@Serializable
data class HoldingDetail(val holdingId: Int)