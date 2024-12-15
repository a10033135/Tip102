package idv.fan.tibame.tip102.ui.feature.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.lifecycle.ViewModel
import idv.fan.tibame.tip102.ui.widget.TipHomeItemUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


// todo 2-3 宣告 HomeViewModel
class HomeViewModel : ViewModel() {

    private val _items = MutableStateFlow<List<TipHomeItemUiState>>(listOf())
    val items = _items.asStateFlow()


    fun getApiData() {
        // todo 2-5 取得 API 資料，目前先用假資料
        _items.update {
            listOf(
                TipHomeItemUiState(
                    title = "Home",
                    imageVector = Icons.Filled.Home
                ),
                TipHomeItemUiState(
                    title = "Search",
                    imageVector = Icons.Filled.Search
                ),
                TipHomeItemUiState(
                    title = "Delete",
                    imageVector = Icons.Filled.Delete
                ),
            )
        }
    }


}