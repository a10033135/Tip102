package idv.fan.tibame.tip102.ui.feature.detail

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

val DETAIL_NAVIGATION_ROUTE = "detail?title={title}"

fun genDetailNavigationRoute(title: String): String {
    return "detail?title=$title"
}

fun NavGraphBuilder.detailScreenRoute(navController: NavHostController) {
    composable(
        route = DETAIL_NAVIGATION_ROUTE,
        arguments = listOf(
            navArgument("title") { type = androidx.navigation.NavType.StringType }
        )
    ) {
        val title = it.arguments?.getString("title") ?: ""
        DetailRoute(title = title, navController = navController)
    }
}