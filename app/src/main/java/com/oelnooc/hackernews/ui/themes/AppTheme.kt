package com.oelnooc.hackernews.ui.themes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp

object AppTheme {

    @Composable
    fun myAppTheme(content: @Composable () -> Unit) {
        MaterialTheme(
            colorScheme = darkColorScheme(
                background = AppColor.white,
                onBackground = AppColor.black,
                primary = AppColor.red
            ),
            typography = Typography(),
            shapes = Shapes(),
            content = content
        )
    }

    @Composable
    fun listItem(title: String, subtitle: String) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(AppColor.white)
        ) {
            Text(text = title, color = AppColor.black, fontSize = TextUnit(24F, TextUnitType.Sp))
            Text(text = subtitle, color = AppColor.darkGray)
        }
    }
}