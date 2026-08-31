package com.example.phase1

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

// Phase 7: the ViewModel now exposes its state as a StateFlow,
// so Compose can properly observe changes and redraw the UI.
class GameViewModel : ViewModel() {

    val wordList = listOf(
        "architecture",
        "component",
        "viewmodel",
        "compose"
    )

    // currentWord is the real answer — kept private-ish (not part of UI state)
    // since the player should only ever see the scrambled version.
    private var currentWord = wordList.random()

    private fun getNextWord(): String {
        return wordList.random()
    }

    private fun scrambleWord(word: String): String {
        return word.toCharArray().let {
            it.shuffle()
            String(it)
        }
    }

    private val _uiState = MutableStateFlow(
        GameUiState(scrambledWord = scrambleWord(currentWord))
    )
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    fun updateUserGuess(guessedWord: String) {
        _uiState.update { currentState ->
            currentState.copy(userGuess = guessedWord)
        }
    }

    fun checkGuess() {
        if (_uiState.value.userGuess.equals(currentWord, ignoreCase = true)) {
            currentWord = getNextWord()
            _uiState.update { currentState ->
                currentState.copy(
                    score = currentState.score + 10,
                    scrambledWord = scrambleWord(currentWord),
                    userGuess = ""
                )
            }
        } else {
            // Incorrect guess handling comes later — kept simple for now
            _uiState.update { it.copy(userGuess = "") }
        }
    }
}
