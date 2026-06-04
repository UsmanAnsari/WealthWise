package com.uansari.wealthwise.navigation.v3

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.uansari.wealthwise.ui.explore.ExploreListDetailLayout
import com.uansari.wealthwise.ui.explore.detail.CategoryDetailScreen
import com.uansari.wealthwise.ui.explore.display.ExploreScreen
import com.uansari.wealthwise.ui.portfolio.PortfolioListDetailLayout
import com.uansari.wealthwise.ui.portfolio.detail.HoldingDetailScreen
import com.uansari.wealthwise.ui.portfolio.display.PortfolioScreen

@Composable
fun AppNavDisplay(
    backStack: SnapshotStateList<Any>, isExpanded: Boolean, windowSizeClass: WindowSizeClass
) {
    NavDisplay(
        backStack = backStack, entryProvider = entryProvider {

            entry<ExploreHome> {
                if (isExpanded) {
                    ExploreListDetailLayout()
                } else {
                    ExploreScreen(
                        onCategoryClick = { id -> backStack.add(CategoryDetail(categoryId = id)) },
                    )
                }
            }

            entry<CategoryDetail> { entry ->
                CategoryDetailScreen(
                    categoryId = entry.categoryId
                )
            }

            entry<PortfolioHome> {
                if (isExpanded) {
                    PortfolioListDetailLayout()
                } else {
                    PortfolioScreen(
                        onHoldingClick = { id ->
                            backStack.add(HoldingDetail(holdingId = id))
                        }
                    )
                }
            }

            entry<HoldingDetail> { entry ->
                HoldingDetailScreen(
                    holdingId = entry.holdingId
                )
            }
        })
}