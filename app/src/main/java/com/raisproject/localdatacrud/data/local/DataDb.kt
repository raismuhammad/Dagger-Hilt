package com.raisproject.localdatacrud.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import com.raisproject.localdatacrud.data.model.Data
import com.raisproject.localdatacrud.di.ApplicationScope
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = [Data::class], version = 1)
abstract class DataDb : RoomDatabase() {

    abstract fun getDataDao(): DataDao

    class Callback @Inject constructor(
        private val database: Provider<DataDb>,
        @ApplicationScope private val applicationScope: CoroutineScope
    ) : RoomDatabase.Callback()
}