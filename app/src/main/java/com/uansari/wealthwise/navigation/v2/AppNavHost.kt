package com.uansari.wealthwise.navigation.v2

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.uansari.wealthwise.ui.explore.ExploreListDetailLayout
import com.uansari.wealthwise.ui.explore.detail.CategoryDetailScreen
import com.uansari.wealthwise.ui.explore.display.ExploreScreen
import com.uansari.wealthwise.ui.portfolio.PortfolioListDetailLayout
import com.uansari.wealthwise.ui.portfolio.detail.HoldingDetailScreen
import com.uansari.wealthwise.ui.portfolio.display.PortfolioScreen

@Composable
fun AppNavHost(
    navHostController: NavHostController, isExpanded: Boolean, windowSizeClass: WindowSizeClass
) {


    NavHost(
        navController = navHostController, startDestination = ExploreHome
    ) {
        composable<ExploreHome> {
            if (isExpanded) {
                ExploreListDetailLayout()
            } else {
                ExploreScreen(onCategoryClick = { categoryId ->
                    navHostController.navigate(CategoryDetail(categoryId = categoryId))
                })
            }
        }

        composable<CategoryDetail> { backStackEntry ->
            val args = backStackEntry.toRoute<CategoryDetail>()
            CategoryDetailScreen(categoryId = args.categoryId)
        }

        composable<PortfolioHome> {
            if (isExpanded) {
                PortfolioListDetailLayout()
            } else {
                PortfolioScreen(onHoldingClick = { holdingId ->
                    navHostController.navigate(route = HoldingDetail(holdingId))
                })
            }
        }

        composable<HoldingDetail> { backStackEntry ->
            val args = backStackEntry.toRoute<HoldingDetail>()
            HoldingDetailScreen(holdingId = args.holdingId)
        }

    }
}