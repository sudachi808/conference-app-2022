package io.github.droidkaigi.confsched2022.feature.sessions

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.droidkaigi.confsched2022.model.DroidKaigi2022Day

@Composable
internal fun SessionDayTab(
    index: Int,
    day: DroidKaigi2022Day,
    showDate: Boolean,
    selected: Boolean,
    onTabClicked: (index: Int) -> Unit
) {
    val tabHeight by animateDpAsState(if (showDate) 56.dp else 32.dp)
    val dateFontSize by animateIntAsState(if (showDate) 24 else 0)

    Tab(
        selected = selected,
        onClick = { onTabClicked(index) },
        modifier = Modifier.height(tabHeight).padding(end = 8.dp).clip(CircleShape)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = day.name,
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    fontSize = 12.sp,
                    fontWeight = FontWeight(500)
                ),
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "${5 + index}",
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    fontSize = dateFontSize.sp,
                    fontWeight = FontWeight(500)
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
