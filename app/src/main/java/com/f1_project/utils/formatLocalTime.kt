package com.f1_project.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun formatLocalDate(timestamp: Long): String {
    val sdf = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())
    return sdf.format(Date(timestamp * 1000)) // Unix seconds to ms
}

fun formatLocalTimeOnly(timestamp: Long): String {
    val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
    return sdf.format(Date(timestamp * 1000))
}