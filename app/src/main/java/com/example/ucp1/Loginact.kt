package com.example.ucp1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun login(modifier: Modifier = Modifier){
    var alamat by remember { mutableStateOf("") }
    var departure by remember { mutableStateOf("") }
    var arrive by remember { mutableStateOf("") }
    var memilihTP by remember { mutableStateOf("")}

    var alamatsv by remember { mutableStateOf("")}
    var departuresv by remember { mutableStateOf("")}
    var arrivesv by remember { mutableStateOf("")}
    var memilihTPsv by remember { mutableStateOf("")}

    val listTP = listOf("Bus","Ship","Train","Plain")
    val Biru = Color(0x0a3c81)

    Column (modifier = Modifier.fillMaxWidth()){
    HeaderSection(modifier)
        Text("Plan Your Adventure",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold)
        Text("Let's plan an exquisite adventure",
            fontSize = 10.sp,
            fontWeight = FontWeight.Thin)
        Spacer(Modifier.padding(5.dp))
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
                .clip(CircleShape)
                .background(color = Color.White),
            value = alamat,
            onValueChange = {alamat = it},
            label = { Text("origin")},
            placeholder = { Text("Masukkan Alamat Anda")}
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = departure,
                    onValueChange = { departure = it },
                    label = { Text("Departure", textAlign = TextAlign.Center) },
                    textStyle = LocalTextStyle.current.copy(fontSize = 12.sp),
                    modifier=Modifier.size(height = 45.dp, width=170.dp).clip(CircleShape)

                )
            }

            Spacer(modifier = Modifier.width(30.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = arrive,
                    onValueChange = { arrive = it },
                    label = { Text("Arrive", textAlign = TextAlign.Center) },
                    modifier = Modifier.size(height = 45.dp, width = 170.dp).clip(CircleShape)
                )
            }
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Column (modifier = Modifier.fillMaxWidth().background(Color.Blue)){

        Text("Choose Transportation", Modifier
            .height(30.dp)
            .align(Alignment.CenterHorizontally),
            color = Color.White)
        Row (modifier = Modifier.fillMaxWidth().background(Color.Gray).clip(CircleShape)) {
            listTP.forEach{item ->
                Row (verticalAlignment = Alignment.CenterVertically){
                    RadioButton(
                        selected = memilihTP == item,
                        onClick = {
                            memilihTP = item
                        }
                    )
                    Text(item)
                }
            }
        }
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Button (modifier = Modifier.fillMaxWidth(), onClick = {
            alamatsv = alamat
            departuresv = departure
            arrivesv = arrive
            memilihTPsv = memilihTP
        }) {
            Text("Submit")
        }
        Spacer(modifier = Modifier.padding(10.dp))
        ElevatedCard(colors = CardDefaults.cardColors(containerColor = Color.Blue),
            modifier = Modifier.fillMaxWidth()) {
            DetailsSurat(judul = "Origin", Isinya = alamatsv)
            DetailsSurat(judul = "Departure", Isinya = departuresv)
        }
        Spacer(modifier = Modifier.padding(10.dp))
        ElevatedCard(colors = CardDefaults.cardColors(containerColor = Color.Blue),
            modifier = Modifier.fillMaxWidth()) {
            DetailsSurat(judul = "Arrival", Isinya = arrivesv)
            DetailsSurat(judul = "Transport", Isinya = memilihTPsv)
        }
    }
}

@Composable
fun DetailsSurat(judul: String, Isinya: String){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ){
        Text(text = judul,
            modifier = Modifier.weight(0.8f),color = Color.White)
        Text(text = " : ",
            modifier = Modifier.weight(0.2f),color = Color.White)
        Text(text = Isinya,
            modifier = Modifier.weight(2f),color = Color.White)
    }
}


@Composable
fun HeaderSection(modifier: Modifier){
    Box(modifier = modifier
        .fillMaxWidth()
        .background(color = Color.Blue)
    ){
        Column (modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally){
            Image(painter = painterResource(id = R.drawable.orang),
                contentDescription = null, modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape)
            )
            Row (){
                Icon(imageVector = Icons.Filled.Person,
                    contentDescription = null)
                Text("Muhammad Adifa Firmansyah", color = Color.White)
            }
            Row (){
                Icon(imageVector = Icons.Filled.LocationOn,
                    contentDescription = null)
                Text("Yogyakarta", color = Color.White)
            }
        }
    }
}

