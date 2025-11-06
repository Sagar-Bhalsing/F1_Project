package com.f1_project.ui.components

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.f1_project.data.models.Driver
import com.f1_project.ui.R
import kotlinx.coroutines.delay

@Composable
fun AutoSlidingSlider(
    driver: Driver?,
    onPageChanged: (Int) -> Unit = {}
) {
    val pages = listOf<@Composable () -> Unit>(
        { TopDriverSliderComponent(driver) },
        { FollowUsSliderComponent() }
    )

    val pagerState = rememberPagerState(pageCount = { pages.size })


    LaunchedEffect(pagerState.currentPage) {
        onPageChanged(pagerState.currentPage)
    }

    LaunchedEffect(Unit) {
        while (true) {
            delay(3000)
            val next = (pagerState.currentPage + 1) % pages.size
            pagerState.animateScrollToPage(
                next,
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
        }
    }

    Column {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(360.dp)
                .clipToBounds()
        ) { page ->
            pages[page]()
        }

        SliderIndicator(
            currentPage = pagerState.currentPage,
            pageCount = pages.size
        )
    }
}

@Composable
internal fun TopDriverSliderComponent(driver: Driver?) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(360.dp)
            .background(color = Color(0xFFFF5A08))
    ) {
        val preview = LocalInspectionMode.current

        Text(
            text = driver?.firstName.orEmpty(),
            fontSize = if (preview) 48.sp else 164.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color(0xFFFFF2AF).copy(alpha = 0.28f),
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 18.dp, top = 18.dp)
                .fillMaxWidth(),
            maxLines = 1,
            softWrap = false,
            overflow = TextOverflow.Clip,
            lineHeight = if (preview) 48.sp else 150.sp,
            letterSpacing = (-2).sp
        )
        Image(
            painter = painterResource(id = R.drawable.f1_top_slider_driver_img),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .size(390.dp)
                .offset(y = 35.dp),
            alignment = Alignment.BottomEnd,
        )

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .height(120.dp)
                .fillMaxWidth()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color(0xFF000000).copy(alpha = 0.90f)
                        )
                    )
                )
        )
        Box(modifier = Modifier.padding(top = 215.dp, start = 24.dp)) {
            Column {
                Row {
                    TextWithIconBox(
                        icon = R.drawable.f1_position_ic,
                        position = driver?.position?.toString() ?: "0",
                        label = "Pos"
                    )
                    Spacer(Modifier.width(16.dp))
                    TextWithIconBox(
                        icon = R.drawable.f1_wins_icon,
                        position = driver?.wins?.toString() ?: "0",
                        label = "Wins"
                    )
                }
                Spacer(Modifier.height(24.dp))
                Row(verticalAlignment = Alignment.Bottom) {
                    Text(
                        text = driver?.points.toString() ?: "0",
                        fontSize = 72.sp,
                        lineHeight = 70.sp,
                        fontWeight = FontWeight.Normal,
                        style = TextStyle(
                            brush = Brush.linearGradient(
                                listOf(
                                    Color(0xFFFFFFFF),
                                    Color(0xFFFF5A08)
                                )
                            )
                        )
                    )
                    Spacer(Modifier.width(4.dp))

                    Box(
                        modifier = Modifier
                            .padding(bottom = 20.dp)
                            .clip(shape = RoundedCornerShape(5.dp))
                            .background(Color(0xFFFF5A08)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "PTS",
                            color = Color(0xFFFFFFFF),
                            fontSize = 14.sp,
                            lineHeight = 14.sp,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
internal fun FollowUsSliderComponent() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(360.dp)
            .background(color = Color(0xFF000000)),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.f1_follow_us_img),
            contentDescription = null
        )
        Box(
            Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 30.dp)
        ) {
            FollowUsButton()
        }
    }
}

@Composable
internal fun TextWithIconBox(icon: Int, position: String, label: String) {
    Row(verticalAlignment = Alignment.Bottom, modifier = Modifier.wrapContentSize()) {
        Icon(
            painter = painterResource(icon),
            tint = Color(0xFFFEE102),
            contentDescription = null
        )
        Spacer(Modifier.width(4.dp))
        val updatedPosition = if (position.length == 1) {
            "0$position"
        } else position
        Text(
            text = updatedPosition,
            color = Color(0xFFFFFFFF),
            fontSize = 18.sp,
            lineHeight = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.offset(y = 2.dp)
        )
        Spacer(Modifier.width(4.dp))
        Text(
            text = label,
            color = Color(0xFFFFFFFF),
            fontSize = 10.sp,
            lineHeight = 9.sp,
            fontWeight = FontWeight.Medium,
        )
    }
}

@Composable
internal fun FollowUsButton() {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(55.dp))
            .background(Color(0xFF86FF0E))
            .width(140.dp)
            .height(44.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Follow Us",
            color = Color(0xFF000000),
            fontSize = 16.sp,
            lineHeight = 20.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
fun SliderIndicator(
    currentPage: Int,
    pageCount: Int
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color.Black,
                        Color(0xFF000000).copy(alpha = 0.90f)
                    )
                )
            )
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp, top = 10.dp)
        ) {
            repeat(pageCount) { index ->

                val isSelected = index == currentPage

                val width by animateDpAsState(
                    targetValue = if (isSelected) 24.dp else 6.dp,
                    animationSpec = tween(durationMillis = 300)
                )

                val height by animateDpAsState(
                    targetValue = if (isSelected) 4.dp else 6.dp,
                    animationSpec = tween(durationMillis = 300)
                )

                val alpha by animateFloatAsState(
                    targetValue = if (isSelected) 1f else 0.4f,
                    animationSpec = tween(durationMillis = 300)
                )

                val shape = if (isSelected) RoundedCornerShape(50) else CircleShape

                Box(
                    modifier = Modifier
                        .width(width)
                        .height(height)
                        .clip(shape)
                        .background(Color.White.copy(alpha = alpha))
                )

                Spacer(modifier = Modifier.width(6.dp))
            }
        }
    }
}