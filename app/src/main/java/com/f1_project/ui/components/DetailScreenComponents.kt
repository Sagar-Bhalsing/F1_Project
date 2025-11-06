package com.f1_project.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
internal fun TimerView() {
    Box() {
        Row(
            horizontalArrangement = Arrangement.spacedBy(24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SingleTimerView("07", "Days")
            SingleTimerView("16", "Hours")
            SingleTimerView("42", "Minutes")
        }
    }
}


@Composable
internal fun SingleTimerView(value: String, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = value,
            color = Color(0xFF009B3A),
            fontSize = 28.sp,
            lineHeight = 28.sp,
            fontWeight = FontWeight.Medium,
        )
        Text(
            text = label,
            color = Color(0xFFFFFFFF),
            fontSize = 8.sp,
            lineHeight = 12.sp,
            fontWeight = FontWeight.Medium,
        )
    }
}

@Composable
internal fun DetailBox() {
    Column(
        horizontalAlignment = Alignment.Start, modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.Black)
            .padding(horizontal = 20.dp)
            .padding(top = 10.dp)
    ) {
        Text(
            text = "São Paulo  Circuit",
            color = Color(0xFFFFFFFF),
            fontSize = 18.sp,
            lineHeight = 18.sp,
            fontWeight = FontWeight.Bold,
        )
        Spacer(Modifier.height(12.dp))

        Text(
            text = "Bahrain International circuit is located in Sakhir, Bahrain and it was designed by German architect Hermann Tilke. It was built on the site of a former camel farm, in Sakhir. It measures 5.412 km, has 15 corners and 3 DRS Zones. The Grand Prix have 57 laps. This circuit has 6 alternative layouts.",
            color = Color(0xFFFFFFFF),
            fontSize = 8.sp,
            lineHeight = 12.sp,
            fontWeight = FontWeight.Medium,
        )

        Spacer(Modifier.height(30.dp))

        Text(
            text = "Circuit Facts",
            color = Color(0xFFFFFFFF),
            fontSize = 18.sp,
            lineHeight = 18.sp,
            fontWeight = FontWeight.Bold,
        )

        Spacer(Modifier.height(12.dp))

        Text(
            text = "His brother Arthur Leclerc is currently set to race for DAMS in the 2023 F2 Championship",
            color = Color(0xFFFFFFFF),
            fontSize = 8.sp,
            lineHeight = 12.sp,
            fontWeight = FontWeight.Medium,
        )

        Spacer(Modifier.height(20.dp))
        Divider(color = Color(0xFF141414), thickness = 1.dp)
        Spacer(Modifier.height(20.dp))

        Text(
            text = "He’s not related to Édouard Leclerc, the founder of a French supermarket chain",
            color = Color(0xFFFFFFFF),
            fontSize = 8.sp,
            lineHeight = 12.sp,
            fontWeight = FontWeight.Medium,
        )

        Spacer(Modifier.height(20.dp))
        Divider(color = Color(0xFF141414), thickness = 1.dp)
        Spacer(Modifier.height(50.dp))

    }
}