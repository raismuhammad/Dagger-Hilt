package com.raisproject.localdatacrud.di

import android.app.Application
import androidx.room.Room
import com.raisproject.localdatacrud.data.local.DataDao
import com.raisproject.localdatacrud.data.local.DataDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application, callback: DataDb.Callback): DataDb{
        return Room.databaseBuilder(application, DataDb::class.java, "news_database")
            .fallbackToDestructiveMigration()
            .addCallback(callback)
            .build()
    }

    @Provides
    fun provideArticleDao(db: DataDb): DataDao{
        return db.getDataDao()
    }
}