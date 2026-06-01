package com.uansari.wealthwise.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.uansari.wealthwise.model.Holding

@Composable
fun HoldingItem(
    holding: Holding,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
) {
    ListItem(
        modifier = modifier
            .clickable(onClick = onClick)
            .then(
                if (isSelected) Modifier.background(MaterialTheme.colorScheme.surfaceVariant)
                else Modifier
            ), headlineContent = {
        Text(text = holding.name, fontWeight = FontWeight.SemiBold)
    }, supportingContent = {
        Text(
            text = "${holding.shares} shares · £%.2f".format(holding.currentPrice),
            style = MaterialTheme.typography.bodySmall
        )
    }, leadingContent = {
        Surface(
            shape = CircleShape,
            color = MaterialTheme.colorScheme.secondaryContainer,
            modifier = Modifier.size(44.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text(
                    text = holding.ticker,
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )
            }
        }
    }, trailingContent = {
        Column(horizontalAlignment = Alignment.End) {
            Text(
                text = "£%.2f".format(holding.totalValue),
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "%+.1f%%".format(holding.gainLossPercent),
                style = MaterialTheme.typography.labelSmall,
                color = if (holding.isProfit) MaterialTheme.colorScheme.primary
                else MaterialTheme.colorScheme.error
            )
        }
    })
}