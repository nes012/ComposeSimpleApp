package anzhy.dizi.composesimpleapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import anzhy.dizi.composesimpleapp.nav.Action
import anzhy.dizi.composesimpleapp.nav.Destinations.Home
import anzhy.dizi.composesimpleapp.nav.Destinations.Manifest
import anzhy.dizi.composesimpleapp.ui.manifestlist.MarsRoverManifestViewModel
import anzhy.dizi.composesimpleapp.ui.theme.ComposeSimpleAppTheme
import anzhy.dizi.composesimpleapp.view.ManifestScreen
import anzhy.dizi.composesimpleapp.view.RoverList

@Composable
fun NavCompose() {
    val navController = rememberNavController()
    val actions = remember(navController) { Action(navController) }

    ComposeSimpleAppTheme {
        NavHost(
            navController = navController,
            startDestination = Home
        ) {
            // to create destinations we should user composable
            composable(Home) {
                RoverList() { roverName ->
                    actions.manifest(roverName)
                }
            }
            composable(Manifest) { backStackEntry ->
                ManifestScreen(
                    backStackEntry.arguments?.getString("roverName"),
                    marsRoverManifestViewModel = hiltViewModel()
                )
            }
        }
    }
}