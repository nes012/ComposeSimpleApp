package anzhy.dizi.composesimpleapp.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import anzhy.dizi.composesimpleapp.network.service.model.RoverPhotoUiState
import anzhy.dizi.composesimpleapp.ui.photolist.MarsRoverPhotoViewModel

@Composable
fun PhotoScreen(
    modifier: Modifier,
    roverName: String?,
    sol: String?,
    marsRoverPhotoViewModel: MarsRoverPhotoViewModel
) {
    val viewState by marsRoverPhotoViewModel.roverPhotoUiState.collectAsStateWithLifecycle()

    if (roverName != null && sol != null) {
        LaunchedEffect(Unit) {
            marsRoverPhotoViewModel.getMarsRoverPhoto(
                roverName = roverName,
                sol = sol
            )
        }
        when(val roverPhotoUiState = viewState) {
            RoverPhotoUiState.Error -> Error()
            RoverPhotoUiState.Loading -> Loading()
            is RoverPhotoUiState.Success -> {
                PhotoList(
                    modifier = modifier,
                    roverPhotoUiModelList = roverPhotoUiState.roverPhotoUiModelList
                )
            }
        }
    }
}