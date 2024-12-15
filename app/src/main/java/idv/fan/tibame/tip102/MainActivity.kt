package idv.fan.tibame.tip102

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import idv.fan.tibame.tip102.ui.feature.TipAppState
import idv.fan.tibame.tip102.ui.feature.detail.detailScreenRoute
import idv.fan.tibame.tip102.ui.feature.home.HOME_NAVIGATION_ROUTE
import idv.fan.tibame.tip102.ui.feature.home.genHomeNavigationRoute
import idv.fan.tibame.tip102.ui.feature.home.homeScreenRoute
import idv.fan.tibame.tip102.ui.feature.search.genSearchNavigationRoute
import idv.fan.tibame.tip102.ui.feature.search.searchScreenRoute
import idv.fan.tibame.tip102.ui.theme.TipColor
import idv.fan.tibame.tip102.ui.widget.TipBottomBarIcon


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            /**
             * todo 0-0 一切從這裡開始，整個 APP 的起點，帶同學瀏覽整個專案(1) TipApp / Feature / Theme / Widget
             * */
            TipApp()
        }
    }
}

/**
 * todo 1-1 注意：命名前面加上 Tip 是為了避免和其他或原生專案的衝突，無論 Widget / Component 也可以這樣做
 * */
@Composable
fun TipApp(
    navController: NavHostController = rememberNavController(),
    appState: TipAppState = remember { TipAppState(navController) }
) {
    // todo 1-2 先宣告一個完整頁面，包含 BottomBar / NavHost
    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            // todo 1-3 將 NavHost 放在 Scaffold Content 裡
            TipNavHost(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                navController = navController
            )
            // todo 1-4 顯示所有 BottomIcon ，如果目前的路徑是 HOME 或 SEARCH，就顯示 BottomBar
            if (appState.isShowBottomBar) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    appState.tipTopLevelDestinations.forEach {
                        TipBottomBarIcon(
                            modifier = Modifier
                                .weight(1f)
                                .clickable { navController.navigate(it.route) },
                            title = it.iconText,
                            imageVector = it.icon,
                            // todo 1-4 如果目前的路徑是這個 icon 的路徑，就變色
                            isSelected = appState.currentTipTopLevelDestination == it
                        )
                    }
                }
            }
        }


    }
}

// todo 1-6 將 NavHost 放在一個獨立的 Composable 裡
@Composable
fun TipNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    // todo 2-1 這裡是將所有的畫面路徑都列出來
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = HOME_NAVIGATION_ROUTE
    ) {
        // todo 2-2 置入所有的畫面路徑
        homeScreenRoute(navController)
        searchScreenRoute(navController)
        detailScreenRoute(navController)
    }

}