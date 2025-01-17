package com.example.appdispmov.Screens


import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AlternateEmail
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.PermIdentity
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment.Companion
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appdispmov.ui.composables.CustomOutlinedTextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.appdispmov.R
import com.example.appdispmov.ui.theme.*

class RegisterActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContent {
            AppDispMovTheme {
                RegisterForm()
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun RegisterForm(
    goToLogin: () -> Unit = {}
){

    val context = LocalContext.current
    val focusManager = LocalFocusManager.current
    val scrollSate = rememberScrollState()

    var name by rememberSaveable { mutableStateOf("") }
    var surname by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var confirmPassword by rememberSaveable { mutableStateOf("") }

    var validateName by rememberSaveable { mutableStateOf(true) }
    var validateSurname by rememberSaveable { mutableStateOf(true) }
    var validateEmail by rememberSaveable { mutableStateOf(true) }
    var validatePassword by rememberSaveable { mutableStateOf(true) }
    var validateConfirmPassword by rememberSaveable { mutableStateOf(true) }
    var validaterePasswordsEqual by rememberSaveable { mutableStateOf(true) }
    var isPasswordVisible by rememberSaveable { mutableStateOf(false) }
    var isConfirmPasswordVisible by rememberSaveable { mutableStateOf(false) }

    val validateNameError = "Por favor, ingresa un nombre válido"
    var validateSurnameError = "Por favor, ingresa un apellido válido"
    var validateEmailError = "El formato de email no es correcto"
    var validatePasswordError = "Debe incluir mayúsculas y minúsculas, número, un caractér especial y mínimo ocho caractéres"
    var validateEqualPasswordError = "Las contraseñas deben ser iguales"

    fun validateData(name: String, surname: String, email: String, password: String, confirmPassword: String): Boolean {
        val passwordRegex = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%^&+=]).{8,}".toRegex()

        validateName = name.isNotBlank()
        validateSurname = surname.isNotBlank()
        validateEmail = Patterns.EMAIL_ADDRESS.matcher(email).matches()
        validatePassword = passwordRegex.matches(password)
        validateConfirmPassword = passwordRegex.matches(password)
        validaterePasswordsEqual = password == confirmPassword

        return validateName && validateSurname && validateEmail && validatePassword && validateConfirmPassword && validaterePasswordsEqual
    }

    fun register (
        name: String,
        surname: String,
        email: String,
        password: String,
        confirmPassword: String
    ){
        if (validateData(name, surname, email, password, confirmPassword)){
            Log.d(RegisterActivity::class.java.simpleName, "Name: $name, Surname: $surname, Password: $password")
        }else{
            Toast.makeText(context, "Por favor, revisa los campos", Toast.LENGTH_SHORT).show()
        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollSate),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        androidx.compose.material.Text(
            text = "¡Regístrate fácilmente!",
            modifier = Modifier.padding(vertical = 20.dp),
            color = md_theme_light_primary,
            fontSize = 28.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold

        )

        Image(
            painter = painterResource(id = R.drawable.reg_img),
            contentDescription = "Register",
            modifier = Modifier.size(180.dp)
        )

        CustomOutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = "Nombre",
            showError = !validateName,
            errorMessage = validateNameError,
            leadingIconImageVector = Icons.Default.PermIdentity,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions (
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            )
        )

        CustomOutlinedTextField(
            value = surname,
            onValueChange = { surname = it },
            label = "Apellido",
            showError = !validateSurname,
            errorMessage = validateSurnameError,
            leadingIconImageVector = Icons.Default.PermIdentity,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions (
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            )
        )

        CustomOutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = "Email",
            showError = !validateEmail,
            errorMessage = validateEmailError,
            leadingIconImageVector = Icons.Default.AlternateEmail,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions (
                onNext = { focusManager.moveFocus(FocusDirection.Down)}
            ),
        )

        CustomOutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = "Contraseña",
            showError = !validatePassword,
            errorMessage = validatePasswordError,
            isPasswordField = true,
            isPasswordVisible = isPasswordVisible,
            onVisibilityChange = { isPasswordVisible = it },
            leadingIconImageVector = Icons.Default.Password,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions (
                onNext = { focusManager.moveFocus(FocusDirection.Down)}
            )
        )

        CustomOutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = "Confirmar contraseña",
            showError = !validateConfirmPassword || !validaterePasswordsEqual,
            errorMessage = if (!validateConfirmPassword) validatePasswordError else validateEqualPasswordError,
            isPasswordField = true,
            isPasswordVisible = isConfirmPasswordVisible,
            onVisibilityChange = { isConfirmPasswordVisible = it },
            leadingIconImageVector = Icons.Default.Password,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions (
                onDone = { focusManager.clearFocus()}
            )
        )

        androidx.compose.material3.Button(
            onClick = {
                register(name, surname, email, password, confirmPassword)
            },
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(0.9f),
            colors = ButtonDefaults.buttonColors(
                md_theme_light_primaryContainer,
                contentColor = md_theme_light_onPrimaryContainer
            )
        ) {
            androidx.compose.material3.Text(
                text = "Registrarse",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = md_theme_light_primary
            )
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            TextButton(onClick = { goToLogin() }){
                androidx.compose.material.Text(
                    color = md_theme_light_onSecondaryContainer,
                    fontStyle = FontStyle.Italic,
                    text = "¿Ya tienes una cuenta? INICIA SESIÓN",
                    modifier = Modifier.padding(all = 0.dp)
                )
            }
        }
    }
}

