package idv.fan.tibame.tip102.ui.feature.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

/**
 * todo 2-1 將首頁的路由獨立出來
 * */

val HOME_NAVIGATION_ROUTE = "home"

fun genHomeNavigationRoute() = HOME_NAVIGATION_ROUTE

fun NavGraphBuilder.homeScreenRoute(navController: NavHostController) {
    composable(
        route = HOME_NAVIGATION_ROUTE,
    ) {
        HomeRoute(navController = navController)
    }
}