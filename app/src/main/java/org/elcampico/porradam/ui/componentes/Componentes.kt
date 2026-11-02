package org.elcampico.porradam.ui.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.elcampico.porradam.ui.theme.PorraDAMTheme

// Círculo de color con las iniciales (en vez del escudo real)
@Composable
fun EscudoEquipo(iniciales: String, color: Color) {
    Box(
        modifier = Modifier
            .size(30.dp)
            .clip(CircleShape)
            .background(color),
        contentAlignment = Alignment.Center
    ) {
        Text(iniciales, color = Color.White, fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.labelSmall)
    }
}

// Escudo + nombre del equipo
@Composable
fun FilaEquipo(nombre: String, iniciales: String, color: Color, modifier: Modifier = Modifier) {
    Row(modifier, verticalAlignment = Alignment.CenterVertically) {
        EscudoEquipo(iniciales, color)
        Spacer(Modifier.width(12.dp))
        Text(nombre, fontWeight = FontWeight.Medium, style = MaterialTheme.typography.bodyMedium)
    }
}

// Recuadro "2 ▾". Solo es dibujo, no se puede pulsar
@Composable
fun SelectorGoles(goles: String) {
    Row(
        modifier = Modifier
            .border(1.dp, Color(0xFFDDDDDD), RoundedCornerShape(8.dp))
            .padding(start = 12.dp, end = 4.dp, top = 4.dp, bottom = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(goles, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleMedium)
        Icon(Icons.Default.ArrowDropDown, contentDescription = null, tint = Color.Gray)
    }
}

// Tarjeta blanca de un partido de la pantalla Jornada
@Composable
fun PartidoCard(
    local: String, inicialesLocal: String, colorLocal: Color, golesLocal: String,
    visitante: String, inicialesVisitante: String, colorVisitante: Color, golesVisitante: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                FilaEquipo(local, inicialesLocal, colorLocal, Modifier.weight(1f))
                SelectorGoles(golesLocal)
                Spacer(Modifier.width(8.dp))
                Icon(Icons.Default.KeyboardArrowUp, contentDescription = null, tint = Color.Gray)
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                FilaEquipo(visitante, inicialesVisitante, colorVisitante, Modifier.weight(1f))
                SelectorGoles(golesVisitante)
                Spacer(Modifier.width(8.dp))
                Icon(Icons.Default.KeyboardArrowDown, contentDescription = null, tint = Color.Gray)
            }
        }
    }
}

// Título grande + subtítulo + un "desplegable" que solo es dibujo
@Composable
fun Cabecera(titulo: String, subtitulo: String, filtro: String) {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Column(Modifier.weight(1f)) {
            Text(titulo, style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
            Text(subtitulo, style = MaterialTheme.typography.bodySmall, color = Color.Gray)
        }
        Text(
            "$filtro ▾",
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier
                .background(Color.White, RoundedCornerShape(8.dp))
                .border(1.dp, Color(0xFFDDDDDD), RoundedCornerShape(8.dp))
                .padding(horizontal = 10.dp, vertical = 6.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PartidoCardPreview() {
    PorraDAMTheme {
        PartidoCard(
            "Atlético Marina", "AM", Color(0xFFB3261E), "2",
            "Racing Costa", "RC", Color(0xFF1565C0), "1"
        )
    }
}