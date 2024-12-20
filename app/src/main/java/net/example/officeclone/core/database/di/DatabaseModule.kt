package net.example.officeclone.core.database.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.example.officeclone.core.database.OfficeDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {
    @Provides
    @Singleton
    fun provideOfficeDatabase(
        @ApplicationContext context: Context
    ): OfficeDatabase = Room.databaseBuilder(
        context,
        OfficeDatabase::class.java,
        "office-database"
    ).build()
}