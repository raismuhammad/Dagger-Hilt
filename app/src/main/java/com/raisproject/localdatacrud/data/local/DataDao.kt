package com.raisproject.localdatacrud.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.raisproject.localdatacrud.data.model.Data
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@Dao
interface DataDao {

    @Query("SELECT * FROM data_table")
    fun getData() : LiveData<List<Data>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: Data)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<Data>)
}