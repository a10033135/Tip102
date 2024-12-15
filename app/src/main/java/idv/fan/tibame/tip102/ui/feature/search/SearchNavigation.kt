package idv.fan.tibame.tip102.ui.feature.search

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

val SEARCH_NAVIGATION_ROUTE = "search"

fun genSearchNavigationRoute() = SEARCH_NAVIGATION_ROUTE

fun NavGraphBuilder.searchScreenRoute(navController: NavHostController) {
    composable(
        route = SEARCH_NAVIGATION_ROUTE,
    ) {
        SearchRoute(navController = navController)
    }
}