package com.example.composemulitsceensize.data

import com.example.composemulitsceensize.R

data class DataProviderModel(
    val name: Int,
    val imageRes: Int
)


object DataProvider {


    val AlignYourBodyList: List<DataProviderModel> =
        listOf(
            DataProviderModel(
                R.string.ab1_inversions,
                R.drawable.ab1_inversions,
            ),
            DataProviderModel(
                R.string.ab2_quick_yoga,
                R.drawable.ab2_quick_yoga
            ),
            DataProviderModel(
                R.string.ab3_stretching,
                R.drawable.ab3_stretching
            ),
            DataProviderModel(
                R.string.ab4_tabata,
                R.drawable.ab4_tabata
            ),
            DataProviderModel(
                R.string.ab5_hiit,
                R.drawable.ab5_hiit
            ),
            DataProviderModel(
                R.string.ab6_pre_natal_yoga,
                R.drawable.ab6_pre_natal_yoga
            )
        )

    val favoriteCollectionsList = listOf(
        DataProviderModel(
            R.string.fc1_short_mantras,
            R.drawable.fc1_short_mantras
        ),
        DataProviderModel(
            R.string.fc2_nature_meditations,
            R.drawable.fc2_nature_meditations
        ),
        DataProviderModel(
            R.string.fc3_stress_and_anxiety,
            R.drawable.fc3_stress_and_anxiety
        ),
        DataProviderModel(
            R.string.fc4_self_massage,
            R.drawable.fc4_self_massage
        ),
        DataProviderModel(
            R.string.fc5_overwhelmed,
            R.drawable.fc5_overwhelmed
        ),
        DataProviderModel(
            R.string.fc6_nightly_wind_down,
            R.drawable.fc6_nightly_wind_down
        )

    )

    val inversions = DataProviderModel(
        R.string.ab1_inversions,
        R.drawable.ab1_inversions,
    )

    val quickYoga = DataProviderModel(
        R.string.ab2_quick_yoga,
        R.drawable.ab2_quick_yoga
    )

    private val stretching = DataProviderModel(
        R.string.ab3_stretching,
        R.drawable.ab3_stretching
    )

    private val tabata = DataProviderModel(
        R.string.ab4_tabata,
        R.drawable.ab4_tabata
    )

    private val hilt = DataProviderModel(
        R.string.ab5_hiit,
        R.drawable.ab5_hiit
    )

    private val pre_natalYoga = DataProviderModel(
        R.string.ab6_pre_natal_yoga,
        R.drawable.ab6_pre_natal_yoga
    )




}

