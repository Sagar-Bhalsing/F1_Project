package com.f1_project.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.f1_project.ui.R


@Composable
internal fun DateTimeBox(schedule: Triple<String, String, String>?, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0XFF044331))
            .width(164.dp)
            .height(132.dp)
            .clickable { onClick() }

    ) {
        Icon(
            painter = painterResource(id = R.drawable.f1_race_map),
            tint = Color(0XFFFFFFFF),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 10.dp, end = 10.dp)
        )
        Box(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 12.dp, bottom = 13.dp)
        ) {
            Column {
                Text(
                    text = schedule?.first.toString(),
                    color = Color(0xFFFFFFFF),
                    fontSize = 12.sp,
                    lineHeight = 14.sp,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(Modifier.height(6.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(R.drawable.f1_race_calender_ic),
                        tint = Color(0xFFFFFFFF),
                        contentDescription = null
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(
                        text = schedule?.second.toString(),
                        color = Color(0xFFFFFFFF),
                        fontSize = 14.sp,
                        lineHeight = 18.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }
                Spacer(Modifier.height(6.dp))
                Text(
                    text = schedule?.third.toString(),
                    color = Color(0xFF02BB81),
                    fontSize = 36.sp,
                    lineHeight = 36.sp,
                    fontWeight = FontWeight.Bold,
                )


            }
        }
    }
}

@Composable
internal fun F1EducationBox(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0XFF3020FD))
            .width(164.dp)
            .height(60.dp)
            .clickable {
                onClick()
            },
        contentAlignment = Alignment.CenterStart,
    ) {
        Icon(
            painter = painterResource(R.drawable.f1_navigate_ic),
            tint = Color(0xFFFFFFFF),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 9.dp, end = 9.dp)
        )

        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(start = 14.dp)) {
            Icon(
                painter = painterResource(R.drawable.f1_education_ic),
                tint = Color(0xFFFFFFFF),
                contentDescription = null,

                )
            Spacer(Modifier.width(12.dp))
            Column {
                Text(
                    text = "Formula 1",
                    color = Color(0xFFFFFFFF),
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = "Education",
                    color = Color(0xFFFFFFFF),
                    fontSize = 16.sp,
                    lineHeight = 18.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    }
}

@Composable
internal fun F1BannerBox(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(16.dp))
            .clickable { onClick() }
    ) {
        Image(
            painter = painterResource(R.drawable.f1_25_banner),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
        Icon(
            painter = painterResource(R.drawable.f1_insta_icon),
            contentDescription = null,
            tint = Color(0xFFFFFFFF),
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 12.5.dp, bottom = 12.5.dp)
        )
    }

}

@Composable
internal fun F1DistanceBox() {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(Color.Transparent)
            .width(164.dp)
            .height(60.dp)
            .border(color = Color(0xFF212121), width = 1.dp, shape = RoundedCornerShape(16.dp)),
        contentAlignment = Alignment.CenterStart,
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(60.dp)
                .background(Color(0xFFF51A1E))
        )
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(start = 9.dp)) {
            Icon(painter = painterResource(R.drawable.f1_route_ic), contentDescription = null)
            Spacer(Modifier.width(2.dp))
            Text(
                text = "7023.3",
                color = Color(0xFFFFFFFF),
                fontSize = 28.sp,
                lineHeight = 28.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = "km",
                color = Color(0xFFFFFFFF),
                fontSize = 14.sp,
                lineHeight = 28.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp)
            )

        }
    }
}