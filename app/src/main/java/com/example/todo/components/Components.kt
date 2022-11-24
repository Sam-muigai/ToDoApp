package com.example.todo.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todo.domain.model.ToDo
import com.example.todo.presentation.MainViewModel
import com.example.todo.ui.theme.poppins

@Preview(showBackground = true)
@Composable
fun ColorDot(modifier: Modifier = Modifier) {
   Surface(modifier = modifier
       .size(10.dp)
       .padding(3.dp),
       shape = CircleShape,
       color = Color.Red) {}
}


@Composable
fun SingleTodo(modifier: Modifier = Modifier,
               toDo: ToDo, onClick:()->Unit,viewModel: MainViewModel) {
    var checked by rememberSaveable {
        mutableStateOf(false)
    }
    Row(modifier = modifier.fillMaxWidth().clickable { onClick.invoke() },
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically) {
        RadioButton(selected = checked,
            onClick = {
                 checked = !checked
            }, modifier = Modifier.padding(horizontal = 6.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier) {
                Row {
                   Text(text = toDo.todoItem,
                       modifier = Modifier
                           .weight(1f)
                           .padding(vertical = 15.dp),
                       fontFamily = poppins,
                       style = MaterialTheme.typography.body1,
                       fontWeight = FontWeight.ExtraBold
                   )
                    ColorDot(
                        Modifier
                            .align(CenterVertically)
                            .size(18.dp))
                    Spacer(modifier = Modifier.width(10.dp))
                }
                Divider(modifier = Modifier.height(1.dp),
                    color = Color.LightGray)
            }
        }
    }
}

