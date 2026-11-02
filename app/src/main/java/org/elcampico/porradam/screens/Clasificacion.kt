package org.elcampico.porradam.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.elcampico.porradam.ui.componentes.Cabecera

@Composable
fun Clasificacion(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        contentPadding = PaddingValues(16.dp)
    ) {
        item { Cabecera("Clasificación", "Puntos de toda la temporada", "General") }
        item { Spacer(Modifier.height(12.dp)) }
        item {
            Row(Modifier.padding(horizontal = 12.dp, vertical = 6.dp)) {
                Text("#", Modifier.width(38.dp), color = Color.Gray, style = MaterialTheme.typography.labelSmall)
                Text("Participante", Modifier.weight(1f), color = Color.Gray, style = MaterialTheme.typography.labelSmall)
                Text("Puntos", color = Color.Gray, style = MaterialTheme.typography.labelSmall)
            }
            HorizontalDivider(color = Color(0xFFEEEEEE))
        }
        // Los 3 primeros llevan medalla: oro, plata y bronce
        item { FilaClasificacion("1", "L", "Lucía R.", "45", Color(0xFFE57373), colorMedalla = Color(0xFFFFD54F)) }
        item { FilaClasificacion("2", "P", "PabloDev", "41", Color(0xFF64B5F6), colorMedalla = Color(0xFFCFD8DC)) }
        item { FilaClasificacion("3", "N", "Nerea_K", "40", Color(0xFFBA68C8), colorMedalla = Color(0xFFFFAB91)) }
        // Tu fila: fondo verde y en negrita
        item { FilaClasificacion("4", "T", "Tú", "38", Color(0xFF2E7D32), fondo = Color(0xFFE8F5E9), negrita = FontWeight.Bold) }
        item { FilaClasificacion("5", "H", "Hugo M.", "35", Color(0xFFFFB74D)) }
        item { FilaClasificacion("6", "A", "Aitana", "33", Color(0xFF9575CD)) }
        item { FilaClasificacion("7", "X", "xavier.dev", "30", Color(0xFF4DD0E1)) }
        item { FilaClasificacion("8", "I", "Iván G.", "27", Color(0xFF81C784)) }
        item { FilaClasificacion("9", "S", "Sara P.", "26", Color(0xFFF06292)) }
        item { FilaClasificacion("10", "D", "Dani_804", "19", Color(0xFFFF8A65)) }
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
            .background(fondo, RoundedCornerShape(8.dp))
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
        // Avatar de color con la inicial
        Box(
            Modifier
                .size(34.dp)
                .clip(CircleShape)
                .background(colorAvatar),
            contentAlignment = Alignment.Center
        ) {
            Text(inicial, color = Color.White, fontWeight = FontWeight.Bold)
        }
        Spacer(Modifier.width(12.dp))
        Text(nombre, Modifier.weight(1f), fontWeight = negrita)
        Text(puntos, fontWeight = FontWeight.Bold)
    }
}