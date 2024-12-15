package idv.fan.tibame.tip102

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
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
import idv.fan.tibame.tip102.ui.widget.TipBottomBarIcon


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            /**
             * todo 0-0 一切從這裡開始，整個 APP 的起點
             * */
            TipApp()
        }
    }
}

/**
 * todo 1-1 將 BottomBar 的 icon 宣告出來
 * 列出 BottomBar 會出現的 icon
 * @param icon icon
 * @param iconText icon下方的文字
 * @param route 點擊後要導向的路徑/畫面
 * */
enum class TipTopLevelDestination(
    val icon: ImageVector,
    val iconText: String,
    val route: String
) {
    HOME(
        icon = Icons.Filled.Home,
        iconText = "首頁",
        route = genHomeNavigationRoute()
    ),
    SEARCH(
        icon = Icons.Filled.Search,
        iconText = "搜尋",
        route = genSearchNavigationRoute()
    ),
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
        bottomBar = {

            // todo 1-3 如果目前的路徑是 HOME 或 SEARCH，就顯示 BottomBar
            if (appState.isShowBottomBar) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    // todo 1-4 將 BottomBar 的 icon 顯示出來
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
    ) { innerPadding ->

        // todo 1-5 將 NavHost 放在 Scaffold Content 裡
        TipNavHost(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            navController = navController
        )
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