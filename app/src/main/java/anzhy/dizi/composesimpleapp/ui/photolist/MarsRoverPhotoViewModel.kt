package anzhy.dizi.composesimpleapp.ui.photolist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import anzhy.dizi.composesimpleapp.network.data.MarsPhotoRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MarsRoverPhotoViewModel @Inject constructor(
    private val marsRoverPhotoRepo: MarsPhotoRepo
): ViewModel() {

    fun getMarsRoverPhoto(roverName: String, sol: String) {
        viewModelScope.launch {
            marsRoverPhotoRepo.getMarsRoverPhoto(
                roverName = roverName,
                sol = sol
            ).collect {

            }
        }

    }
}