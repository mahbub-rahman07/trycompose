package com.mahbub.composetry.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalenderView() {

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth().
            padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Text(
                text = "শনি", style = TextStyle(
                    fontSize = 11.sp,
                    lineHeight = 20.sp,
                    //fontFamily = FontFamily(Font(R.font.noto sans bengali)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF6B7280),
                    textAlign = TextAlign.Center,
                    letterSpacing = 0.11.sp,
                )
            )
            Text(
                text = "রবি", style = TextStyle(
                    fontSize = 11.sp,
                    lineHeight = 20.sp,
                    //fontFamily = FontFamily(Font(R.font.noto sans bengali)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF6B7280),
                    textAlign = TextAlign.Center,
                    letterSpacing = 0.11.sp,
                )
            )
            Text(
                text = "সোম", style = TextStyle(
                    fontSize = 11.sp,
                    lineHeight = 20.sp,
                    //fontFamily = FontFamily(Font(R.font.noto sans bengali)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF6B7280),
                    textAlign = TextAlign.Center,
                    letterSpacing = 0.11.sp,
                )
            )
            Text(
                text = "মঙ্গল", style = TextStyle(
                    fontSize = 11.sp,
                    lineHeight = 20.sp,
                    //fontFamily = FontFamily(Font(R.font.noto sans bengali)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF6B7280),
                    textAlign = TextAlign.Center,
                    letterSpacing = 0.11.sp,
                )
            )
            Text(
                text = "বুধ", style = TextStyle(
                    fontSize = 11.sp,
                    lineHeight = 20.sp,
                    //fontFamily = FontFamily(Font(R.font.noto sans bengali)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF6B7280),
                    textAlign = TextAlign.Center,
                    letterSpacing = 0.11.sp,
                )
            )
            Text(
                text = "বৃহঃ", style = TextStyle(
                    fontSize = 11.sp,
                    lineHeight = 20.sp,
                    //fontFamily = FontFamily(Font(R.font.noto sans bengali)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF6B7280),
                    textAlign = TextAlign.Center,
                    letterSpacing = 0.11.sp,
                )
            )
            Text(
                text = "শুক্র", style = TextStyle(
                    fontSize = 11.sp,
                    lineHeight = 20.sp,
                    //fontFamily = FontFamily(Font(R.font.noto sans bengali)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF6B7280),
                    textAlign = TextAlign.Center,
                    letterSpacing = 0.11.sp,
                )
            )


        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(7),
            modifier = Modifier.fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp)

        ) {
            items(itemList.size) {
                calenderCell(itemList[it])
            }
        }
    }
}



@Composable
fun calenderCell(model: CalenderCell) {

    val cornerLeft = if(model.isStartSelection) 6.dp else 0.dp
    val cornerEnd = if(model.isEnd) 6.dp else 0.dp
    var colorBG = model.isSelected
    val bgColor = if (model.isLate) 0xFFFF8023 else if(model.isPresent) 0xFF038969 else 0xFFF3F4F6


    Column (
        Modifier
            .width(40.dp)
            .height(40.dp)
//                .background(color = Color(0xFFC5E4DC), shape = RoundedCornerShape(size = 0.dp))
            .background(
                color = Color(if (colorBG) 0xFFC5E4DC else 0xFFFFFFFF),
                shape = RoundedCornerShape(
                    topStart = cornerLeft,
                    topEnd = cornerEnd,
                    bottomStart = cornerLeft,
                    bottomEnd = cornerEnd
                )
            )
            .padding(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){

            Box(
                Modifier
                    .width(32.dp)
                    .height(32.dp)
                    .background(color = Color(bgColor), shape = RoundedCornerShape(size = 7.dp))
            ) {

                Text(
                    text = "${model.text}",
                    style = TextStyle(
                        fontSize = 11.sp,
//                        fontFamily = FontFamily(Font(R.font.inter)),
                        fontWeight = FontWeight(500),
                        color = Color(if(model.isLate || model.isPresent) 0xFFFFFFFF else 0xFF6B7280),
                    ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(start = 4.dp, bottom = 4.dp)
                )

            }

    }
}


@Composable
fun calenderCellWithBG(text: String) {
    Box(
        Modifier
            .width(41.dp)
            .height(41.dp)
            .background(color = Color(0xFFC5E4DC), shape = RoundedCornerShape(size = 7.dp))
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 11.sp,
//                        fontFamily = FontFamily(Font(R.font.inter)),
                fontWeight = FontWeight(500),
                color = Color(0xFF6B7280),
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 4.dp, bottom = 4.dp)
        )

    }
}


@Composable
@Preview(showBackground = true)
fun CalenderViewPreview() {
    //calenderCell("1", true)
    CalenderView()
}


data class CalenderCell(
    val text: String,
    val isSelected: Boolean,
    val isLate:Boolean,
    val summeryText:String,
    val isStartSelection:Boolean,
    val isEnd:Boolean = false,
    val isPresent:Boolean = false
)
val itemList = listOf(
    CalenderCell("1", false, false, "", false),
    CalenderCell("2", false, false, "", false),
    CalenderCell("3", false, true, "2/4", false),
    CalenderCell("4", true, false, "", true),
    CalenderCell("5", true, false, "", false),
    CalenderCell("6", true, false, "", false, isPresent = true),
    CalenderCell("7", true, false, "", false, isPresent = true),
    CalenderCell("8", true, false, "", false,isEnd = false),
    CalenderCell("9", true, true, "", false,isEnd = true),
    CalenderCell("10", false, false, "", false),
    CalenderCell("11", false, false, "", false),
    CalenderCell("12", false, false, "", false),
    CalenderCell("13", false, false, "", false),
    CalenderCell("14", false, false, "", false),
    CalenderCell("15", false, false, "", false),
    CalenderCell("16", false, false, "", false),
    CalenderCell("17", false, false, "", false),
    CalenderCell("18", false, false, "", false),
    CalenderCell("19", false, false, "", false),
    CalenderCell("20", false, false, "", false),
    CalenderCell("21", false, false, "", false),
    CalenderCell("22", false, false, "", false),
    CalenderCell("23", false, false, "", false),
    CalenderCell("24", false, false, "", false),
    CalenderCell("25", false, false, "", false),
    CalenderCell("26", false, false, "", false),
    CalenderCell("27", false, false, "", false),
    CalenderCell("28", false, false, "", false),
    CalenderCell("29", false, false, "", false),
    CalenderCell("30", false, false, "", false),
    CalenderCell("31", false, false, "", false),
    CalenderCell("1", false, false, "", false),
    CalenderCell("2", false, false, "", false),
    CalenderCell("3", false, false, "", false),
    CalenderCell("4", false, false, "", false),

)
