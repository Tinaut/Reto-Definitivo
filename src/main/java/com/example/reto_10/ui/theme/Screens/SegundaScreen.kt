package com.example.reto_10.ui.theme.Screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.reto_10.R

val Rick = "Rick acaba de mudarse a casa de su hija Beth y allí recuerda que tiene un nieto llamado " +
           "Morty. Sin preguntar a nadie, decide que va a obligarle a que le acompañe a todo tipo de" +
           " aventuras para que el chico se vuelva inteligente como él y no se convierta en un idiota " +
           "como Jerry, padre de Morty y yerno de Rick."

val Friends = "La serie es una comedia que trata de las aventuras y desventuras de un grupo de " +
              "6 amigos (Ross, Joey, Chandler, Phoebe, Rachel y Monica) que viven en Manhattan, " +
              "New York, siendo el espectador testigo directo de la evolución en sus vidas, con " +
              "sus malos momentos también, pero como ya hemos dicho antes, todo en clave de comedia."

val Simpsons = "La serie es una sátira hacia la sociedad estadounidense que narra la vida y " +
               "el día a día de una familia de clase media de ese país (cuyos miembros son " +
               "Homer, Marge, Bart, Lisa y Maggie Simpson) que vive en un pueblo ficticio llamado Springfield."

val Stranger = "La historia narra la súbita desaparición de un niño en esta ciudad durante " +
               "la década de los 80, hecho que destapa los extraños sucesos que tienen lugar" +
               " en la zona, producto de una serie de experimentos que realiza el gobierno."

val Oliver ="Oliver es un formidable delantero, mientras Benji es un portero invencible. " +
            "Los dos muchachos se encuentran por primera vez como adversarios, en efecto " +
            "Oliver promete a su amigo Arthur, de jugar conjuntamente a él en el equipo de " +
            "la escuela Niupi para pegar el fuerte San Francisco del portero Benji."


@Composable
fun SegundaScreen(navController: NavController, text: String?) {
    Scaffold(topBar = {
        TopAppBar {
            Icon(imageVector = Icons.Default.ArrowBack,
                contentDescription = text,
                modifier = Modifier.clickable {
                    navController.popBackStack()
                })
            Spacer(modifier = Modifier.width(12.dp))
            Text(text = text.toString())
        }
    }) {
        SegundoBodyContent(text)
    }
}

@Composable
fun SegundoBodyContent(text: String?) {
    Column(modifier = Modifier
        .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            when (text) {
                "Rick y Morthy" -> {

                    painterResource(R.drawable.rick)
                }
                "Friends" -> {
                    painterResource(R.drawable.friends)
                }
                "Los Simpsons" -> {
                    painterResource(R.drawable.simpson)
                }
                "Stranger Things" -> {
                    painterResource(R.drawable.stranger_things)
                }
                else -> {
                    painterResource(R.drawable.oliver)
                }
            }, "Mi imagen",
        )
        Spacer(modifier = Modifier.width(32.dp))
        if (text == "Rick y Morthy") {
            Text(text = Rick)
        } else if (text == "Friends") {
            Text(text = Friends)
        } else if (text == "Los Simpsons") {
            Text(text = Simpsons)
        } else if (text == "Stranger Things") {
            Text(text = Stranger)
        } else if (text == "Oliver y benji") {
            Text(text = Oliver)
        }

    }
}