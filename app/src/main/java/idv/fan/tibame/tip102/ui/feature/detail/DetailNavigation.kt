package idv.fan.tibame.tip102.ui.feature.detail

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

val DETAIL_NAVIGATION_KEY = "detail"

fun genDetailNavigationRoute() = DETAIL_NAVIGATION_KEY

fun NavGraphBuilder.detailScreenRoute() {
    composable(
        route = DETAIL_NAVIGATION_KEY,
    ) {
        DetailScreen()
    }
}