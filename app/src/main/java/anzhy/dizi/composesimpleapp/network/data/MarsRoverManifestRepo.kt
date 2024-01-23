package anzhy.dizi.composesimpleapp.network.data

import anzhy.dizi.composesimpleapp.network.service.MarsRoverService
import anzhy.dizi.composesimpleapp.network.service.model.RoverManifestUiState
import anzhy.dizi.composesimpleapp.network.service.model.toUiModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MarsRoverManifestRepo @Inject constructor(
    private val marsRoverService: MarsRoverService
) {
    fun getMarsRoverManifest(roverName: String): Flow<RoverManifestUiState> = flow {
        try {
            emit(
                toUiModel(
                    marsRoverService.getMarsRoverManifest(roverName = roverName.lowercase())
                )
            )
        } catch (throwable: Throwable) {
            emit(RoverManifestUiState.Error)
        }
    }
}