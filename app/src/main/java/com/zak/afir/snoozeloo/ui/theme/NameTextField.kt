@file:OptIn(ExperimentalFoundationApi::class)

package com.zak.afir.snoozeloo.ui.theme

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.text2.input.TextFieldLineLimits
import androidx.compose.foundation.text2.input.TextFieldState
import androidx.compose.foundation.text2.input.rememberTextFieldState
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NameTextField(
    state: TextFieldState,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    var isFocused by remember {
        mutableStateOf(false)
    }
    BasicTextField2(
        state = state,
        textStyle = LocalTextStyle.current.copy(
            color = Color.Blue
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        ),
        lineLimits = TextFieldLineLimits.SingleLine,
        cursorBrush = SolidColor(MaterialTheme.colorScheme.onBackground),
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(
                if (isFocused) {
                    MaterialTheme.colorScheme.primary.copy(
                        alpha = 0.05f
                    )
                } else {
                    Color.Gray
                }
            )
            .border(
                width = 1.dp,
                color = if (isFocused) {
                    MaterialTheme.colorScheme.primary
                } else {
                    Color.Transparent
                },
                shape = RoundedCornerShape(16.dp)
            )
            .padding(12.dp)
            .onFocusChanged {
                isFocused = it.isFocused
            }
    )
}

@Preview
@Composable
private fun RuniqueTextFieldPreview() {
    SnoozelooTheme {
        TimeTextField(
            state = rememberTextFieldState()
        )
    }
}