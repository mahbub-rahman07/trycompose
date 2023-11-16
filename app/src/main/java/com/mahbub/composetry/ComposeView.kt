package com.mahbub.composetry

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun TextCompose(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold,
        color = Color.Red,
        fontSize = MaterialTheme.typography.headlineLarge.fontSize,
        modifier = modifier.padding(8.dp),
    )
}

@Composable
fun ImageCompose() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = "Android Logo",
        colorFilter = ColorFilter.tint(Color.Red),
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .padding(8.dp)

    )

}

@Composable
fun ButtonCompose() {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier.padding(8.dp),
        colors= ButtonDefaults.buttonColors(
            containerColor = Color.Red,
            contentColor = Color.White
        ),
        enabled = true
    ) {
        Text(text = "Button")
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Button",
            modifier = Modifier
                .padding(start = 8.dp)
                .size(24.dp)
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TFCompose() {
    val state = remember {
        mutableStateOf("")
    }
    TextField(
        value = "${state.value}",
        onValueChange = { /*TODO*/ },
        label = { Text("Label") },
        modifier = Modifier.padding(8.dp)

    )

}
@Composable
fun ColumnCompose() {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TextCompose("Compose")
        ImageCompose()
        ButtonCompose()
        TFCompose()
    }

}
@Composable
fun RowCompose() {
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        TextCompose("Compose")
        ImageCompose()
        ButtonCompose()

    }

}

@Composable
fun BoxCompose() {
    Box(
        contentAlignment = Alignment.TopEnd,
    ){
        ImageCompose()
        TextCompose("Compose")
    }

}
