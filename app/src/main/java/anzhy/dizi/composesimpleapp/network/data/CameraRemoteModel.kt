package anzhy.dizi.composesimpleapp.network.data

import com.google.gson.annotations.SerializedName

class CameraRemoteModel(
    @field:SerializedName("full_name") val fullName: String,
    val id: Int,
    val name: String,
    @field:SerializedName("rover_id") val roverId: Int
)