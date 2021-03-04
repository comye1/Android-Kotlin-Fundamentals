package com.example.android.guesstheword.screens.game

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    companion object{
        //game over
        private const val DONE = 0L
        //time interval - 1초
        private const val ONE_SECOND = 1000L
        //total time - 60초
        private const val COUNTDOWN_TIME = 60000L
    }
    //Countdown time
    private val _currentTime = MutableLiveData<Long>()
    val currentTime: LiveData<Long>
        get() = _currentTime

    private val timer: CountDownTimer

    // The current word
    private val _word = MutableLiveData<String>()
    val word : LiveData<String>
        get() = _word

    // The current score
    private val _score = MutableLiveData<Int>()
    val score : LiveData<Int>
        get() = _score

    // Event which triggers the end of the game
    private val _eventGameFinish = MutableLiveData<Boolean>()
    val eventGameFinish : LiveData<Boolean>
        get() = _eventGameFinish


    // The list of words - the front of the list is the next word to guess
    private lateinit var wordList: MutableList<String>
    /**
     * Resets the list of words and randomizes the order
     */
    private fun resetList() {
        wordList = mutableListOf(
                "queen",
                "hospital",
                "basketball",
                "cat",
                "change",
                "snail",
                "soup",
                "calendar",
                "sad",
                "desk",
                "guitar",
                "home",
                "railway",
                "zebra",
                "jelly",
                "car",
                "crow",
                "trade",
                "bag",
                "roll",
                "bubble"
        )
        wordList.shuffle()
    }

    init {
        //initialize LiveData, setValue()
        _word.value = ""
        _score.value = 0

        resetList()
        nextWord()

        //initialize and start the timer
        timer = object : CountDownTimer(COUNTDOWN_TIME, ONE_SECOND){
            override fun onTick(millisUntilFinished: Long) {
                _currentTime.value = millisUntilFinished/ ONE_SECOND
            }

            override fun onFinish() {
                _currentTime.value = DONE
                onGameFinish()
            }
        }
        timer.start()
    }
    /**
     * Moves to the next word in the list
     */
    private fun nextWord() {
        if(wordList.isEmpty()){
            resetList()
        }else{
            _word.value = wordList.removeAt(0)
        }
    }
    /** Methods for buttons presses **/

    fun onSkip() {
        // null check
        _score.value = (score.value)?.minus(1)
//        score--

        nextWord()
    }

    fun onCorrect() {
//        score++
        _score.value = (score.value)?.plus(1)
        nextWord()
    }

    fun onGameFinish(){
        _eventGameFinish.value = true
    }

    fun onGameFinishComplete(){
        _eventGameFinish.value = false
    }

    override fun onCleared() {
        super.onCleared()
        timer.cancel()
    }
}