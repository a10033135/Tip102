package idv.fan.tibame.tip102.ui.feature.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

/**
 * 將首頁的路由獨立出來
 * */

val HOME_NAVIGATION_KEY = "home"

fun genHomeNavigationRoute() = HOME_NAVIGATION_KEY

fun NavGraphBuilder.homeScreenRoute() {
    composable(
        route = HOME_NAVIGATION_KEY,
    ) {
        HomeRoute()
    }
}