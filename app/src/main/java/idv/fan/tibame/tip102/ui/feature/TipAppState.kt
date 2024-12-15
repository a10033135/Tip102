package idv.fan.tibame.tip102.ui.feature

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import idv.fan.tibame.tip102.TipTopLevelDestination
import idv.fan.tibame.tip102.ui.feature.detail.DETAIL_NAVIGATION_ROUTE
import idv.fan.tibame.tip102.ui.feature.home.HOME_NAVIGATION_ROUTE
import idv.fan.tibame.tip102.ui.feature.search.SEARCH_NAVIGATION_ROUTE


/**
 * todo 1-3 宣告 AppState 是處理 NavHostController 的類別
 * */
@Stable
class TipAppState(
    val navController: NavHostController
) {

    /**
     * 這裡是將所有的 TopLevelDestination( BottomBar 裡的 icon ) 都列出來
     * */
    val tipTopLevelDestinations: List<TipTopLevelDestination> = TipTopLevelDestination.entries

    /**
     * 取得當前的路徑
     * */
    private val currentDestination: String?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination?.route


    /**
     * 將當前的路徑轉換成 TopLevelDestination （屬於哪個 BottomBar 分類）
     * */
    val currentTipTopLevelDestination: TipTopLevelDestination?
        @Composable get() {
            return getTopLevelDestination(currentDestination)
        }

    /**
     * 將每個路徑做區分，
     * 例如： HOME / DETAIL 都屬於 HOME 分類，而 SEARCH 屬於 SEARCH 分類
     * */
    private fun getTopLevelDestination(route: String?): TipTopLevelDestination? {
        return when (route) {
            HOME_NAVIGATION_ROUTE, DETAIL_NAVIGATION_ROUTE -> TipTopLevelDestination.HOME
            SEARCH_NAVIGATION_ROUTE -> TipTopLevelDestination.SEARCH
            else -> null
        }
    }

    /**
     * 根據目前的路徑，判斷是否顯示 BottomBar
     * */
    val isShowBottomBar: Boolean
        @Composable get() {
            return when (currentDestination) {
                HOME_NAVIGATION_ROUTE, SEARCH_NAVIGATION_ROUTE -> true
                DETAIL_NAVIGATION_ROUTE -> false
                else -> false
            }
        }


}