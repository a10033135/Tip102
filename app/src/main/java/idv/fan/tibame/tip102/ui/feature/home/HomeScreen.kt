package idv.fan.tibame.tip102.ui.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import idv.fan.tibame.tip102.ui.feature.detail.genDetailNavigationRoute
import idv.fan.tibame.tip102.ui.theme.TipColor
import idv.fan.tibame.tip102.ui.widget.TipHomeItem
import idv.fan.tibame.tip102.ui.widget.TipHomeItemUiState

/**
 * todo 2-2 將首頁的畫面獨立出來
 * 將每個頁面拆分成三個區塊
 * (1) HomeRoute 使用 ViewModel 的資料，此為 NavigationController 導向的起始點
 * (2) HomeScreen 實際畫面，將參數抽出來，方便 Preview
 * (3) PreviewHomeScreen 預覽畫面（不透過 ViewModel 預覽畫面）
 * */

@Composable
fun HomeRoute(
    homeViewModel: HomeViewModel = viewModel(),
    navController: NavHostController
) {
    val items by homeViewModel.items.collectAsState()

    HomeScreen(
        items = items,
        onDetailClick = { title ->
            navController.navigate(genDetailNavigationRoute(title))
        },
        onGetApiClick = homeViewModel::getApiData,
    )
}

@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}

@Composable
fun HomeScreen(
    items: List<TipHomeItemUiState> = listOf(),
    onGetApiClick: () -> Unit = {},
    onDetailClick: (String) -> Unit = {}
) {
    Column {
        Text(
            modifier = Modifier
                .background(TipColor.Pink40)
                .padding(12.dp)
                .clickable(onClick = onGetApiClick),
            text = "取得資料"
        )

        items.forEach { item ->
            TipHomeItem(
                modifier = Modifier.clickable(onClick = { onDetailClick.invoke(item.title) }),
                uiState = item
            )
        }

    }
}