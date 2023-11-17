package com.mahbub.composetry.screen

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.animation.with
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen(msg: String?) {
    topBarProfile()
}

@Composable
fun topBarProfile() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
    ) {

        val shape =
            RoundedCornerShape(
                topStart = 5.dp,
                topEnd = 5.dp,
                bottomStart = 60.dp,
                bottomEnd = 0.dp
            )

        Column {
            val state = remember {
                mutableStateOf(false)
            }
            Box(
                contentAlignment = Alignment.TopStart,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .border(
                        width = 1.dp,
                        color = Color(0xFF1CAB55),
                        shape = shape
                    )
                    .background(color = Color(0xFFF3FFF2), shape = shape)
                    .padding(start = 12.dp, top = 10.dp, end = 12.dp, bottom = 8.dp)
            ) {

                Column(modifier = Modifier.fillMaxWidth()) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 12.dp, top = 10.dp, end = 12.dp, bottom = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.AccountCircle,
                            contentDescription = null,
                            modifier = Modifier.size(48.dp),
                        )
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 12.dp, top = 0.dp, end = 12.dp, bottom = 8.dp),
                            verticalArrangement = Arrangement.Top
                        ) {
                            Text(
                                text = "Mahbubur Rahman",
                                style = MaterialTheme.typography.bodyLarge,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Android Developer",
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.SemiBold
                            )
                        }

                    }
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .size(1.dp)
                            .background(Color(0xFF1CAB55))
                    )
                    Text(
                        text = "This android developer group",
                        style = TextStyle(
                            fontSize = 11.sp,
                            lineHeight = 20.sp,
                            color = Color(0xFF1CABEE),
                            fontWeight = FontWeight.SemiBold,
                            textAlign = TextAlign.Center
                        ),
                        modifier = Modifier
                            .padding(top = 8.dp, bottom = 8.dp)
                            .fillMaxWidth()
                    )
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .size(1.dp)
                            .background(Color(0xFF1CAB55))
                    )


                    var isVisible by remember {
                        mutableStateOf(false)
                    }

//                Button(onClick = {
//                    isVisible = !isVisible
//                }) {
//                   infiniteAnimate()
//
//                }
                    infiniteAnimate {
                        isVisible = !isVisible
                        state.value = !state.value

                    }

                    checkAbility(isVisible = isVisible)


                }
            }



            AnimatedContent(
                targetState = state.value, label = "",
                modifier = Modifier.fillMaxWidth().weight(1f),
                content = { isVisisble->
                    val shape = RoundedCornerShape(if(isVisisble) 10 else 80)
                    if (isVisisble) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color.Gray,shape)
                        )
                    } else {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color.Red,shape)
                        )
                    }
                },
                transitionSpec = {
                    slideInHorizontally{-it} togetherWith slideOutHorizontally{it}
                }
            )
        }
    }

}

@Composable
fun checkAbility(isVisible: Boolean) {
    AnimatedVisibility(
        visible = isVisible,
        enter = slideInHorizontally(
            initialOffsetX = { it },
            animationSpec = spring()
        ) + fadeIn(),
        exit = slideOutHorizontally(
            targetOffsetX = { -it },
            animationSpec = spring()
        ) + fadeOut()

    ) {

        val rounded = remember {
            mutableStateOf(false)
        }

        val borderRadious by animateIntAsState(
            targetValue = if (rounded.value) 50 else 15,
            label = "",
            animationSpec = tween(durationMillis = 1000)
        )
        val borderRadiousWithBounc by animateIntAsState(
            targetValue = if (rounded.value) 50 else 15,
            label = "",
            animationSpec = spring(
                dampingRatio = 0.5f,
                stiffness = 100f
            )
        )
        val shape = RoundedCornerShape(
            borderRadious.dp,
        )
        val sizeBox by animateIntAsState(
            targetValue = if (rounded.value) 80 else 100,
            label = "",
            animationSpec = tween(durationMillis = 1000)
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(sizeBox.dp)
                .border(
                    width = 1.dp,
                    color = Color(0xFFFFFFFF),
                    shape = shape
                )
                .background(color = if (rounded.value) Color.Red else Color.DarkGray, shape = shape)
                .padding(start = 12.dp, top = 10.dp, end = 12.dp, bottom = 8.dp)
                .clip(shape)
                .clickable {
                    rounded.value = !rounded.value
                }

        ) {
            Text(
                text = if (rounded.value) "Thanks for booking!" else "Click to Confirm",
                color = Color.White,
                style = TextStyle(
                    fontSize = if (!rounded.value) 16.sp else 11.sp,
                    lineHeight = 20.sp,
                    color = Color(0xFF1CABEE),
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center
                )
            )
        }
    }

}

@Composable
fun infiniteAnimate(function: () -> Unit) {
    val transation = rememberInfiniteTransition(label = "")
    var isBooked = remember {
        mutableStateOf(false)
    }
    val color by transation.animateColor(
        initialValue = Color.DarkGray,
        targetValue = Color.Red,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 2000),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )
    Spacer(modifier = Modifier.height(10.dp))
    Box(
        modifier = Modifier
            .background(color = color, shape = RoundedCornerShape(10.dp))
            .padding(2.dp)
            .clickable {
                function()
                isBooked.value = !isBooked.value
            }
    ) {
        animateContent(isVisible = isBooked.value)
    }
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun animateContent(isVisible: Boolean) {
    val style = TextStyle(
        fontSize = 16.sp,
        lineHeight = 20.sp,
        color = Color(0xFF1CABEE),
        fontWeight = FontWeight.SemiBold,
        textAlign = TextAlign.Center
    )
    AnimatedContent(
        targetState = isVisible, label = "",
        transitionSpec = {
            fadeIn() togetherWith fadeOut()
        }
    ) { state ->
        when (state) {
            false -> {
                Text(
                    text = "Check availability!",
                    color = Color.White,
                    style = style,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            true -> {
                Text(
                    text = "Developer is available for hire",
                    style = style,
                    color = Color.White,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

    }

}

@Composable
@Preview
fun ProfileScreenPreview() {
    ProfileScreen("")
}