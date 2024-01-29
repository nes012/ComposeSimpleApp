package anzhy.dizi.composesimpleapp.network.data

import anzhy.dizi.composesimpleapp.model.roverUIModelList
import anzhy.dizi.composesimpleapp.network.service.MarsRoverPhotoService
import anzhy.dizi.composesimpleapp.network.service.model.RoverPhotoUiModel
import anzhy.dizi.composesimpleapp.network.service.model.RoverPhotoUiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MarsPhotoRepo @Inject constructor(
    private val marsRoverPhotoService: MarsRoverPhotoService
) {

    fun getMarsRoverPhoto(roverName: String, sol: String): Flow<RoverPhotoUiState> = flow {
        try {
            val networkResult = marsRoverPhotoService.getMarsRoverPhotos(
                roverName = roverName,
                sol = sol
            )
            emit(
                RoverPhotoUiState.Success(
                    roverPhotoUiModelList = networkResult.photos.map { photo ->
                        RoverPhotoUiModel(
                            id = photo.id,
                            roverName = roverName,
                            imgSrc = photo.imgSrc,
                            sol = sol,
                            earthDate = photo.earthDate,
                            cameraFullName = photo.camera.fullName
                        )
                    })
            )
        } catch (throwable: Throwable) {
            emit(RoverPhotoUiState.Error)
        }
    }
}