package com.f1_project.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.LoadingIndicator
import androidx.compose.material3.MaterialShapes
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.f1_project.ui.components.AutoSlidingSlider
import com.f1_project.ui.components.DateTimeBox
import com.f1_project.ui.components.F1BannerBox
import com.f1_project.ui.components.F1DistanceBox
import com.f1_project.ui.components.F1EducationBox
import com.f1_project.ui.viewmodel.HomeViewModel
import com.f1_project.utils.formatLocalDate
import com.f1_project.utils.formatLocalTimeOnly


@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun HomeScreen(
    onRaceClick: () -> Unit,
    viewModel: HomeViewModel = viewModel()
) {
    val drivers by viewModel.drivers.collectAsState()
    val nextRace by viewModel.nextRace.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    val context = LocalContext.current
    val scrollState = rememberScrollState()

    val topDriver = remember(drivers) {
        drivers.find { it.position == 1 }
    }

    val nextSessionData = remember(nextRace) {
        nextRace?.let { race ->
            viewModel.getNextSession(race)?.let { session ->
                val date = formatLocalDate(session.startTime)
                val time = formatLocalTimeOnly(session.startTime)
                Triple(session.sessionName, date, time)
            }
        }
    }

    if (isLoading) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.5f)),
            contentAlignment = Alignment.Center
        ) {
            LoadingIndicator(
                color = MaterialTheme.colorScheme.primary,
                polygons = listOf(
                    MaterialShapes.Oval,
                    MaterialShapes.SoftBurst
                )
            )
        }
    } else {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
            ) {
                AutoSlidingSlider(
                    driver = topDriver
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .statusBarsPadding()
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 18.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        DateTimeBox(nextSessionData, onClick = onRaceClick)
                        Spacer(Modifier.width(12.dp))
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            F1DistanceBox()
                            Spacer(Modifier.height(12.dp))
                            F1EducationBox(
                                onClick = {
                                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.boxbox.club/tagged/beginners-guide"))
                                    context.startActivity(intent)
                                }
                            )
                        }
                    }
                    Spacer(Modifier.height(12.dp))

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 18.dp)
                            .padding(bottom = 25.dp)
                    ) {
                        F1BannerBox(
                            onClick = {
                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/boxbox_club/"))
                                context.startActivity(intent)
                            }
                        )
                    }
                }
            }
        }
    }
}









