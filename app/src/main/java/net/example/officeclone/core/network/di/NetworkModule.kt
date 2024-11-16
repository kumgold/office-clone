package net.example.officeclone.core.network.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.example.officeclone.core.network.retrofit.OfficeNetworkDataSource
import net.example.officeclone.core.network.retrofit.RetrofitOfficeNetwork

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkModule {

    @Binds
    abstract fun binds(impl: RetrofitOfficeNetwork): OfficeNetworkDataSource
}