package org.elcampico.porradam.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun Perfil(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            // Fondo naranja amanecer: degradado de dorado a marrón oscuro
            .background(
                Brush.verticalGradient(
                    listOf(Color(0xFFF6B24A), Color(0xFFE8792E), Color(0xFF9A3A1A), Color(0xFF3A1A10))
                )
            )
            .statusBarsPadding()     // hueco para la hora y la batería
            .padding(top = 64.dp),   // hueco para la barra "Porra DAM"
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item { CabeceraPerfil() }
        item { Estadisticas() }
        item { Historial() }
        item { SalirDelGrupo() }
    }
}

// Avatar grande con iniciales, alias y grupo
@Composable
private fun CabeceraPerfil() {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            Modifier
                .size(84.dp)
                .background(Color(0xFFE24B4A), CircleShape)
                .border(3.dp, Color.White, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text("CV", color = Color.White, fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineSmall)
        }
        Spacer(Modifier.height(10.dp))
        Text("Carlos.V", color = Color.White, fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineSmall)
        Text("Grupo: 1A - DAM - 2026", color = Color.White,
            style = MaterialTheme.typography.bodyMedium)
    }
}

// Los 3 cuadritos: puntos, puesto y exactos
@Composable
private fun Estadisticas() {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        CuadroEstadistica("45", "puntos", Color(0xFF3B6D11), Modifier.weight(1f))
        CuadroEstadistica("1º", "puesto", Color(0xFF854F0B), Modifier.weight(1f))
        CuadroEstadistica("3", "exactos", Color(0xFF185FA5), Modifier.weight(1f))
    }
}

@Composable
private fun CuadroEstadistica(valor: String, etiqueta: String, color: Color, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(valor, color = color, fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineSmall)
            Text(etiqueta, color = Color.Gray, style = MaterialTheme.typography.labelSmall)
        }
    }
}

// Puntos de cada jornada
@Composable
private fun Historial() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(Modifier.padding(horizontal = 16.dp, vertical = 6.dp)) {
            Text("Historial", color = Color.Gray, style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.padding(top = 8.dp, bottom = 4.dp))
            FilaHistorial("Jornada 1", "+24 pts")
            FilaHistorial("Jornada 2", "+21 pts")
        }
    }
}

@Composable
private fun FilaHistorial(jornada: String, puntos: String) {
    HorizontalDivider(color = Color(0xFFE0E0E0))
    Row(Modifier.padding(vertical = 10.dp)) {
        Text(jornada, Modifier.weight(1f))
        Text(puntos, color = Color(0xFF3B6D11), fontWeight = FontWeight.Bold)
    }
}

// Botón rojo de salir (solo dibujo, no hace nada)
@Composable
private fun SalirDelGrupo() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.AutoMirrored.Filled.ExitToApp, contentDescription = null,
                tint = Color(0xFFA32D2D))
            Spacer(Modifier.width(10.dp))
            Text("Salir del grupo", color = Color(0xFFA32D2D), fontWeight = FontWeight.Bold)
        }
    }
}