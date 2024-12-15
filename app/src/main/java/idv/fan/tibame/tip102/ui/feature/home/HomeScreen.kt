package idv.fan.tibame.tip102.ui.feature.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController

/**
 * 將每個頁面拆分成三個區塊
 * (1) HomeRoute 使用 ViewModel 的資料，此為 NavigationController 導向的起始點
 * (2) PreviewHomeScreen 預覽畫面（不透過 ViewModel 預覽畫面）
 * (3) HomeScreen 實際畫面(將參數抽出來）
 * */

@Composable
fun HomeRoute(
    homeViewModel: HomeViewModel = viewModel()
) {
    HomeScreen()
}

@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}

@Composable
fun HomeScreen() {
    Column {
        Text(text = "Home")

    }
}