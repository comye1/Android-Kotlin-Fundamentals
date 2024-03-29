/*
 * Copyright 2019, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.trackmysleepquality.sleeptracker

import android.app.Application
import androidx.lifecycle.*
import com.example.android.trackmysleepquality.database.SleepDatabaseDao
import com.example.android.trackmysleepquality.database.SleepNight
import com.example.android.trackmysleepquality.formatNights
import kotlinx.coroutines.launch

/**
 * ViewModel for SleepTrackerFragment.
 */
class SleepTrackerViewModel(
        val database: SleepDatabaseDao,
        application: Application) : AndroidViewModel(application) {

    private var _showSnackbarEvent = MutableLiveData<Boolean>()

    val showSnackBarEvent: LiveData<Boolean>
        get() = _showSnackbarEvent

    // Use encapsulation to only expose a gettable version of the LiveData to the ViewModel.
    private val _navigateToSleepQuality = MutableLiveData<SleepNight>()
    //create a LiveData that changes when you want the app to navigate to the SleepQualityFragment
    val navigateToSleepQuality : LiveData<SleepNight>
        get() = _navigateToSleepQuality


    private var tonight = MutableLiveData<SleepNight?>()

    private val nights = database.getAllNights()
    //transform nights into a nightsString
    val nightString = Transformations.map(nights) { nights ->
        formatNights(nights, application.resources)
    }

    val startButtonVisible = Transformations.map(tonight){
        it == null // enabled when tonight is null
    }

    val stopButtonVisible = Transformations.map(tonight){
        it != null // enabled when tonight is not null
    }

    val clearButtonVisible = Transformations.map(nights) {
        it?.isNotEmpty() // enabled only if nights contain sleep nights
    }

    fun doneShowingSnackbar(){
        _showSnackbarEvent.value = false
    }

    // reset navigateToSleepQuality
    fun doneNavigating() {
        _navigateToSleepQuality.value = null
    }

    fun onStartTracking(){
        viewModelScope.launch {
            val newNight = SleepNight() //capture the current time as the start time
            insert(newNight)
            tonight.value = getTonightFromDatabase()
        }
    }

    private suspend fun insert(night:SleepNight){
        database.insert(night)
    }

    fun onStopTracking() {
        viewModelScope.launch {
            val oldNight = tonight.value ?: return@launch
            oldNight.endTimeMilli = System.currentTimeMillis()
            update(oldNight)
            _navigateToSleepQuality.value = oldNight //trigger navigation to the SleepQualityFragment
        }
    }

    private suspend fun update(night: SleepNight) {
        database.update(night)
    }
    fun onClear(){
        viewModelScope.launch {
            clear()
            tonight.value = null
        }
        _showSnackbarEvent.value = true
    }

    suspend fun clear() {
        database.clear()
    }

    init {
        initializeTonight()
    }

    private fun initializeTonight() {
        viewModelScope.launch {
            tonight.value = getTonightFromDatabase()
        }
    }

    private suspend fun getTonightFromDatabase(): SleepNight? {
        var night = database.getTonight()
        if(night?.endTimeMilli != night?.startTimeMilli) { //night has already been completed
            night = null
        }
        return night
    }
}

