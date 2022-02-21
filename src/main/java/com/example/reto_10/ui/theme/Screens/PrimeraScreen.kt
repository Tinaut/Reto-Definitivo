package com.example.reto_10.ui.theme.Screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.reto_10.R
import com.example.reto_10.ui.theme.Navigation.Screens

@Composable
fun FirstScreen(navController: NavController) {
    Scaffold (topBar = {
        TopAppBar {
            Text(text = "Series Iconicas")
        }
    }) {
        BodyContent(navController)

    }
}

@Composable
fun MyText(text: String, color: Color, style: TextStyle) {
    Text(text, color = color, style = style)
}

@Composable
fun MyTexts(message: MyMessage) {

    Column(modifier = Modifier.padding(start = 16.dp)) {

        MyText(
            message.title,
            MaterialTheme.colors.primary,
            MaterialTheme.typography.subtitle1)

        Spacer(modifier = Modifier.height(16.dp))


        MyText(
            message.cordillera,
            MaterialTheme.colors.primary,
            MaterialTheme.typography.subtitle2)


    }

}

@Composable
fun MyImage(title: String, navController: NavController) {

    Image(

        when (title) {
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
        },

        "Imagen serie",
        modifier = Modifier
            .clip(CircleShape)
            .background(MaterialTheme.colors.primary)
            .size(64.dp).clickable {

                navController.navigate(Screens.SecondScreen.route + "/$title")
            }

    )
}

@Composable
fun MyComponent(message: MyMessage, navController: NavController) {
    Row(modifier = Modifier
        .padding(16.dp)
        .background(MaterialTheme.colors.background)) {
        MyImage(message.title, navController)
        MyTexts(message)
    }
}

@Composable
fun BodyContent(navController: NavController) {
    LazyColumn{
        items(message){ message ->
            MyComponent(message,navController)
        }
    }
}

private val message: List<MyMessage> = listOf(
    MyMessage("Rick y Morthy", "5 temporadas",
        R.drawable.rick),

    MyMessage(
        "Friends", "10 Temporadss",
        R.drawable.friends),

    MyMessage("Los Simpsons", "33 Temporadas",
        R.drawable.simpson),

    MyMessage(
        "Stranger Things", "4 temporadas",
        R.drawable.stranger_things),

    MyMessage(
        "Oliver y benji", "2 temporadas",
        R.drawable.oliver)

)

data class MyMessage(
    val title: String, val cordillera: String, val image: Int,
)