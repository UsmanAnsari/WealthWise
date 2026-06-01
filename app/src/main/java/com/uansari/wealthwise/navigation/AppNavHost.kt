package com.uansari.wealthwise.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.uansari.wealthwise.ui.explore.detail.CategoryDetailScreen
import com.uansari.wealthwise.ui.explore.display.ExploreScreen
import com.uansari.wealthwise.ui.portfolio.detail.HoldingDetailScreen
import com.uansari.wealthwise.ui.portfolio.display.PortfolioScreen

@Composable
fun AppNavHost(
    navHostController: NavHostController
) {


    NavHost(
        navController = navHostController, startDestination = ExploreHome
    ) {
        composable<ExploreHome> {
            ExploreScreen(onCategoryClick = { categoryId ->
                navHostController.navigate(CategoryDetail(categoryId = categoryId))
            })
        }

        composable<CategoryDetail> { backStackEntry ->
            val args = backStackEntry.toRoute<CategoryDetail>()
            CategoryDetailScreen(categoryId = args.categoryId)
        }

        composable<PortfolioHome> {
            PortfolioScreen(onHoldingClick = { holdingId ->
                navHostController.navigate(route = HoldingDetail(holdingId))
            })
        }

        composable<HoldingDetail> { backStackEntry ->
            val args = backStackEntry.toRoute<HoldingDetail>()
            HoldingDetailScreen(holdingId = args.holdingId)
        }

    }
}