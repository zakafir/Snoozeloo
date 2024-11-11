package com.zak.afir.snoozeloo.screens.addAlarm

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zak.afir.snoozeloo.R
import com.zak.afir.snoozeloo.screens.showAlarms.AlarmsScreenAction
import com.zak.afir.snoozeloo.ui.theme.NameTextField
import com.zak.afir.snoozeloo.ui.theme.TimeTextField
import com.zak.afir.snoozeloo.ui.theme.SnoozelooTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun AddNewAlarmScreenRoot(
    viewModel: AddNewAlarmViewModel = koinViewModel(),
    onNavigateBack: () -> Boolean
) {
    AddNewAlarmScreenRootScreen(viewModel.state, onAction = { action ->
        when (action) {
            NewAlarmAction.OnNavigateBack -> onNavigateBack()
            else -> {}
        }
        viewModel.onAction(action)
    }
    )
}

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
private fun AddNewAlarmScreenRootScreen(
    state: NewAlarmState,
    onAction: (NewAlarmAction) -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {

                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            onAction(NewAlarmAction.OnNavigateBack)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                actions = {
                    Button(
                        onClick = {
                            onAction(NewAlarmAction.OnSaveAlarmClicked)
                        }
                    ) {
                        Text(text = stringResource(R.string.save_alarm))
                    }
                }
            )
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TimeTextField(
                    state = state.hours
                )
                Text(":")
                TimeTextField(
                    state = state.minutes
                )
            }
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(stringResource(R.string.alarm_name_label))
                NameTextField(
                    state = state.alarmName
                )
            }
        }
    }
}

@Preview
@Composable
private fun AddNewAlarmScreenRootScreenPreview() {
    SnoozelooTheme {
        AddNewAlarmScreenRootScreen(
            state = NewAlarmState(),
            onAction = {}
        )
    }
}