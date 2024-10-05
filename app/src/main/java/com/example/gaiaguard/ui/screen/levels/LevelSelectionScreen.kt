package com.example.gaiaguard.ui.screen.levels

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gaiaguard.R

@Composable
fun LevelSelectionScreen(onLevelSelected: (Int) -> Unit) {
    var selectedLevel by remember { mutableStateOf(1) } // Nivel seleccionado por defecto

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.level_selection),
            style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold)
        )

        Spacer(modifier = Modifier.height(128.dp))

        // Botones de selección de nivel
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            LevelButton(
                level = 1,
                isSelected = selectedLevel == 1,
                onClick = { selectedLevel = 1 }
            )
            LevelButton(
                level = 2,
                isSelected = selectedLevel == 2,
                onClick = { selectedLevel = 2 }
            )
            LevelButton(
                level = 3,
                isSelected = selectedLevel == 3,
                onClick = { selectedLevel = 3 }
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Botón para continuar
        Button(
            onClick = { onLevelSelected(selectedLevel) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(id = R.string.continue_button))
        }
    }
}

@Composable
fun LevelButton(level: Int, isSelected: Boolean, onClick: () -> Unit) {
    Button(
        onClick = onClick,
    ) {
        Text("Nivel $level")
    }
}

@Composable
@Preview(showSystemUi = true)
fun LevelSelectionScreenPreview() {
    LevelSelectionScreen(onLevelSelected = {})
}
