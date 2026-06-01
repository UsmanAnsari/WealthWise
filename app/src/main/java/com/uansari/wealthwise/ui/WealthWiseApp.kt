package com.uansari.wealthwise.ui

import androidx.activity.compose.BackHandler
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.PieChart
import androidx.compose.material.icons.outlined.Explore
import androidx.compose.material.icons.outlined.PieChart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.rememberNavController
import com.uansari.wealthwise.navigation.AppNavDisplay
import com.uansari.wealthwise.navigation.AppTab
import com.uansari.wealthwise.navigation.ExploreHome
import com.uansari.wealthwise.navigation.PortfolioHome

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WealthWiseApp(
    windowSizeClass: WindowSizeClass,
) {

    // Navigation 2 Implementation
    val navController = rememberNavController()

    // Navigation 3 Implementation - Two independent back stacks
    val exploreBackStack = remember { mutableStateListOf<Any>(ExploreHome) }
    val portfolioBackStack = remember { mutableStateListOf<Any>(PortfolioHome) }


    var selectedTab by remember { mutableStateOf(AppTab.Explore) }

    //    val currentBackStack = remember { mutableStateListOf<Any>(ExploreHome) }

    val currentBackStack = when (selectedTab) {
        AppTab.Explore -> exploreBackStack
        AppTab.Portfolio -> portfolioBackStack
    }


    val isExpanded = windowSizeClass.widthSizeClass == WindowWidthSizeClass.Expanded


    BackHandler(enabled = currentBackStack.size > 1) {
        currentBackStack.removeLastOrNull()
    }

    NavigationSuiteScaffold(
        navigationSuiteItems = {

            item(
                selected = selectedTab == AppTab.Explore,
                onClick = {
                    selectedTab = AppTab.Explore

                    /*
                        navController.navigate(ExploreHome) {
                            popUpTo(ExploreHome) {
                                inclusive = true
                            }
                        }
                    */
                },
                icon = {
                    Icon(
                        imageVector = if (selectedTab == AppTab.Explore) Icons.Filled.Explore
                        else Icons.Outlined.Explore, contentDescription = "Explore"
                    )
                },
                label = { Text("Explore") },
            )

            item(
                selected = selectedTab == AppTab.Portfolio,
                onClick = {
                    selectedTab = AppTab.Portfolio

                    /*
                        navController.navigate(PortfolioHome) {
                            popUpTo(PortfolioHome) {
                                inclusive = true
                            }
                        }
                    */

                },
                icon = {
                    Icon(
                        imageVector = if (selectedTab == AppTab.Portfolio) Icons.Filled.PieChart
                        else Icons.Outlined.PieChart, contentDescription = "Portfolio"
                    )
                },
                label = { Text("Portfolio") },
            )
        }) {
//            AppNavHost(navHostController = navController) // Navigation 2

        AppNavDisplay(
            backStack = currentBackStack, isExpanded = isExpanded, windowSizeClass = windowSizeClass
        ) // Navigation 3
    }
}