package org.elcampico.porradam.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun Perfil(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            Modifier
                .size(96.dp)
                .clip(CircleShape)
                .background(Color(0xFF2E7D32)),
            contentAlignment = Alignment.Center
        ) {
            Icon(Icons.Default.Person, contentDescription = null, tint = Color.White,
                modifier = Modifier.size(56.dp))
        }
        Spacer(Modifier.height(16.dp))
        Text("Tu perfil", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
        Text("Grupo: 1A - DAM - 2026", color = Color.Gray)
        Spacer(Modifier.height(8.dp))
        Text("38 pts · 4º puesto", color = Color(0xFF2E7D32), fontWeight = FontWeight.Bold)
    }
}