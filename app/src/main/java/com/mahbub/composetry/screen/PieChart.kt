import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class PieChartEntry(val color: Color, val percentage: Float)

fun calculateStartAngles(entries: List<PieChartEntry>): List<Float> {
    var totalPercentage = 0f
    return entries.map { entry ->
        val startAngle = totalPercentage * 360
        totalPercentage += entry.percentage
        startAngle
    }
}

@Composable
fun PieChart(percentageText:String, subText:String,entries: List<PieChartEntry>) {

    Box(
        contentAlignment = androidx.compose.ui.Alignment.Center,
    ) {
        Canvas(modifier = Modifier.size(150.dp).rotate(90f)) {
            val startAngles = calculateStartAngles(entries)
            entries.forEachIndexed { index, entry ->
                drawArc(
                    color = entry.color,
                    startAngle = startAngles[index],
                    sweepAngle = entry.percentage * 360f,
                    useCenter = true,
                    topLeft = Offset.Zero,
                    size = this.size
                )
            }
        }

        Column(
            modifier = Modifier.size(100.dp).
            background(Color.White, shape = RoundedCornerShape(50.dp)),
            verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center,
            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
        ) {

            Text(
                text = percentageText,
                style = TextStyle(
                    fontSize = 11.59.sp,
//                    fontFamily = FontFamily(Font(R.font.inter)),
                    fontWeight = FontWeight(700),
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Center,
                )
            )
            Text(
                text = subText,
                style = TextStyle(
                    fontSize = 5.15.sp,
//                    fontFamily = FontFamily(Font(R.font.noto sans bengali)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF6B7280),
                    textAlign = TextAlign.Center,
                )
            )
        }
    }


}

@Composable
@Preview
fun PieChartPreview() {
    val entries = listOf(
        PieChartEntry(Color(0xFFEEC59F), 0.2f),
        PieChartEntry(Color(0xFFF45252), 0.2f),
        PieChartEntry(Color(0xFFE5E7EB), 0.1f),
        PieChartEntry(Color(0xFF038969), 0.5f)
    )
    PieChart("73%", "উপস্থিতির হার",entries)
}