package com.mahbub.composetry.screen

import android.text.TextUtils
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahbub.composetry.R

@Composable
fun LearningView() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        CustomTextViewH1("লার্নিং এক্টিভিটি", "bn", Color(0xFF111827))
        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "8 Apr - 14 Apr, 2024 ", style = TextStyle(
                    fontSize = 12.sp,
//                    fontFamily = FontFamily(Font(R.font.inter)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF4B5563),
                )
            )

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(painter = painterResource(id = R.drawable.ic_arrow_right),
                    contentDescription = "image description",
                    contentScale = ContentScale.None,
                    colorFilter = ColorFilter.tint(Color.Black),
                    modifier = Modifier.graphicsLayer {
                        rotationY = 180f
                    })
                Text(
                    text = "Last 7 days", style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 20.sp,
//                    fontFamily = FontFamily(Font(R.font.inter)),
                        fontWeight = FontWeight(500),
                        color = Color(0xFF111827),
                    ), modifier = Modifier
                        .border(
                            width = 1.dp,
                            color = Color(0xFFE5E7EB),
                            shape = RoundedCornerShape(size = 4.dp)
                        )
                        .padding(4.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_arrow_right),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 8.dp, bottom = 8.dp
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
                GetCardViewLarge(
                    modifier = Modifier.fillMaxWidth(0.5f),
                    height = 135.dp,
                    gradiantColor = 0xFFC8F9D9,
                    title = "লাইভ ক্লাসে উপস্থিতি",
                    icon = R.drawable.ic_img,
                    value = "0",
                    description = "এখনো লাইভ ক্লাস হয় নি"
                )
                GetCardViewMedium(
                    modifier = Modifier.fillMaxWidth(),
                    height = 65.dp,
                    gradiantColor = 0xFFFFECDA,
                    title = "কুইজ প্র্যাকটিস করেছেন",
                    icon = R.drawable.ic_img,
                    value = "0",
                )
            }


        }


    }

    @Composable
    fun GetCardViewLarge(
        modifier: Modifier,
        height: Dp,
        gradiantColor: Long,
        title: String,
        icon: Int,
        value: String,
        description: String
    ) {
        Box(
            modifier = modifier
                .padding(start = 8.dp)
                .border(
                    width = 1.dp,
                    color = Color(0xFFFFECDA),
                    shape = RoundedCornerShape(size = 8.dp)
                )
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(gradiantColor),
                            Color(0xFFFFFFFF),
                        )
                    ), shape = RoundedCornerShape(size = 8.dp)
                )


        ) {

            Column(
                modifier = Modifier
                    .height(height = height)
                    .padding(8.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.Start
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,

                    ) {
                    Image(
                        painter = painterResource(id = icon),
                        contentDescription = "image description",
                        contentScale = ContentScale.None,
                    )
                    Text(
                        text = title,
                        style = TextStyle(
                            fontSize = 12.sp,
                            lineHeight = 20.sp,
//                        fontFamily = FontFamily(Font(R.font.noto sans bengali)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF6B7280),
                        ),
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = value, style = TextStyle(
                            fontSize = 24.sp,
                            lineHeight = 20.sp,
//                        fontFamily = FontFamily(Font(R.font.inter)),
                            fontWeight = FontWeight(600),
                            color = Color(0xFF111827),
                        ), modifier = Modifier.padding(start = 4.dp)
                    )
                }

                if(!TextUtils.isEmpty(description)) {
                    Text(
                        text = description, style = TextStyle(
                            fontSize = 12.sp,
                            lineHeight = 20.sp,
                            //fontFamily = FontFamily(Font(R.font.noto sans bengali)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF6B7280),
                        ), modifier = Modifier.padding(start = 4.dp)
                    )
                }
            }

        }

    }
@Composable
fun GetCardViewMedium(
    modifier: Modifier,
    height: Dp,
    gradiantColor: Long,
    title: String,
    icon: Int,
    value: String
) {
    Box(
        modifier = modifier
            .padding(start = 8.dp)
            .border(
                width = 1.dp,
                color = Color(0xFFFFECDA),
                shape = RoundedCornerShape(size = 8.dp)
            )
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(gradiantColor),
                        Color(0xFFFFFFFF),
                    )
                ), shape = RoundedCornerShape(size = 8.dp)
            )


    ) {

        Column(
            modifier = Modifier
                .height(height = height)
                .padding(8.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,

                ) {
                Text(
                    text = title,
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 20.sp,
//                        fontFamily = FontFamily(Font(R.font.noto sans bengali)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF6B7280),
                    ),
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = icon),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )
                Text(
                    text = value, style = TextStyle(
                        fontSize = 24.sp,
                        lineHeight = 20.sp,
//                        fontFamily = FontFamily(Font(R.font.inter)),
                        fontWeight = FontWeight(600),
                        color = Color(0xFF111827),
                    ), modifier = Modifier.padding(start = 4.dp)
                )
            }
        }

    }

}


    @Composable
    @Preview(
        showBackground = true, showSystemUi = true
    )
    fun LearningViewPreview() {
        LearningView()
    }