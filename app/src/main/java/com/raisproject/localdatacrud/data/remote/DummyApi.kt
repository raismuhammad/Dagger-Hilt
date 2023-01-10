package com.raisproject.localdatacrud.data.remote

import com.raisproject.localdatacrud.data.model.DummyResponse
import retrofit2.Response
import retrofit2.http.GET

interface DummyApi {

    @GET("datadummy.php")
    suspend fun getData(
    ): Response<DummyResponse>
}