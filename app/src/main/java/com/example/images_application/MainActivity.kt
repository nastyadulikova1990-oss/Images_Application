package com.example.images_application

import android.os.Bundle
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.images_application.ui.theme.Images_ApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val images = listOf(
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e
        ) //список картинок
        val nameImages = listOf("картинка  A", "картинка  B", "картинка  C", "картинка  D",
            "картинка  E"
        )


        setContent {
            MaterialTheme {
                var currentIndex by remember { mutableStateOf(0) }
                Column(
                    modifier = Modifier.fillMaxSize().padding(32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = images[currentIndex]),
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth().height(204.dp),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "${currentIndex + 1}/${images.size}")
                    Text(text = nameImages[currentIndex] )
                    Spacer(modifier = Modifier.height(50.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    )
                    {
                        Button(
                            onClick = {
                                currentIndex =
                                    if (currentIndex == 0) images.lastIndex else currentIndex - 1
                            },
                            modifier = Modifier.weight(1f).padding(horizontal = 4.dp)
                        ) {
                            Text("Предыдущий")
                        }

                        Button(
                            onClick = {
                                currentIndex =
                                    if (currentIndex == images.lastIndex) 0 else currentIndex + 1
                            },
                            modifier = Modifier.weight(1f).padding(horizontal = 4.dp)
                        ) {
                            Text("Следующий")
                        }


                    }

                    //рандом
                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        onClick = {
                            var newIndex = (images.indices).random()
                            while (newIndex==currentIndex)
                            {
                                newIndex = (images.indices).random()
                            }
                            currentIndex = newIndex
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                    {
                        Text(text = "Случайное изображение")
                    }

                }
            }
        }
    }
}
@Composable
        fun Greeting(name: String, modifier: Modifier = Modifier) {
            Text(
                text = "Hello $name!",
                modifier = modifier
            )
        }

@Preview(showBackground = true)
        @Composable
        fun GreetingPreview() {
            Images_ApplicationTheme {
                Greeting("Android")
            }
        }


