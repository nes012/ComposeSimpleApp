package anzhy.dizi.composesimpleapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import anzhy.dizi.composesimpleapp.nav.Action
import anzhy.dizi.composesimpleapp.nav.Destinations.Home
import anzhy.dizi.composesimpleapp.nav.Destinations.Manifest
import anzhy.dizi.composesimpleapp.nav.Destinations.Photo
import anzhy.dizi.composesimpleapp.ui.theme.ComposeSimpleAppTheme
import anzhy.dizi.composesimpleapp.view.ManifestScreen
import anzhy.dizi.composesimpleapp.view.PhotoScreen
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
                RoverList { roverName ->
                    actions.manifest(roverName)
                }
            }
            composable(Manifest) { backStackEntry ->
                ManifestScreen(
                    backStackEntry.arguments?.getString("roverName"),
                    marsRoverManifestViewModel = hiltViewModel(),
                    onClick = { roverName, sol ->
                        actions.photo(roverName, sol)
                    }
                )
            }
            composable(Photo) { backStackEntry ->
                PhotoScreen(
                    roverName = backStackEntry.arguments?.getString("roverName"),
                    sol = backStackEntry.arguments?.getString("sol"),
                    marsRoverPhotoViewModel = hiltViewModel()
                )
            }
        }
    }
}