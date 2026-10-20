package com.example.pageturner.ui.components.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun Input(
    value: String,
    onValueChange:(String)-> Unit,
    label: String,
    placeholder: String,
    keyboardOptions: KeyboardOptions= KeyboardOptions.Default,
    isPassword: Boolean=false
){
    var passwordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
        ,
        verticalArrangement = Arrangement.spacedBy(4.dp)

    ) {
        Text(
            label,
            color = Color.White,
            fontWeight = FontWeight.Medium
        )
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(100.dp),
            placeholder = {Text(placeholder)},
            trailingIcon = {
                if (isPassword==true){
                    IconButton(onClick = {passwordVisible=!passwordVisible}) {
                        Icon(
                            imageVector = if (passwordVisible==true){
                                Icons.Outlined.Visibility
                            }else{
                                Icons.Outlined.VisibilityOff
                            },
                            contentDescription = "password visibility",
                            tint= MaterialTheme.colorScheme.surface

                        )
                    }
                }
            },
            keyboardOptions=keyboardOptions,
            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = Color.Transparent,
                unfocusedContainerColor = MaterialTheme.colorScheme.secondary,
                focusedContainerColor = MaterialTheme.colorScheme.secondary,
                unfocusedPlaceholderColor = Color(0xFF081611).copy(0.6f),
            )

        )
    }
}