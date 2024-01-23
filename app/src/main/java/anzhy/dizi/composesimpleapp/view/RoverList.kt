package anzhy.dizi.composesimpleapp.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import anzhy.dizi.composesimpleapp.R
import anzhy.dizi.composesimpleapp.model.roverUIModelList


@Composable
fun RoverList(
    onClick: (roverName: String) -> Unit
) {
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn {
            items(count = roverUIModelList.size, itemContent = { index ->
                Rover(
                    name = roverUIModelList[index].name,
                    image = roverUIModelList[index].image,
                    landingDate = roverUIModelList[index].landingDate,
                    distance = roverUIModelList[index].distance,
                    onClick = onClick
                )
            })
        }
    }
}

@Composable
fun Rover(
    name: String,
    image: Int,
    landingDate: String,
    distance: String,
    onClick: (roverName: String) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .clickable { onClick(name) }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = name,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )
            Image(
                painter = painterResource(id = image),
                contentDescription = null
            )
            Text(text = "Credit: NASA/JPL", fontSize = 8.sp)
            Text(text = "Landing date: $landingDate", fontSize = 12.sp)
            Text(text = "Distance traveled: $distance", fontSize = 12.sp)
        }
    }
}


@Preview
@Composable
fun RoverPreview() {
    Rover(
        name = "Perseverance",
        image = R.drawable.perseverance,
        landingDate = "18 February 2021",
        distance = "12.56 km"
    ) {}
}