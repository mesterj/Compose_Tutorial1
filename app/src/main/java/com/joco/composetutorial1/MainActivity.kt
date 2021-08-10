package com.joco.composetutorial1

import android.os.Bundle
import android.widget.TableLayout
import android.widget.TableRow
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.joco.composetutorial1.ui.theme.ComposeTutorial1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorial1Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                  //  Greeting("Android")
                    MessageCard(msg = Message("Hello", "Card"))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

data class Message(val author: String, val body: String)

@Composable
fun MessageCard (msg:Message) {
        var nameText = remember { mutableListOf("")    }
    Column() {
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "Default picture",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))

            Column() {
                Text(text = msg.author)
                Text(text = msg.body)
                Spacer(modifier = Modifier.height(4.dp))
            }

        }
        Row(modifier = Modifier.padding(8.dp).fillMaxWidth(),horizontalArrangement = Arrangement.Center,verticalAlignment = Alignment.CenterVertically) {
            Button(onClick = { /*TODO*/ }){
                Text("Név kiírás")

                }
        }
    }
    /*TableLayout(
        TableRow(Greeting(name = "Próba"))
    )*/

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTutorial1Theme {
       // Greeting("Android")
        MessageCard( Message("Colleague", "Hey take a look at this!"))
    }
}