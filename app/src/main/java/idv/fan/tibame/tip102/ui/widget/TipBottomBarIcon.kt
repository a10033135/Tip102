package idv.fan.tibame.tip102.ui.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import idv.fan.tibame.tip102.ui.theme.TipColor

@Preview
@Composable
fun PreviewTipBottomBarIcon() {
    Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        TipBottomBarIcon(title = "Home", imageVector = Icons.Filled.Home)
        TipBottomBarIcon(title = "Search", imageVector = Icons.Filled.Search)

    }
}

@Composable
fun TipBottomBarIcon(
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    title: String,
    imageVector: ImageVector
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            imageVector = imageVector,
            contentDescription = title,
            colorFilter = ColorFilter.tint(
                color = if (isSelected) TipColor.Pink80 else TipColor.Pink40
            )
        )
        Text(
            fontSize = 16.sp,
            text = title,
            color = if (isSelected) TipColor.Pink80 else TipColor.Pink40
        )
    }

}