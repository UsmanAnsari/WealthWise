package com.uansari.wealthwise.ui.explore.display

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.uansari.wealthwise.data.SampleData
import com.uansari.wealthwise.ui.components.CategoryCard

@Composable
fun ExploreScreen(
    modifier: Modifier = Modifier,
    onCategoryClick: (Int) -> Unit,
    selectedCategoryId: Int? = null,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        contentPadding = PaddingValues(vertical = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item(span = { GridItemSpan(2) }) {
            Text(
                text = "Explore",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 28.dp, bottom = 4.dp)
            )
        }
        items(SampleData.categories) { category ->
            CategoryCard(
                category = category,
                onClick = { onCategoryClick(category.id) },
                isSelected = category.id == selectedCategoryId
            )
        }
    }
}