package anzhy.dizi.composesimpleapp.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import anzhy.dizi.composesimpleapp.network.service.model.RoverManifestUiState
import anzhy.dizi.composesimpleapp.ui.manifestlist.MarsRoverManifestViewModel

@Composable
fun ManifestScreen(
    modifier: Modifier,
    roverName: String?,
    marsRoverManifestViewModel: MarsRoverManifestViewModel,
    onClick: (roverName: String, sol: String) -> Unit
) {
    val viewState by marsRoverManifestViewModel.roverManifestUiState.collectAsStateWithLifecycle()

    if (roverName != null) {
        LaunchedEffect(Unit) {
            marsRoverManifestViewModel.getMarsRoverManifest(roverName)
        }
        when (val roverManifestUiState = viewState) {
            RoverManifestUiState.Error -> Error()
            RoverManifestUiState.Loading -> Loading()
            is RoverManifestUiState.Success -> ManifestList(
                modifier = modifier,
                roverManifestUiModelList = roverManifestUiState.roverManifestUiModelList,
                roverName = roverName,
                onClick = onClick
            )
        }
    }
}

@Preview
@Composable
fun ManifestScreenPreview() {
    //ManifestScreen("Perseverence")
}