package com.mahbub.composetry.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahbub.composetry.R

@Composable
fun GraphView() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(Color(0xFFFFFFFF)),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
    ) {
        barGraph("S",height = 10, isFast = true)
        barGraph("M",height = 30)
        barGraph("T",height = 50)
        barGraph("W",height = 40)
        barGraph("T",height = 30)
        barGraph("F",height = 20)
        barGraph("S",height = 10, isLast = true)

        Column(
            modifier = Modifier
                .height(200.dp)
                .padding(4.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = "5 hr",
                style = TextStyle(
                    fontSize = 11.71.sp,
                    lineHeight = 14.64.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF9CA3AF),
                )
            )
            Text(
                text = "4 hr",
                style = TextStyle(
                    fontSize = 11.71.sp,
                    lineHeight = 14.64.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF9CA3AF),
                )
            )
            Text(
                text = "3 hr",
                style = TextStyle(
                    fontSize = 11.71.sp,
                    lineHeight = 14.64.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF9CA3AF),
                )
            )
            Text(
                text = "2 hr",
                style = TextStyle(
                    fontSize = 11.71.sp,
                    lineHeight = 14.64.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF9CA3AF),
                )
            )
            Text(
                text = "0 hr",
                style = TextStyle(
                    fontSize = 11.71.sp,
                    lineHeight = 14.64.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF9CA3AF),
                )
            )
        }
    }


}


@Composable
fun barGraph(day:String,height: Int = 10, color:Long = 0xFF6B7280, isFast:Boolean = false, isLast:Boolean = false) {

    val starPadding = if (isFast) 10.dp else 0.dp
    val endPadding = if (isLast) 10.dp else 0.dp

    Column(
        Modifier
            //.border(if (isFast || isFast) 1.dp else 0.dp, color = Color(0xFFE5E7EB))
            .padding(4.dp)
            .height(200.dp)
            .background(color = Color(0xFFFFFFFF)),
        verticalArrangement = Arrangement.Bottom,
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ){
            barView(height, 0xFFFFD272)
            barView(height+1, 0xFFF87A7A)
            barView(height = +30, 0xFF3983F7)
            Text(
                modifier = Modifier.padding(top = 4.dp),
                text = "$day",
                style = TextStyle(
                    fontSize = 11.71.sp,
                    lineHeight = 14.64.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF9CA3AF),
                )
            )
        }
    }

}

@Composable
fun barView(height: Int = 10, color:Long = 0xFF6B7280) {
    Box (
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(top = 1.dp, start = 6.dp, end = 6.dp)
            .width(26.dp)
            .height(height.dp)
            .background(Color(color))
    ){

    }

}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun GraphViewPreview() {
    GraphView()
}