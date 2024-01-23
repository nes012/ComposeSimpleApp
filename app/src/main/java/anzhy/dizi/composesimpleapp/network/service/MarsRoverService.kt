package anzhy.dizi.composesimpleapp.network.service

import anzhy.dizi.composesimpleapp.BuildConfig
import anzhy.dizi.composesimpleapp.network.service.model.RoverManifestRemoteModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Path

interface MarsRoverService {

    @GET("mars-photos/api/v1/manifests/{rover_name}?api_key=$API_KEY")
    suspend fun getMarsRoverManifest(@Path("rover_name") roverName: String): RoverManifestRemoteModel

    companion object {
        private const val API_KEY = "hTnD3oPthaoGNGrKcaKhQYbWTixFcDl5UEiY9Yxe"
        private const val BASE_URL = "https://api.nasa.gov/"

        fun create(): MarsRoverService {
            val logger = HttpLoggingInterceptor()
            logger.level =
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BASIC else HttpLoggingInterceptor.Level.NONE

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MarsRoverService::class.java)
        }
    }
}