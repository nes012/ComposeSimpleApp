package anzhy.dizi.composesimpleapp.view

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import anzhy.dizi.composesimpleapp.ui.manifestlist.MarsRoverManifestViewModel

@Composable
fun ManifestScreen(
    roverName: String?,
    marsRoverManifestViewModel: MarsRoverManifestViewModel
) {
    if (roverName != null) {
        LaunchedEffect(Unit) {
            marsRoverManifestViewModel.getMarsRoverManifest(roverName)
        }
    }
    Text(
        text = "Manifest Screen $roverName"
    )
}

@Preview
@Composable
fun ManifestScreenPreview() {
    //ManifestScreen("Perseverence")
}