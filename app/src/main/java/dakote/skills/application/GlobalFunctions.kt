package dakote.skills.application

import dakote.skills.koin.KoinComponents
import kotlinx.coroutines.Job


/**
 * My most favourite functions, that I prefer to use
 */

fun runOnWorker(function: suspend () -> Unit): Job {
    return KoinComponents.coroutineProvider.onWorkerThread { function() }
}

suspend fun runOnMain(function: () -> Unit) {
    return KoinComponents.coroutineProvider.onMainThread { function() }
}