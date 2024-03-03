package com.mahbub.composetry.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahbub.composetry.R

@Composable
fun CircularProgressView() {
    Box(contentAlignment = Alignment.Center) {
        Column (
           horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = "73%",
                style = TextStyle(
                    fontSize = 11.59.sp,
                    //fontFamily = FontFamily(Font(R.font.inter)),
                    fontWeight = FontWeight(700),
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Center,
                )
            )
            Text(
                text = "উপস্থিতির হার",
                style = TextStyle(
                    fontSize = 5.15.sp,
                    //fontFamily = FontFamily(Font(R.font.noto sans bengali)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF6B7280),
                    textAlign = TextAlign.Center,
                )
            )
        }

        val progressSize = 50.dp

        CircularProgressIndicator(
            progress = 1f,
            color = Color(0xFFE5E7EB),
            modifier = Modifier.then(Modifier.size(progressSize)))
        CircularProgressIndicator(
            progress = 0.75f,
            color = Color(0xFFF45252),
            modifier = Modifier.then(Modifier.size(progressSize)))
        CircularProgressIndicator(
            progress = 0.65f,
            color = Color(0xFFEEC59F),
            modifier = Modifier.then(Modifier.size(progressSize).width(90.dp)))
        CircularProgressIndicator(
            progress = 0.50f,
            color = Color(0xFF038969),
            modifier = Modifier
                .then(Modifier.size(progressSize)))

    }
}



@Composable
@Preview(showBackground = true)
fun CircularProgressViewPreview() {
    CircularProgressView()
}