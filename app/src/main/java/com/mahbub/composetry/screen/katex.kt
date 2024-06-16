package com.mahbub.composetry.screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import kotlinx.coroutines.launch
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import kotlin.math.min


fun fetchLatexImageUrl(latex: String): String {
//    val encodedLatex = URLEncoder.encode(latex, StandardCharsets.UTF_8.toString())
//    val url = "http://quicklatex.com/latex3.f/quicklatex.com-d9b9a5a2f9e4f9a5089af9f0d9f0e2e2.png?formula=$encodedLatex"
//    // Optionally, handle the network request and error handling here
//    Log.d("LatexQuestion", "Fetching LaTeX image from: $url")
//
//    return url

    val encodedLatex = URLEncoder.encode(latex, StandardCharsets.UTF_8.toString())
    val url =  "https://latex.codecogs.com/png.latex?${encodedLatex.replace("+", "%20")}"
    Log.d("LatexQuestion", "Fetching LaTeX image from: $url")
    return url
}

@Composable
fun LatexQuestion(latex: String) {
    val coroutineScope = rememberCoroutineScope()
    val imageUrl = remember { mutableStateOf<String?>(null) }

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            imageUrl.value = fetchLatexImageUrl(latex)
        }
    }


    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Question:", fontSize = 18.sp)
        imageUrl.value?.let {
            Image(
                painter = rememberAsyncImagePainter(model = it, filterQuality = FilterQuality.High),
                contentDescription = "LaTeX equation",
                modifier = Modifier.fillMaxWidth().heightIn(min=30.dp).padding(top = 8.dp)
            )
        }
    }
}

@Composable
fun LatexQuestions(questions: List<String>) {
    Column(modifier = Modifier.fillMaxSize()) {
        questions.forEach { question ->
            LatexQuestion(latex = question)
        }
    }
}

@Composable
@Preview
fun MathViewScreenPreview() {
    val sampleQuestions = listOf(
        "\\frac{a}{b}",
        "a+b=c",
        "E = mc^2",
        "\\int_0^\\infty e^{-x}\\,dx=1"
    )

    MaterialTheme {
        Surface {
            LatexQuestions(questions = sampleQuestions)
        }
    }
}