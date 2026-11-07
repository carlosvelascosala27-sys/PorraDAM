
package org.elcampico.porradam.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import org.elcampico.porradam.ui.componentes.PartidoCard

@Composable
fun Jornada(alias: String, modifier: Modifier = Modifier) {
    Box(modifier.fillMaxSize()) {
        // Capa 1: la foto de la pelota, ocupando toda la pantalla
        Image(
            painter = painterResource(R.drawable.fondo_pantalla_hd),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )
        // Capa 2: un velo negro semitransparente para que se lea todo bien
        Box(
            Modifier
                .matchParentSize()
                .background(Color(0x99000000))
        )

        // Capa 3: el contenido de la pantalla
        Column(Modifier.fillMaxSize()) {
            // Títulos, más grandes y todo en blanco
            Column(
                Modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
                    .padding(top = 64.dp)
                    .padding(horizontal = 16.dp)
            ) {
                Text("Jornada 1", color = Color.White, fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineMedium)
                Text("Tu porra para esta jornada", color = Color.White,
                    style = MaterialTheme.typography.titleMedium)
                Spacer(Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.DateRange, contentDescription = null,
                        tint = Color.White, modifier = Modifier.size(18.dp))
                    Spacer(Modifier.width(6.dp))
                    Text("Se cierra el: Sáb 12 oct · 16:00", color = Color.White,
                        style = MaterialTheme.typography.bodyMedium)
                }
            }

            // Los 5 partidos
            LazyColumn(
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item { PartidoCard("Atlético Madrid", R.drawable.escudo_atletico_madrid, "2", "Real Madrid", R.drawable.escudo_real_madrid, "1") }
                item { PartidoCard("FC Barcelona", R.drawable.escudo_barcelona, "3", "Villarreal CF", R.drawable.escudo_villarreal, "0") }
                item { PartidoCard("Sevilla FC", R.drawable.escudo_sevilla, "1", "Real Sociedad", R.drawable.escudo_real_sociedad, "1") }
                item { PartidoCard("Real Betis", R.drawable.escudo_betis, "2", "Valencia CF", R.drawable.escudo_valencia, "1") }
                item { PartidoCard("Athletic Club", R.drawable.escudo_athletic, "1", "Celta de Vigo", R.drawable.escudo_celta, "0") }
            }

            // onClick vacío: Compose obliga a ponerlo, pero no hace nada
            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp)
                    .height(52.dp),
                shape = RoundedCornerShape(26.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color.Black)
            ) {
                Text("Guardar pronósticos", fontWeight = FontWeight.Bold)
            }
        }
    }
}