package org.elcampico.porradam.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.elcampico.porradam.R
import org.elcampico.porradam.ui.theme.Montserrat

@Composable
fun PantallaBienvenida(
    onEntrar: (alias: String) -> Unit,
    modifier: Modifier = Modifier
) {
    var codigo by rememberSaveable { mutableStateOf("") }
    var alias by rememberSaveable { mutableStateOf("") }

    Box(modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.fondo_pantalla_hd),
            contentDescription = null, // decorativa
            contentScale = ContentScale.Crop, // llena y recorta
            modifier = Modifier.matchParentSize()
        )

        // Degradado oscuro de abajo hacia arriba para que el texto se lea bien
        val scrim = Brush.verticalGradient(
            listOf(Color.Transparent, Color.Black.copy(alpha = 0.8f))
        )
        Box(Modifier.matchParentSize().background(scrim))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
                .navigationBarsPadding(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .padding(horizontal = 24.dp)
            ) {
                Card(
                    modifier = Modifier.matchParentSize(),
                    colors = CardDefaults.cardColors(containerColor = Color.Transparent)
                ) {
                    Text(
                        "Porra DAM",
                        color = Color.White,
                        fontFamily = Montserrat,
                        fontWeight = FontWeight.Bold,
                        fontSize = 50.sp
                    )
                    Text(
                        "Bienvenido a la porra de DAM, donde podrás participar en la predicción de resultados de tus partidos favoritos y ganar premios emocionantes. ¡Únete a nuestra comunidad y demuestra tus habilidades de predicción!",
                        color = Color.White,
                        fontFamily = Montserrat,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(2.dp))

            FormularioEntrada(
                alias = alias,
                codigo = codigo,
                onAliasChange = { alias = it },
                onCodigoChange = { codigo = it },
                onEntrar = { onEntrar(alias) },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun FormularioEntrada(
    alias: String,
    codigo: String,
    onAliasChange: (String) -> Unit,
    onCodigoChange: (String) -> Unit,
    onEntrar: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier.padding(8.dp)) {
        Column(
            modifier = Modifier.padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                "TU ALIAS",
                color = Color.Black,
                fontFamily = Montserrat,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )

            // Campo editable: lo que escribe el usuario se guarda en "alias"
            OutlinedTextField(
                value = alias,
                onValueChange = onAliasChange,
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                shape = RoundedCornerShape(8.dp),
                placeholder = {
                    Text("Escribe tu alias", fontFamily = Montserrat)
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.icono_login),
                        contentDescription = null,
                        tint = Color.Black,
                        modifier = Modifier.size(24.dp)
                    )
                },
                textStyle = TextStyle(
                    fontFamily = Montserrat,
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    color = Color.Black
                ),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black,
                    cursorColor = Color.Black
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = codigo,
                onValueChange = onCodigoChange,
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                shape = RoundedCornerShape(8.dp),
                placeholder = {
                    Text("Escribe tu código de grupo", fontFamily = Montserrat)
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.group),
                        contentDescription = null,
                        tint = Color.Black,
                        modifier = Modifier.size(24.dp)
                    )
                },
                textStyle = TextStyle(
                    fontFamily = Montserrat,
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    color = Color.Black
                ),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black,
                    cursorColor = Color.Black
                )
            )


            Spacer(modifier = Modifier.height(24.dp))

            // Botón "Entrar": solo funciona si el alias no está vacío
            Button(
                onClick = onEntrar,
                enabled = alias.isNotBlank(),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White,
                    disabledContainerColor = Color.Gray,
                    disabledContentColor = Color.White
                )
            ) {
                Text(
                    "Entrar",
                    fontFamily = Montserrat,
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp
                )
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    painter = painterResource(R.drawable.right),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}