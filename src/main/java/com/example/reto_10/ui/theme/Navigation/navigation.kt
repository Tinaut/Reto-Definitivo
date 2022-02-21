package com.example.reto_10.ui.theme.Navigation


import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.reto_10.ui.theme.Screens.FirstScreen
import com.example.reto_10.ui.theme.Screens.SegundaScreen

@ExperimentalMaterialApi
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screens.FirstScreen.route
    ) {
        composable(route = Screens.FirstScreen.route){
            FirstScreen(navController)
        }
        composable(route = Screens.SecondScreen.route + "/{text}",
            arguments = listOf(navArgument(name = "text"){
                type = NavType.StringType
            })
        ){
            SegundaScreen(navController, it.arguments?.getString("text"))
        }
    }
}