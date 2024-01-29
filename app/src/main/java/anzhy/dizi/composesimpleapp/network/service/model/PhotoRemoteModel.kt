package anzhy.dizi.composesimpleapp.network.service.model

import anzhy.dizi.composesimpleapp.network.data.CameraRemoteModel
import com.google.gson.annotations.SerializedName

data class PhotoRemoteModel(
    val camera: CameraRemoteModel,
    @field:SerializedName("earth_date") val earthDate: String,
    val id: Int,
    @field:SerializedName("img_src") val imgSrc: String,
    val rover: RoverRemoteModel,
    val sol: Int
)