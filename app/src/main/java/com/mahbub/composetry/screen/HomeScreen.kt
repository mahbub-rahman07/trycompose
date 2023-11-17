package com.mahbub.composetry.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahbub.composetry.BottomBarScreen
import com.mahbub.composetry.R

@Composable
fun HomeScreen(callBack: (msg: String) -> Unit) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3F4F6))
            .verticalScroll(state = scrollState)
    ) {
        topBar()
        QuickLinks()
        Routine()
        MyCourses()
        AllCourses()
    }


}

@Composable
fun topBar() {
    Box(
        contentAlignment = Alignment.TopStart,
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = Color(0xFF1CAB55),
                shape = RoundedCornerShape(size = 5.dp)
            )
            .background(color = Color(0xFFF3FFF2), shape = RoundedCornerShape(topStart = 5.dp, topEnd = 5.dp, bottomStart = 0.dp, bottomEnd = 0.dp))
            .padding(start = 12.dp, top = 10.dp, end = 12.dp, bottom = 8.dp)
    ) {

    }
}


@Composable
fun QuickLinks() {
    Spacer(modifier = Modifier.size(8.dp))
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically
    ) {
        QuickLinksItem(R.drawable.ic_my_courses, "আমার কোর্সসমূহ")
        QuickLinksItem(R.drawable.ic_routine, "ফুল রুটিন")
        QuickLinksItem(R.drawable.ic_report_card, "রিপোর্ট কার্ড")
        QuickLinksItem(R.drawable.ic_subscription, "সাবস্ক্রিপশন")
    }

}

@Composable
fun QuickLinksItem(icon: Int, title: String) {
    Column(
        modifier = Modifier
            .background(Color.White, RoundedCornerShape(size = 6.dp))
            .padding(8.dp)
            .clip(RoundedCornerShape(size = 6.dp))
            .clickable { },
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = "image description",
            contentScale = ContentScale.None,
            modifier = Modifier
                .size(40.dp, 40.dp)
                .background(Color.White)
        )
        Text(
            text = title,
            style = TextStyle(
                fontSize = 11.sp,
                lineHeight = 20.sp,
//                fontFamily = FontFamily(Font(R.font.noto sans bengali)),
                fontWeight = FontWeight(500),
                color = Color(0xFF111827),
                textAlign = TextAlign.Center,
            )
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Routine() {

    Spacer(modifier = Modifier.size(8.dp))
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = Color(0xFF1CAB55),
                    shape = RoundedCornerShape(size = 5.dp)
                )
                .background(color = Color(0xFFF3FFF2), shape = RoundedCornerShape(size = 5.dp))
                .padding(start = 12.dp, top = 10.dp, end = 12.dp, bottom = 8.dp)
        ) {
            Text(
                text = "আপকামিং",
                style = TextStyle(
                    fontSize = 11.sp,
                    lineHeight = 20.sp,
                )
            )
        }
        Box(
            modifier = Modifier
                .background(color = Color(0xFFF3F4F6), shape = RoundedCornerShape(size = 5.dp))
                .padding(start = 12.dp, top = 10.dp, end = 12.dp, bottom = 8.dp)
        ) {
            Text(
                text = "মিসড",
                style = TextStyle(
                    fontSize = 11.sp,
                    lineHeight = 20.sp,
                )
            )
        }
    }
    Spacer(modifier = Modifier.size(2.dp))
    FlowColumn(content = {
        repeat(5) {
            RoutineItem(if (it % 2 == 0) R.drawable.ic_live else -1)
        }
    })
//    LazyColumn(content = {
//        items(5) {
//
//        }
//    })
    Spacer(modifier = Modifier.size(1.dp))
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { }
            .background(Color.White)
            .padding(top = 16.dp, bottom = 16.dp, start = 8.dp, end = 8.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_calendar),
            contentDescription = "image description",
            contentScale = ContentScale.None
        )
        Spacer(modifier = Modifier.size(4.dp))
        Text(
            text = "ফুল রুটিন দেখুন",
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 20.sp,
//            fontFamily = FontFamily(Font(R.font.noto sans bengali)),
                fontWeight = FontWeight(500),
                color = Color(0xFF1CAB55),
                textAlign = TextAlign.Center,
                letterSpacing = 0.14.sp,
            ),
        )
    }
}

@Composable
fun RoutineItem(icon: Int = -1) {

    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(8.dp)
            .clip(RoundedCornerShape(size = 6.dp))
            .clickable { }
    ) {
        if (icon != -1) {
            Box(
                Modifier
                    .border(
                        width = 1.dp,
                        color = Color(0xFFE5E7EB),
                        shape = RoundedCornerShape(size = 6.dp)
                    )
                    .size(40.dp, 44.dp)
                    .clip(RoundedCornerShape(size = 6.dp))

            ) {

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "1 JAN",
                        style = TextStyle(
                            fontSize = 8.sp,
                            lineHeight = 10.sp,
//                            fontFamily = FontFamily(Font(R.font.inter)),
                            fontWeight = FontWeight(600),
                            color = Color(0xFF4B5563),
                            textAlign = TextAlign.Center,
                            letterSpacing = 0.03.sp,
                        ),
                        modifier = Modifier
                            .border(
                                width = 1.dp,
                                color = Color(0xFFE5E7EB),

                                )
                            .width(48.dp)
                            .height(15.dp)
                            .background(
                                color = Color(0xFFE5E7EB),
                            )

                    )
                    Text(
                        text = "6:00",
                        style = TextStyle(
                            fontSize = 12.sp,
                            lineHeight = 14.sp,
//                            fontFamily = FontFamily(Font(R.font.inter)),
                            fontWeight = FontWeight(600),
                            color = Color(0xFF4B5563),
                            textAlign = TextAlign.Center,
                            letterSpacing = 0.12.sp,
                        )
                    )
                    Text(
                        text = "PM",
                        style = TextStyle(
                            fontSize = 8.sp,
                            lineHeight = 8.sp,
//                            fontFamily = FontFamily(Font(R.font.inter)),
                            fontWeight = FontWeight(500),
                            color = Color(0xFF6B7280),
                            textAlign = TextAlign.Center,
                            letterSpacing = 0.03.sp,
                        )
                    )
                }
            }
        } else {
            Box(
                modifier = Modifier
                    .border(
                        width = 1.dp,
                        color = Color(0xFFFFD1D1),
                        shape = RoundedCornerShape(size = 6.dp)
                    )
                    .background(color = Color(0xFFFFEBEA), shape = RoundedCornerShape(size = 6.dp))
                    .size(40.dp, 40.dp)
                    .clip(RoundedCornerShape(size = 6.dp))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_live),
                    contentDescription = "image description",
                    contentScale = ContentScale.None,
                    modifier = Modifier
                        .size(40.dp, 40.dp)
                )
            }

        }

        Column(
            modifier = Modifier
                .padding(start = 8.dp)
                .width(280.dp)
        ) {
            Text(
                text = "HCS 25 PCMB",
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 20.sp,
//                    fontFamily = FontFamily(Font(R.font.inter)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF3A7CFF),
                    letterSpacing = 0.03.sp,
                )
            )
            Text(
                text = "রসায়নে অনুসন্ধান বা গবেষণা প্রক্রিয়া",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 22.sp,
//                    fontFamily = FontFamily(Font(R.font.noto sans bengali)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF111827),
                    letterSpacing = 0.04.sp,
                )
            )
            Text(
                text = "শুরু হয়েছে বিকেল ৩:০০ টায় ",
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 18.sp,
//                    fontFamily = FontFamily(Font(R.font.noto sans bengali ui)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFFE63C42),
                )
            )
        }
        Image(
            painter = painterResource(id = R.drawable.ic_arrow_right),
            contentDescription = "image description",
            contentScale = ContentScale.None,
            modifier = Modifier
                .size(40.dp, 40.dp)

        )
    }

}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MyCourses() {
    Spacer(modifier = Modifier.size(8.dp))
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
    ) {
        Text(
            text = "আমার কোর্সসমূহ",

            // Bengali/Subtitle/S2 - 16/SemiBold
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 24.sp,
//                    fontFamily = FontFamily(Font(R.font.noto sans bengali)),
                fontWeight = FontWeight(600),
                color = Color(0xFF111827),
            ),
            modifier = Modifier.padding(start = 8.dp)
        )
        Spacer(modifier = Modifier.size(2.dp))
        FlowColumn(content = {
            repeat(2) {
                MyCoursesItem()
            }
        })
    }


}

@Composable
fun MyCoursesItem() {

    Row(
        horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .padding(4.dp)
            .border(
                width = 1.dp,
                color = Color(0xFFE5E7EB),
                shape = RoundedCornerShape(size = 6.dp)
            )
            .clip(RoundedCornerShape(size = 6.dp))
            .clickable { }


    ) {
        Image(
            painter = painterResource(id = R.drawable.thumbnail),
            contentDescription = "image description",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .width(64.dp)
                .height(64.dp)
                .padding(8.dp)
        )
        Column(
            modifier = Modifier
                .padding(start = 8.dp)
                .width(260.dp)
        ) {
            Text(
                text = "একাডেমিক-অনলাইন ব্যাচ",

                // Bengali/Body/B4 - 12/Regular
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 18.sp,
//                    fontFamily = FontFamily(Font(R.font.noto sans bengali)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF6B7280),
                    letterSpacing = 0.03.sp,
                )
            )
            Text(
                text = "HSC 25 অনলাইন ব্যাচ (ফিজিক্স, কেমিস্ট্রি, ম্যাথ, বায়োলজি)",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
//                    fontFamily = FontFamily(Font(R.font.inter)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF111827),
                    letterSpacing = 0.14.sp,
                ),
                maxLines = 2
            )
        }
        Image(
            painter = painterResource(id = R.drawable.ic_arrow_right),
            contentDescription = "image description",
            contentScale = ContentScale.None,
            modifier = Modifier
                .size(40.dp, 40.dp)

        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun AllCourses() {
    Spacer(modifier = Modifier.size(8.dp))
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "রেকর্ডেড কোর্সসমূহ",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 26.sp,
//                    fontFamily = FontFamily(Font(R.font.noto sans bengali)),
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000),
                ),
            )
            Row(
                modifier = Modifier
                    .padding(4.dp)
                    .background(Color.White, RoundedCornerShape(size = 6.dp))
                    .clip(RoundedCornerShape(size = 6.dp))
                    .clickable { },
                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.End),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "সব দেখুন",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 18.sp,
//                    fontFamily = FontFamily(Font(R.font.noto sans bengali ui)),
                        fontWeight = FontWeight(500),
                        color = Color(0xFF111827),
                        textAlign = TextAlign.End,
                        letterSpacing = 0.02.sp,
                    ),
                    modifier = Modifier
                        .padding(end = 4.dp)

                )
                Image(
                    painter = painterResource(id = R.drawable.ic_arrow_right),
                    contentDescription = "image description",
                    contentScale = ContentScale.None,
                )
            }

        }
        FlowRow(modifier = Modifier.horizontalScroll(rememberScrollState()), content = {
            repeat(5) {
                AllCoursesItem()
            }
        })
    }

}

@Composable
fun AllCoursesItem() {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start,
    ) {
        Image(
            painter = painterResource(id = R.drawable.thumbnail),
            contentDescription = "image description",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .width(160.dp)
                .height(90.dp)
                .border(
                    width = 1.dp,
                    color = Color(0xFFE5E7EB),
                    shape = RoundedCornerShape(size = 6.dp)
                )
        )
        Text(
            text = "HSC English Crash \nCourse",
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 22.sp,
//                fontFamily = FontFamily(Font(R.font.noto sans bengali)),
                fontWeight = FontWeight(600),
                color = Color(0xFF282828),
            )
        )
        Text(
            text = "মাওলানা শাইখ মুহাম্মাদ জামাল...",
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 16.sp,
//                fontFamily = FontFamily(Font(R.font.noto sans bengali)),
                fontWeight = FontWeight(400),
                color = Color(0xFF111827),
                letterSpacing = 0.24.sp,
            )
        )
        Text(
            text = "৳ 950",
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 25.6.sp,
//                fontFamily = FontFamily(Font(R.font.inter)),
                fontWeight = FontWeight(600),
                color = Color(0xFF1B9E66),
            )
        )
    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    HomeScreen {

    }
}