package anzhy.dizi.composesimpleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import anzhy.dizi.composesimpleapp.ui.theme.ComposeSimpleAppTheme
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