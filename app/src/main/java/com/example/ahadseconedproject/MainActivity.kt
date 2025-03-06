package com.example.ahadseconedproject

import android.graphics.fonts.FontStyle
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ahadseconedproject.ui.theme.AhadSeconedProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            AhadSeconedProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Ahad",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }


    override fun onStart() {
        super.onStart()
        Log.d("MainActivityLifecycle", "onStart: App is visible") // Logging onStart
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivityLifecycle", "onResume: App is in foreground") // Logging onResume
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivityLifecycle", "onPause: App is paused") // Logging onPause
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivityLifecycle", "onDestroy: App is destroyed") // Logging onDestroy
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    //to hold the count of initial followers
    var counter : Int by remember{
        mutableStateOf(44)
    }

    //to maintain the followers counts when clicking the button
    var isFollowing by remember{
        mutableStateOf(false)
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color.White),
        contentAlignment = Alignment.Center
    ){
        Column( horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.fillMaxWidth() ){

            //Profile Picture
            Image(
                painter = painterResource(R.drawable.profile),
                contentDescription = "This is an image of compose",
            )

            //Displaying name
            Text(
                text = " $name ",
                fontFamily = FontFamily.Serif,
                style = MaterialTheme.typography.headlineMedium

            )
            //Short bio
            Text(
                text = "a Computer Science major and an Android Mobile App Development trainee at Atomcamp.",
                fontFamily = FontFamily.SansSerif,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(8.dp),
                textAlign = TextAlign.Center
                

            )

            //follow button
            Button(onClick ={
                    isFollowing = !isFollowing
                    counter += if (isFollowing) 1 else -1})
            {
                Text(if (isFollowing)"Following" else "Follow")

            }

            //amount of followers
            Text(
                text = "$counter followers",
                fontFamily = FontFamily.SansSerif,
                style = MaterialTheme.typography.bodySmall,

                )

        }



    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AhadSeconedProjectTheme {
        Greeting("Ahad")
    }
}

