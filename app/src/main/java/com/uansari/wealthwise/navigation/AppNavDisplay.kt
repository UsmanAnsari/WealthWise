package com.uansari.wealthwise.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.uansari.wealthwise.ui.explore.detail.CategoryDetailScreen
import com.uansari.wealthwise.ui.explore.display.ExploreScreen
import com.uansari.wealthwise.ui.portfolio.detail.HoldingDetailScreen
import com.uansari.wealthwise.ui.portfolio.display.PortfolioScreen

@Composable
fun AppNavDisplay(
    backStack: SnapshotStateList<Any>,
) {
    NavDisplay(
        backStack = backStack, entryProvider = entryProvider {

            entry<ExploreHome> {
                ExploreScreen(
                    onCategoryClick = { id ->
                        backStack.add(CategoryDetail(categoryId = id))
                    })
            }

            entry<CategoryDetail> { entry ->
                CategoryDetailScreen(
                    categoryId = entry.categoryId
                )
            }

            entry<PortfolioHome> {
                PortfolioScreen(
                    onHoldingClick = { id ->
                        backStack.add(HoldingDetail(holdingId = id))
                    })
            }

            entry<HoldingDetail> { entry ->
                HoldingDetailScreen(
                    holdingId = entry.holdingId
                )
            }
        })
}