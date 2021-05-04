package com.example.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.progressSemantics
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Comment
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composedemo.ui.theme.ComposeDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = {
                                    Text("Twitter")
                                }
                            )
                        },
                        content = {
                            LazyColumn {
                                items(10) {
                                    TweetCard()
                                }
                            }
                        }
                    )

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun TweetCard() {
    Column {
        Row(modifier = Modifier.padding(16.dp)) {
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colors.primary)
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = "TP",
                    style = MaterialTheme.typography.h6.copy(color = Color.White)
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Tabitha Potter", fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.width(2.dp))
                    Icon(
                        modifier = Modifier.size(14.dp),
                        imageVector = Icons.Filled.Verified,
                        contentDescription = null,
                        tint = Color(0xFF4C9EEB),
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                        Text(text = "@mis_potter")
                    }
                }
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "Kobe’s passing is really sticking w/ me in a way I didn’t expect.\n" +
                            "\n" +
                            "He was an icon, the kind of person who wouldn’t die this way. My wife compared it to Princess Di’s accident.\n" +
                            "\n" +
                            "But the end can happen for anyone at any time, & I can’t help but think of anything else lately."
                )
                Spacer(modifier = Modifier.height(16.dp))
                TweetActionBar()
            }
        }
        Divider(
            thickness = 2.dp,
            color = Color.Gray.copy(alpha = 0.08f)
        )
    }
}

@Composable
fun TweetActionBar() {
    Row(horizontalArrangement = Arrangement.SpaceAround) {
        TweetAction(imageVector = Icons.Outlined.Comment, count = 7)
        Spacer(modifier = Modifier.weight(1f))
        TweetAction(imageVector = Icons.Outlined.AddComment, count = 1)
        Spacer(modifier = Modifier.weight(1f))
        TweetAction(imageVector = Icons.Outlined.FavoriteBorder, count = 11)
        Spacer(modifier = Modifier.weight(1f))
        TweetAction(imageVector = Icons.Outlined.Share)
    }
}

@Composable
fun TweetAction(imageVector: ImageVector, count: Int? = null) {
    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                modifier = Modifier.size(14.dp),
                imageVector = imageVector,
                contentDescription = "Comment",
                //   tint = Color.Gray.copy(alpha = 0.0f)
            )
            Text(text = count?.toString() ?: "", fontSize = 14.sp)
        }
    }
}