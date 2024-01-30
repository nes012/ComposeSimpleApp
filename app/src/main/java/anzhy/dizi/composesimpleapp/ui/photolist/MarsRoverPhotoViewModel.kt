package anzhy.dizi.composesimpleapp.ui.photolist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import anzhy.dizi.composesimpleapp.network.data.MarsPhotoRepo
import anzhy.dizi.composesimpleapp.network.service.model.RoverPhotoUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MarsRoverPhotoViewModel @Inject constructor(
    private val marsRoverPhotoRepo: MarsPhotoRepo
): ViewModel() {

    private val _roverPhotoUiState: MutableStateFlow<RoverPhotoUiState> =
        MutableStateFlow(RoverPhotoUiState.Loading)

    val roverPhotoUiState: StateFlow<RoverPhotoUiState>
        get() = _roverPhotoUiState

    fun getMarsRoverPhoto(roverName: String, sol: String) {
        viewModelScope.launch {
            _roverPhotoUiState.value = RoverPhotoUiState.Loading
            marsRoverPhotoRepo.getMarsRoverPhoto(
                roverName = roverName,
                sol = sol
            ).collect {
                _roverPhotoUiState.value = it
            }
        }

    }
}