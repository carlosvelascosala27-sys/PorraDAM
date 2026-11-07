package org.elcampico.porradam.screens

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.elcampico.porradam.R
import org.elcampico.porradam.ui.componentes.FilaEquipo

@Composable
fun Resultados(modifier: Modifier = Modifier) {
    Box(modifier.fillMaxSize()) {
        // Capa 1: la foto de la pelota, ocupando toda la pantalla
        Image(
            painter = painterResource(R.drawable.fondo_pantalla_hd),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )
        // Capa 2: velo negro semitransparente
        Box(
            Modifier
                .matchParentSize()
                .background(Color(0x99000000))
        )

        // Capa 3: el contenido
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()     // hueco para la hora y la batería
                .padding(top = 64.dp),   // hueco para la barra "Porra DAM"
            contentPadding = PaddingValues(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item { CabeceraResultados() }
            item { ResultadoCard("Atlético Madrid", R.drawable.escudo_atletico_madrid, "2", "Real Madrid", R.drawable.escudo_real_madrid, "1", "Tu porra: 2 - 1", "+8") }
            item { ResultadoCard("FC Barcelona", R.drawable.escudo_barcelona, "3", "Villarreal CF", R.drawable.escudo_villarreal, "0", "Tu porra: 2 - 0", "+4") }
            item { ResultadoCard("Sevilla FC", R.drawable.escudo_sevilla, "1", "Real Sociedad", R.drawable.escudo_real_sociedad, "1", "Tu porra: 1 - 0", "+2") }
            item { ResultadoCard("Real Betis", R.drawable.escudo_betis, "2", "Valencia CF", R.drawable.escudo_valencia, "1", "Tu porra: 1 - 1", "+2") }
            item { ResultadoCard("Athletic Club", R.drawable.escudo_athletic, "1", "Celta de Vigo", R.drawable.escudo_celta, "0", "Tu porra: 1 - 0", "+8") }
            item { TotalJornada() }
        }
    }
}

// Títulos en blanco y grandes, como en Jornada, y el selector más grande
@Composable
private fun CabeceraResultados() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(Modifier.weight(1f)) {
            Text("Resultados", color = Color.White, fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineMedium)
            Text("Resultados oficiales y puntos obtenidos", color = Color.White,
                style = MaterialTheme.typography.titleMedium)
        }
        Spacer(Modifier.width(8.dp))
        Text(
            "Jornada 1 ▾",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .border(1.dp, Color.White, RoundedCornerShape(14.dp))
                .padding(horizontal = 16.dp, vertical = 10.dp)
        )
    }
}

// Tarjeta de un partido ya jugado, con las esquinas más redondeadas
@Composable
private fun ResultadoCard(
    local: String,
    escudoLocal: Int,
    golesLocal: String,
    visitante: String,
    escudoVisitante: Int,
    golesVisitante: String,
    porra: String,
    puntos: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(Modifier.padding(18.dp), verticalAlignment = Alignment.CenterVertically) {
            Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    FilaEquipo(local, escudoLocal, Modifier.weight(1f))
                    Text(golesLocal, fontWeight = FontWeight.Bold)
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    FilaEquipo(visitante, escudoVisitante, Modifier.weight(1f))
                    Text(golesVisitante, fontWeight = FontWeight.Bold)
                }
                // Etiqueta verde con mi pronóstico
                Text(
                    porra,
                    color = Color(0xFF2E7D32),
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier
                        .background(Color(0x1F2E7D32), RoundedCornerShape(8.dp))
                        .padding(horizontal = 8.dp, vertical = 3.dp)
                )
            }
            Spacer(Modifier.width(16.dp))
            // Cuadrado redondeado con los puntos
            Box(
                Modifier
                    .size(48.dp)
                    .background(Color(0x1F2E7D32), RoundedCornerShape(14.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(puntos, color = Color(0xFF2E7D32), fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
private fun TotalJornada() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(Modifier.padding(18.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Default.Star, contentDescription = null, tint = Color(0xFFF9A825))
            Spacer(Modifier.width(8.dp))
            Text("Total jornada", Modifier.weight(1f))
            Text("+24 pts", color = Color(0xFF2E7D32), fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleMedium)
        }
    }
}