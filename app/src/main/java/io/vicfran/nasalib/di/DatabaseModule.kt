package io.vicfran.nasalib.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.vicfran.nasalib.persistence.AstronomyPictureDao
import io.vicfran.nasalib.persistence.NasaDatabase
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideNasaDatabase(@ApplicationContext context: Context): NasaDatabase {
        return NasaDatabase.getInstance(context)
    }

    @Provides
    fun provideAstronomyPictureDao(nasaDatabase: NasaDatabase): AstronomyPictureDao {
        return nasaDatabase.astronomyPictureDao()
    }
}