package anzhy.dizi.composesimpleapp.view

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ManifestScreen(
    roverName: String?
) {
    Text(
        text = "Manifest Screen $roverName"
    )
}

@Preview
@Composable
fun ManifestScreenPreview() {
    ManifestScreen("Perseverence")
}