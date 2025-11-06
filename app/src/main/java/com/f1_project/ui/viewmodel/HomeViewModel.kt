package com.f1_project.ui.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.f1_project.data.models.Driver
import com.f1_project.data.models.Schedule
import com.f1_project.data.models.Session
import com.f1_project.data.network.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _drivers = MutableStateFlow<List<Driver>>(emptyList())
    val drivers: StateFlow<List<Driver>> = _drivers.asStateFlow()

    private val _nextRace = MutableStateFlow<Schedule?>(null)
    val nextRace: StateFlow<Schedule?> = _nextRace.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            try {
                val driversResponse = RetrofitClient.apiService.getDrivers()
                if (driversResponse.isSuccessful) {
                    _drivers.value = driversResponse.body()?.drivers ?: emptyList()
                } else {
                    throw Exception("Drivers API failed: ${driversResponse.message()}")
                }

                val scheduleResponse = RetrofitClient.apiService.getSchedule()
                if (scheduleResponse.isSuccessful) {
                    val schedule = scheduleResponse.body()?.schedule ?: emptyList()
                    val currentTime = System.currentTimeMillis() / 1000L // Unix seconds
                    // Filter for upcoming races (raceStartTime > current)
                    val upcomingRaces = schedule.filter { it.raceStartTime > currentTime }
                    val next = upcomingRaces.minByOrNull { it.raceStartTime }
                    _nextRace.value = next
                } else {
                    throw Exception("Schedule API failed: ${scheduleResponse.message()}")
                }
            } catch (e: Exception) {
                _error.value = "Failed to load data: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun getNextSession(race: Schedule): Session? {
        val currentTime = System.currentTimeMillis() / 1000L
        return race.sessions.filter { it.startTime > currentTime }.minByOrNull { it.startTime }
    }
}