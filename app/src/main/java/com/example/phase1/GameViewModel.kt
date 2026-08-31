package com.example.phase1

import androidx.lifecycle.ViewModel

// Phase 6: the ViewModel now owns the game's data and logic.
// GameLayout (the UI) will just READ from this and call its functions.
class GameViewModel : ViewModel() {

    val wordList = listOf(
        "architecture",
        "component",
        "viewmodel",
        "compose"
    )

    var currentWord = wordList.random()
    var scrambledWord = scrambleWord(currentWord)
    var score = 0
    var userGuess = ""

    fun getNextWord(): String {
        return wordList.random()
    }

    fun scrambleWord(word: String): String {
        return word.toCharArray().let {
            it.shuffle()
            String(it)
        }
    }

    fun checkGuess() {
        if (userGuess.equals(currentWord, ignoreCase = true)) {
            score += 10
            currentWord = getNextWord()
            scrambledWord = scrambleWord(currentWord)
        } else {
            // Incorrect guess handling comes later — kept simple for now
        }
        userGuess = ""
    }
}
