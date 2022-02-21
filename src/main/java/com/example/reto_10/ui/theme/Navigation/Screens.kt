package com.example.reto_10.ui.theme.Navigation


sealed class Screens(val route: String){
    object FirstScreen: Screens("primera_screen")
    object SecondScreen: Screens("segunda_screen")
}