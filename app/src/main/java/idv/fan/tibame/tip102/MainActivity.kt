package idv.fan.tibame.tip102

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import idv.fan.tibame.tip102.ui.feature.TipAppState
import idv.fan.tibame.tip102.ui.feature.home.HOME_NAVIGATION_KEY
import idv.fan.tibame.tip102.ui.feature.home.genHomeNavigationRoute
import idv.fan.tibame.tip102.ui.feature.home.homeScreenRoute
import idv.fan.tibame.tip102.ui.feature.search.genSearchNavigationRoute
import idv.fan.tibame.tip102.ui.feature.search.searchScreenRoute
import idv.fan.tibame.tip102.ui.theme.Tip102Theme
import idv.fan.tibame.tip102.ui.widget.TipBottomBarIcon

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TipApp()
        }
    }
}

@Composable
fun TipApp(
    navController: NavHostController = rememberNavController(),
    appState: TipAppState = remember { TipAppState(navController) }
) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                appState.topLevelDestination.forEach {
                    TipBottomBarIcon(
                        modifier = Modifier
                            .weight(1f)
                            .clickable { navController.navigate(it.route) },
                        title = it.iconText,
                        imageVector = it.icon,
                        isSelected = appState.currentTopLevelDestination == it
                    )
                }
            }
        }
    ) { innerPadding ->
        TipNavHost(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            navController = navController
        )
    }
}


@Composable
fun TipNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        modifier = modifier, navController = navController, startDestination = HOME_NAVIGATION_KEY
    ) {
        homeScreenRoute()
        searchScreenRoute()
    }

}