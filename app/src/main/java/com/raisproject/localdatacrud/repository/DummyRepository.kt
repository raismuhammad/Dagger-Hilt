package com.raisproject.localdatacrud.repository

import com.raisproject.localdatacrud.data.local.DataDao
import com.raisproject.localdatacrud.data.model.Data
import com.raisproject.localdatacrud.data.remote.DummyApi
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DummyRepository @Inject constructor(
    private val dummyApi: DummyApi,
    private val dataDao: DataDao
) {

    fun getAllData() = dataDao.getData()

    suspend fun insertData(data: Data) = dataDao.insert(data)
}