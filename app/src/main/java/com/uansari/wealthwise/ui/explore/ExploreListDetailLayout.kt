package com.uansari.wealthwise.ui.explore

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
import com.uansari.wealthwise.ui.explore.detail.CategoryDetailScreen
import com.uansari.wealthwise.ui.explore.display.ExploreScreen
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun ExploreListDetailLayout(modifier: Modifier = Modifier) {

    val coroutineScope = rememberCoroutineScope()

    var selectedCategoryId by rememberSaveable { mutableStateOf<Int?>(null) }

    val navigator = rememberListDetailPaneScaffoldNavigator<Nothing>()

    ListDetailPaneScaffold(
        directive = navigator.scaffoldDirective,
        value = navigator.scaffoldValue,
        modifier = modifier,
        listPane = {
            AnimatedPane {
                ExploreScreen(
                    onCategoryClick = { id ->
                        selectedCategoryId = id
                        coroutineScope.launch{
                        navigator.navigateTo(ListDetailPaneScaffoldRole.Detail)
                        }
                    }, selectedCategoryId = selectedCategoryId
                )
            }
        },
        detailPane = {
            AnimatedPane {
                if (selectedCategoryId != null) {
                    CategoryDetailScreen(categoryId = selectedCategoryId!!)
                } else {
                    EmptyDetailPane(message = "Select a category to explore")
                }
            }
        })
}
