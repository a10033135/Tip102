package idv.fan.tibame.tip102.ui.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class TipHomeItemUiState(
    val title: String,
    val imageVector: ImageVector
)

/**
 * todo 2-2 刻出首頁需要的畫面
 * */
@Preview
@Composable
fun PreviewTipHomeItem() {
    Column {
        TipHomeItem(
            uiState = TipHomeItemUiState(
                title = "Home",
                imageVector = Icons.Filled.Search
            )
        )
    }
}

// todo 注意：Modifier 是為了讓外部可以設定這個元件的樣式
@Composable
fun TipHomeItem(
    modifier: Modifier = Modifier,
    uiState: TipHomeItemUiState
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Image(
            modifier = Modifier.size(60.dp),
            imageVector = uiState.imageVector,
            contentDescription = null,
        )

        Text(
            modifier = Modifier.align(Alignment.CenterVertically),
            text = uiState.title,
            fontSize = 40.sp
        )

    }

}