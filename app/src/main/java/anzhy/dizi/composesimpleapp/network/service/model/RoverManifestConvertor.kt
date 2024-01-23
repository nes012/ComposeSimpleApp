package anzhy.dizi.composesimpleapp.network.service.model

fun toUiModel(roverManifestRemoteModel: RoverManifestRemoteModel): RoverManifestUiState {
    return RoverManifestUiState.Success(
        roverManifestRemoteModel.photoManifestRemoteModel.photos.map { photo ->
            RoverManifestUiModel(
                sol = photo.sol.toString(),
                earthDate = photo.earthDate,
                photoNumber = photo.totalPhotos.toString()
            )
        }.sorted()
    )
}