package com.uansari.wealthwise.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.PieChart
import androidx.compose.material.icons.outlined.Explore
import androidx.compose.material.icons.outlined.PieChart
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.uansari.wealthwise.navigation.AppNavDisplay
import com.uansari.wealthwise.navigation.AppTab
import com.uansari.wealthwise.navigation.ExploreHome
import com.uansari.wealthwise.navigation.PortfolioHome

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WealthWiseApp() {

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



    BackHandler(enabled = currentBackStack.size > 1) {
        currentBackStack.removeLastOrNull()
    }


    Scaffold(topBar = { CenterAlignedTopAppBar({ Text("WealthWise") }) }, bottomBar = {
        NavigationBar {
            NavigationBarItem(selected = selectedTab == AppTab.Explore, onClick = {
                selectedTab = AppTab.Explore

                /*
                                navController.navigate(ExploreHome) {
                                    popUpTo(ExploreHome) {
                                        inclusive = true
                                    }
                                }
                */
            }, icon = {
                Icon(
                    imageVector = if (selectedTab == AppTab.Explore) Icons.Filled.Explore
                    else Icons.Outlined.Explore, contentDescription = "Explore"
                )
            }, label = { Text("Explore") })
            NavigationBarItem(selected = selectedTab == AppTab.Portfolio, onClick = {
                selectedTab = AppTab.Portfolio

                /*
                                navController.navigate(PortfolioHome) {
                                    popUpTo(PortfolioHome) {
                                        inclusive = true
                                    }
                                }
                */

            }, icon = {
                Icon(
                    imageVector = if (selectedTab == AppTab.Portfolio) Icons.Filled.PieChart
                    else Icons.Outlined.PieChart, contentDescription = "Portfolio"
                )
            }, label = { Text("Portfolio") })
        }

    }) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {

//            AppNavHost(navHostController = navController) // Navigation 2

            AppNavDisplay(currentBackStack) // Navigation 3

        }
    }
}