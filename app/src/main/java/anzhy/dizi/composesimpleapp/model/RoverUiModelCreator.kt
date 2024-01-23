package anzhy.dizi.composesimpleapp.model

import anzhy.dizi.composesimpleapp.R

val roverUIModelList = listOf(
    RoverModel(
        name = "Perseverance",
        image = R.drawable.perseverance,
        landingDate = "18 February 2021",
        distance = "12.56 km"
    ),
    RoverModel(
        name = "Curiosity",
        image = R.drawable.curiosity,
        landingDate = "6 August 2021",
        distance = "29.27 km"
    ),
    RoverModel(
        name = "Opportunity",
        image = R.drawable.opportunity,
        landingDate = "25 January 2004",
        distance = "45.16 km"
    ),
    RoverModel(
        name = "Spirit",
        image = R.drawable.spirit,
        landingDate = "4 January 2004",
        distance = "7.73 km"
    )
)

class RoverUiModelCreator {
}