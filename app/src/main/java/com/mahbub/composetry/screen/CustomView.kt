package com.mahbub.composetry.screen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mahbub.composetry.R


@Composable
fun CustomTextViewH1(title:String, lanCode:String, color:Color, ) {

//    val fontFamily  =if(lanCode == "bn"){
//        FontFamily(Font(R.font.noto sans bengali)),
//    }else {
//
//    }
    Text(
        text = title,
        style = TextStyle(
            fontSize = 16.sp,
//            fontFamily = fontFamily,
            fontWeight = FontWeight(600),
            color = color,
        )
    )
}