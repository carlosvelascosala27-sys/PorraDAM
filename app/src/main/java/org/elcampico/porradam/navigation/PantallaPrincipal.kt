package org.elcampico.porradam.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.elcampico.porradam.screens.Clasificacion
import org.elcampico.porradam.screens.Jornada
import org.elcampico.porradam.screens.Perfil
import org.elcampico.porradam.screens.Resultados

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaPrincipal(
    alias: String,
    modifier: Modifier = Modifier
) {
    // Guardamos la pestaña seleccionada. rememberSaveable la conserva al girar el móvil.
    var pestana by rememberSaveable { mutableStateOf(Pestanas.JORNADA) }

    // Si estamos en otra pestaña y pulsamos "atrás", volvemos a Jornada en vez de salir de la app.
    BackHandler(enabled = pestana != Pestanas.JORNADA) {
        pestana = Pestanas.JORNADA
    }

    Scaffold(
        modifier = modifier,
        containerColor = Color(0xFFF4F5F7),   // fondo gris claro para que destaquen las tarjetas blancas
        topBar = {
            // Transparente en Jornada y Resultados (se ve la pelota); negra en las demás
            CenterAlignedTopAppBar(
                title = { Text("Porra DAM", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    Icon(Icons.Default.Menu, contentDescription = null, modifier = Modifier.padding(start = 16.dp))
                },
                actions = { // Mostramos los puntos del usuario en la esquina superior derecha
                    Text(
                        "38 pts",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .border(1.dp, Color.White, RoundedCornerShape(50))
                            .padding(horizontal = 10.dp, vertical = 4.dp)
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = if (pestana == Pestanas.PERFIL) Color(0xFF14181F) else Color.Transparent,
                    scrolledContainerColor = Color.Unspecified,
                    navigationIconContentColor = Color.White,
                    titleContentColor = Color.White,
                    actionIconContentColor = Color.Unspecified
                )
            )
        },

        bottomBar = { // La barra de abajo con los iconos de las pestañas. Se ve en todas las pantallas.
            // NavigationBar es la barra de abajo; dentro creamos un botón por cada pestaña.
            NavigationBar(containerColor = Color.White) {
                Pestanas.entries.forEach { p ->
                    NavigationBarItem(
                        selected = pestana == p,
                        onClick = { pestana = p },
                        icon = { Icon(imageVector = p.icono, contentDescription = null) },
                        label = { Text(p.titulo) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color(0xFF2E7D32),
                            selectedTextColor = Color(0xFF2E7D32),
                            indicatorColor = Color.Transparent,
                            unselectedIconColor = Color.Gray,
                            unselectedTextColor = Color.Gray
                        )
                    )
                }
            }
        }
    ) { innerPadding ->
        // innerPadding deja hueco para la topBar y la bottomBar, para que el contenido no quede tapado.
        val m = Modifier.padding(innerPadding)
        when (pestana) {
            Pestanas.JORNADA -> Jornada(alias, Modifier.padding(bottom = innerPadding.calculateBottomPadding()))
            // Igual que Jornada: sin hueco arriba, para que la foto llegue detrás de la barra
            Pestanas.RESULTADOS -> Resultados(Modifier.padding(bottom = innerPadding.calculateBottomPadding()))
            Pestanas.CLASIFICACION -> Clasificacion(Modifier.padding(bottom = innerPadding.calculateBottomPadding()))
            Pestanas.PERFIL -> Perfil(m)
        }
    }
}