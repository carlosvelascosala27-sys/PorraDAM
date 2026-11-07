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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.elcampico.porradam.R

@Composable
fun Clasificacion(modifier: Modifier = Modifier) {
    Box(modifier.fillMaxSize()) {
        // Capa 1: la foto de la pelota
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
            item { CabeceraClasificacion() }
            item { TablaClasificacion() }
        }
    }
}

// Títulos en blanco y grandes, igual que en Resultados
@Composable
private fun CabeceraClasificacion() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(Modifier.weight(1f)) {
            Text("Clasificación", color = Color.White, fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineMedium)
            Text("Puntos de toda la temporada", color = Color.White,
                style = MaterialTheme.typography.titleMedium)
        }
        Spacer(Modifier.width(8.dp))
        Text(
            "General ▾",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .border(1.dp, Color.White, RoundedCornerShape(14.dp))
                .padding(horizontal = 16.dp, vertical = 10.dp)
        )
    }
}

// La tabla entera dentro de una tarjeta blanca redondeada
@Composable
private fun TablaClasificacion() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(Modifier.padding(vertical = 8.dp, horizontal = 4.dp)) {
            // Títulos de las columnas
            Row(Modifier.padding(horizontal = 12.dp, vertical = 8.dp)) {
                Text("#", Modifier.width(38.dp), color = Color.Gray, style = MaterialTheme.typography.labelSmall)
                Text("Participante", Modifier.weight(1f), color = Color.Gray, style = MaterialTheme.typography.labelSmall)
                Text("Puntos", color = Color.Gray, style = MaterialTheme.typography.labelSmall)
            }
            HorizontalDivider(color = Color(0xFFEEEEEE))

            // Los 3 primeros llevan medalla: oro, plata y bronce
            FilaClasificacion("1", "CV", "Carlos.V", "45", Color(0xFFE57373), colorMedalla = Color(0xFFFFD54F))
            FilaClasificacion("2", "AB", "Anass.B", "41", Color(0xFF64B5F6), colorMedalla = Color(0xFFCFD8DC))
            FilaClasificacion("3", "JT", "Javi_Turras", "40", Color(0xFFBA68C8), colorMedalla = Color(0xFFFFAB91))
            // Tu fila: fondo verde y en negrita
            FilaClasificacion("4", "CH", "Cristian.H", "38", Color(0xFF2E7D32), fondo = Color(0xFFE8F5E9), negrita = FontWeight.Bold)
            FilaClasificacion("5", "GB", "Gonzalo.B", "35", Color(0xFFFFB74D))
            FilaClasificacion("6", "HS", "Hila_sanchez", "33", Color(0xFF9575CD))
            FilaClasificacion("7", "JM", "Javier.M", "30", Color(0xFF4DD0E1))
            FilaClasificacion("8", "JF", "Javier.F", "27", Color(0xFF81C784))
            FilaClasificacion("9", "FP", "Fran.P", "26", Color(0xFFF06292))
            FilaClasificacion("10", "JM", "Josep.M", "19", Color(0xFFFF8A65))
        }
    }
}

@Composable
private fun FilaClasificacion(
    posicion: String,
    inicial: String,
    nombre: String,
    puntos: String,
    colorAvatar: Color,
    colorMedalla: Color = Color.Transparent,
    fondo: Color = Color.Transparent,
    negrita: FontWeight = FontWeight.Normal
) {
    Row(
        Modifier
            .fillMaxWidth()
            .background(fondo, RoundedCornerShape(16.dp))
            .padding(horizontal = 12.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Número de posición (con circulito de color si es medalla)
        Box(
            Modifier
                .size(26.dp)
                .clip(CircleShape)
                .background(colorMedalla),
            contentAlignment = Alignment.Center
        ) {
            Text(posicion, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.labelLarge)
        }
        Spacer(Modifier.width(12.dp))
        // Avatar de color con las iniciales
        Box(
            Modifier
                .size(34.dp)
                .clip(CircleShape)
                .background(colorAvatar),
            contentAlignment = Alignment.Center
        ) {
            Text(inicial, color = Color.White, fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.labelMedium)
        }
        Spacer(Modifier.width(12.dp))
        Text(nombre, Modifier.weight(1f), fontWeight = negrita)
        Text(puntos, fontWeight = FontWeight.Bold)
    }
}