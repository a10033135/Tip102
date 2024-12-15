package idv.fan.tibame.tip102.ui.feature.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController

@Composable
fun DetailRoute(
    title: String,
    navController: NavHostController
) {
    DetailScreen(title = title)
}

@Preview
@Composable
fun PreviewDetailScreen() {
    DetailScreen(title = "Detail")
}

@Composable
fun DetailScreen(title: String) {
    Scaffold { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {

            Text(
                text = title,
            )

        }


    }

}