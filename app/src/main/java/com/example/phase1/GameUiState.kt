package com.example.phase1

// Phase 7: a single snapshot of everything the screen needs to know.
// Instead of separate variables floating around, we group them here.
data class GameUiState(
    val scrambledWord: String = "",
    val userGuess: String = "",
    val score: Int = 0
)
