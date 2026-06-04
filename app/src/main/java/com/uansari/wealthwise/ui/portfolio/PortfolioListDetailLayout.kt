package com.uansari.wealthwise.ui.portfolio

import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.layout.AnimatedPane
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffold
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffoldRole
import androidx.compose.material3.adaptive.navigation.rememberListDetailPaneScaffoldNavigator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.uansari.wealthwise.ui.components.EmptyDetailPane
import com.uansari.wealthwise.ui.portfolio.detail.HoldingDetailScreen
import com.uansari.wealthwise.ui.portfolio.display.PortfolioScreen
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun PortfolioListDetailLayout(modifier: Modifier = Modifier) {

    val coroutineScope = rememberCoroutineScope()

    var selectedHoldingId by rememberSaveable { mutableStateOf<Int?>(null) }

    val navigator = rememberListDetailPaneScaffoldNavigator<Nothing>()

    ListDetailPaneScaffold(
        directive = navigator.scaffoldDirective,
        value = navigator.scaffoldValue,
        modifier = modifier,
        listPane = {
            AnimatedPane {
                PortfolioScreen(
                    onHoldingClick = { id ->
                        selectedHoldingId = id
                        coroutineScope.launch {
                            navigator.navigateTo(ListDetailPaneScaffoldRole.Detail)
                        }
                    },
                    selectedHoldingId = selectedHoldingId
                )
            }
        },
        detailPane = {
            AnimatedPane {
                if (selectedHoldingId != null) {
                    HoldingDetailScreen(holdingId = selectedHoldingId!!)
                } else {
                    EmptyDetailPane(message = "Select a holding to view details")
                }
            }
        }
    )
}