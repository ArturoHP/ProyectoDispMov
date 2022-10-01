package com.example.appdispmov

//Hola

import android.graphics.Color.parseColor
import android.os.Bundle
import android.util.Patterns
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.appdispmov.Components.Drawer
import com.example.appdispmov.Components.TopBar
import com.example.appdispmov.Navigation.Destinations
import com.example.appdispmov.Navigation.NavigationHost
import com.example.appdispmov.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppDispMovTheme {
                  val navController = rememberNavController()
                  NavigationHost(navController)
                 // MainScreen()
            }
        }
    }
}

/*
@Composable
fun MainScreen(){

    val navController = rememberNavController()

    val scaffoldState = rememberScaffoldState(
        drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    )

    val Scope = rememberCoroutineScope()
    val navigationItem = listOf(
        Destinations.Pantalla1,
        Destinations.Pantalla2,
        Destinations.Pantalla3
    )

    Scaffold(
        scaffoldState = scaffoldState ,
        /* bottomBar = { BottomNavigationBar(navController = navController , items = navigationItem ) }, */
        topBar = { TopBar(Scope,scaffoldState) },
        drawerContent = { Drawer(scope = Scope, scaffoldState = scaffoldState, navController = navController , items = navigationItem ) }
    ) {
        NavigationHost(navController)
    }

}

*/



