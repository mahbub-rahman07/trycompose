package com.mahbub.composetry.screen

import android.os.Build.VERSION.SDK_INT
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest


private val emojis = mutableMapOf(
    0 to "https://media.giphy.com/media/3XWZHZ1hnygZtn2B7d/giphy.gif",
    1 to "https://media.giphy.com/media/jsNiI5nMGQurggwpkN/giphy.gif",
    2 to "https://media.giphy.com/media/L1bqiQs0bibjqG9zXZ/giphy.gif",
    3 to "https://media.giphy.com/media/Pn1h5Un3LZD9uq3u07/giphy.gif",
    4 to "https://media.giphy.com/media/3XWZHZ1hnygZtn2B7d/giphy.gif",
    4 to "https://media.giphy.com/media/3XWZHZ1hnygZtn2B7d/giphy.gif",
    5 to "https://media.giphy.com/media/8YBM61XW2vZJykO0j4/giphy.gif",
)
private val problems = mutableListOf<String>(
    "Video is not playing",
    "Black screen issue",
    "Audio is not working",
    "Teaching style not good",
    "Comment section is so bad",
    "Teacher do not reply",
    "Video lage too much",
)

@Composable
fun MyScreenContent() {
    val currentState = remember {
        mutableStateOf(0)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // 1. Top Bar
        TopBar()
        val imageLoader = ImageLoader.Builder(LocalContext.current)
            .components {
                if (SDK_INT >= 28) {
                    add(ImageDecoderDecoder.Factory())
                } else {
                    add(GifDecoder.Factory())
                }
            }
            .build()

        // 2. Image View
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("${emojis[currentState.value]}")
                .crossfade(true)
                .build(),
            imageLoader = imageLoader,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(vertical = 16.dp)
        )
//        Image(
//            painter = rememberCoilPainter(request = "https://raw.githubusercontent.com/Tarikul-Islam-Anik/Animated-Fluent-Emojis/master/Emojis/Smilies/Beaming%20Face%20with%20Smiling%20Eyes.png"),
//            contentDescription = null,
//            contentScale = ContentScale.Crop,
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(200.dp)
//                .padding(vertical = 16.dp)
//        )

        // 3. Title
        Text(
            text = "Title Goes Here",
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            textAlign = TextAlign.Center
        )

        // 4. Rating Row
        RatingRow { currentState.value = it + 1 }

        // 5. List of Items with Grid Style
        ItemGrid()
    }
}

@Composable
fun AppToolBar() {
    TopAppBar(
        title = { Text(text = "Compose Try") },
        actions = {
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(Icons.Default.Close, contentDescription = null)
            }
        },
        backgroundColor = Color.White,
        contentColor = Color.Black,
        elevation = 0.dp,
        navigationIcon = {
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(Icons.Default.ArrowBack, contentDescription = null)
            }
        }
    )
}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(MaterialTheme.colors.background),
    ) {
        // Title
        Text(
            text = "Top Title",
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp),
            style = MaterialTheme.typography.h6
        )

        // Close Button
        IconButton(
            onClick = { /* Handle close button click here */ },
            modifier = Modifier
                .padding(end = 16.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = null
            )
        }
    }

    // Gray line under the top bar
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(MaterialTheme.colors.onSurface.copy(alpha = 0.1f))
    )
}

@Composable
fun RatingRow(onClick: (Int) -> Unit) {

    val filledStars = remember {
        mutableStateOf(-1)
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(5) { index ->
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = null,
                modifier = Modifier
                    .size(32.dp)
                    .clickable {
                        if (index == filledStars.value) {
                            filledStars.value -= index
                        } else {
                            filledStars.value = index
                        }
                        onClick(index)
                    },
                tint = if (filledStars.value >= index) {
                    Color.Black
                } else {
                    Color.Gray
                }
            )
        }
    }
}

@Composable
fun ItemGrid() {
    // Dummy list of items
    val items = problems

    LazyVerticalGrid(
        columns = GridCells.Adaptive(100.dp),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)

    ) {
        items(items.size) { index ->
            ItemCard(item = items[index])
        }
    }
}

@Composable
fun ItemCard(item: String) {
    val state = remember {
        mutableLongStateOf(0xFFE5E7EB)
    }
    val animatedColor by animateColorAsState(
        if (state.value == 0xFFE5E7EB) Color(0xFF000000) else Color(0xFFFFFFFF), label = ""
    )
    Card(
        shape = RoundedCornerShape(size = 46.dp),
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Color(0xFFE5E7EB),
                shape = RoundedCornerShape(size = 46.dp)
            )
            .clip(RoundedCornerShape(size = 46.dp))
            .fillMaxWidth()
            .clickable {
                state.value = if (state.value == 0xFFE5E7EB) {
                    0xFF000000
                } else {
                    0xFFE5E7EB
                }
            },
        backgroundColor = Color(state.value)

    ) {
        Text(
            text = item,
            color = animatedColor,
            style = MaterialTheme.typography.body2,
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 12.dp, top = 10.dp, end = 12.dp, bottom = 10.dp)


        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMyScreenContent() {
    //MyScreenContent()
}

@Preview()
@Composable
fun PreviewAppToolBar() {
    AppToolBar()
}