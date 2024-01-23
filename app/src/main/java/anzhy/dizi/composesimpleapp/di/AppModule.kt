package anzhy.dizi.composesimpleapp.di

import anzhy.dizi.composesimpleapp.network.service.MarsRoverService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideMarsRoverManifestService(): MarsRoverService =
        MarsRoverService.create()

}