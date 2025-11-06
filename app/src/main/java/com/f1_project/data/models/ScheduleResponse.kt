package com.f1_project.data.models

data class ScheduleResponse(
    val schedule: List<Schedule>
)

data class Schedule(
    val raceId: String,
    val circuitId: String,
    val isSprint: Boolean,
    val raceEndTime: Long,
    val raceName: String,
    val raceStartTime: Long,
    val raceState: String,
    val round: Int,
    val sessions: List<Session>
)

data class Session(
    val sessionId: String,
    val sessionType: String,
    val sessionName: String,
    val startTime: Long,
    val endTime: Long,
    val sessionState: String
)