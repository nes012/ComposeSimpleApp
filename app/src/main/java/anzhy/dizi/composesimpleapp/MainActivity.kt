package anzhy.dizi.composesimpleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import anzhy.dizi.composesimpleapp.ui.manifestlist.MarsRoverManifestViewModel
import anzhy.dizi.composesimpleapp.ui.theme.ComposeSimpleAppTheme
import anzhy.dizi.composesimpleapp.view.Rover
import anzhy.dizi.composesimpleapp.view.RoverList
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NavCompose()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeSimpleAppTheme {

    }
}