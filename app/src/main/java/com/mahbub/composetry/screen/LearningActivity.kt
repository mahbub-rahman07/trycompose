package com.mahbub.composetry.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
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
        Text(
            text = "লার্নিং এক্টিভিটি",
            style = TextStyle(
                fontSize = 16.sp,
//            fontFamily = FontFamily(Font(R.font.noto sans bengali)),
                fontWeight = FontWeight(600),
                color = Color(0xFF000000),
            )
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "8 Apr - 14 Apr, 2024 ",
                style = TextStyle(
                    fontSize = 12.sp,
//                    fontFamily = FontFamily(Font(R.font.inter)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF4B5563),
                )
            )

            Row {
                Image(
                    painter = painterResource(id = R.drawable.ic_arrow_right),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )
                Text(
                    text = "Last 7 days",
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 20.sp,
//                    fontFamily = FontFamily(Font(R.font.inter)),
                        fontWeight = FontWeight(500),
                        color = Color(0xFF111827),
                    )
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_arrow_right),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )
            }
        }


        Box(
            modifier =
            Modifier
                .width(156.dp)
                .width(165.dp)

                .border(
                    width = 1.dp,
                    color = Color(0xFFE5E7EB),
                    shape = RoundedCornerShape(size = 8.dp)
                )
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFFC8F9D9),
                            Color(0xFFFFFFFF),
                        )
                    ),
                    shape = RoundedCornerShape(size = 8.dp)
                )


        ) {

            Column {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(
                        10.dp,
                        Alignment.CenterHorizontally
                    ),

                    ) {
                    Image(
                        modifier = Modifier
                            .padding(start = 4.dp, top = 4.dp, bottom = 4.dp, end = 4.dp)
                            .size(18.dp),
                        painter = painterResource(id = R.drawable.ic_img),
                        contentDescription = "image description",
                        contentScale = ContentScale.Crop,

                        )
                    Text(
                        text = "লাইভ ক্লাসে উপস্থিতি",
                        style = TextStyle(
                            fontSize = 12.sp,
                            lineHeight = 20.sp,
//                        fontFamily = FontFamily(Font(R.font.noto sans bengali)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF6B7280),
                        )
                    )
                }
                Text(
                    text = "0",
                    style = TextStyle(
                        fontSize = 24.sp,
                        lineHeight = 20.sp,
//                        fontFamily = FontFamily(Font(R.font.inter)),
                        fontWeight = FontWeight(600),
                        color = Color(0xFF111827),
                    ),
                    modifier = Modifier.padding(start = 4.dp)
                )
                Text(
                    text = "এখনো লাইভ ক্লাস হয় নি",
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

        }


    }


}


@Composable
@Preview(showBackground = true)
fun LearningViewPreview() {
    LearningView()
}