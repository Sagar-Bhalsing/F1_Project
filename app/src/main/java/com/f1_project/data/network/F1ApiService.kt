package com.f1_project.data.network

import com.f1_project.data.models.DriverResponse
import com.f1_project.data.models.ScheduleResponse
import retrofit2.Response
import retrofit2.http.GET

interface F1ApiService {
    @GET("e8616da8-220c-4aab-a670-ab2d43224ecb")
    suspend fun getDrivers(): Response<DriverResponse>

    @GET("9086a3f1-f02b-4d24-8dd3-b63582f45e67")
    suspend fun getSchedule(): Response<ScheduleResponse>
}