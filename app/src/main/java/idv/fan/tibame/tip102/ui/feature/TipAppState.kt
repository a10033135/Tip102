package idv.fan.tibame.tip102.ui.feature

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import idv.fan.tibame.tip102.ui.feature.home.HOME_NAVIGATION_KEY
import idv.fan.tibame.tip102.ui.feature.home.genHomeNavigationRoute
import idv.fan.tibame.tip102.ui.feature.search.SEARCH_NAVIGATION_KEY
import idv.fan.tibame.tip102.ui.feature.search.genSearchNavigationRoute

/**
 * 列出 BottomBar 會出現的 icon
 * @param icon icon
 * @param iconText icon下方的文字
 * @param route 點擊後要導向的路徑/畫面
 * */
enum class TopLevelDestination(
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


@Stable
class TipAppState(
    val navController: NavHostController
) {

    val topLevelDestination: List<TopLevelDestination> = TopLevelDestination.entries

    private val currentDestination: String?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination?.route

    val currentTopLevelDestination: TopLevelDestination?
        @Composable get() {
            return getTopLevelDestination(currentDestination)
        }

    private fun getTopLevelDestination(route: String?): TopLevelDestination? {
        return when (route) {
            HOME_NAVIGATION_KEY -> TopLevelDestination.HOME
            SEARCH_NAVIGATION_KEY -> TopLevelDestination.SEARCH
            else -> null
        }
    }

    val isShowBottomBar: Boolean
        @Composable get() {
            return when (currentDestination) {
                HOME_NAVIGATION_KEY -> true
                else -> false
            }
        }


}