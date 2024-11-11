package com.zak.afir.snoozeloo.screens.showAlarms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zak.afir.snoozeloo.R
import com.zak.afir.snoozeloo.ui.theme.SnoozelooTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun AlarmsScreenRoot(
    viewModel: AlarmsViewModel = koinViewModel(),
    onAddNewAlarmClick: () -> Unit
) {
    AlarmsScreen(onAction = { action ->
        when (action) {
            AlarmsScreenAction.OnAddNewAlarmClick -> onAddNewAlarmClick()
        }
    })
}

@Composable
private fun AlarmsScreen(
    onAction: (AlarmsScreenAction) -> Unit
) {
    Scaffold(
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        bottom = 16.dp
                    ),
                contentAlignment = Alignment.Center
            ) {
                FloatingActionButton(
                    onClick = {
                        onAction(AlarmsScreenAction.OnAddNewAlarmClick)
                    },
                    modifier = Modifier.padding(16.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = "Add Alarm"
                    )
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Default.Call,
                contentDescription = null
            )
            Text(stringResource(R.string.no_alarms_defined))
        }
    }
}

@Preview
@Composable
private fun AlarmsScreenPreview() {
    SnoozelooTheme {
        AlarmsScreen(
            /*state = (),*/
            onAction = {}
        )
    }
}