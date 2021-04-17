package com.example.android.devbyteviewer.work

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.android.devbyteviewer.database.getDatabase
import com.example.android.devbyteviewer.repository.VideosRepository
import retrofit2.HttpException
import timber.log.Timber

class RefreshDataWorker(appContext: Context, params: WorkerParameters)
    : CoroutineWorker(appContext, params){

    companion object{
        // Define a work name to uniquely identify this worker.
        const val WORK_NAME = "com.example.android.devbyteviewer.work.RefreshDataWorker"
    }

    override suspend fun doWork(): Result {
        // create and instantiate a VideosDatabase object
        // and a VideosRepository object
        val database = getDatabase(applicationContext)
        val repository = VideosRepository(database)

        // fetch the DevBytes video playlist from the network
        try {
            repository.refreshVideos()
            Timber.d("Work request for sync is run")
        }catch (e: HttpException) {
            return Result.retry()
        }
        return Result.success()
    }
}