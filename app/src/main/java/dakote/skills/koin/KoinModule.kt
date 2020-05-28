package dakote.skills.koin

import coffeeworld.zipbarista.app.coroutine.CoroutineProvider
import coffeeworld.zipbarista.app.coroutine.CoroutinesExecutor
import org.koin.dsl.module

val appModule = module {
//    single { AuthUtils() }
//    single { FirestoreManager() }
//    single { StorageUtils() }
    single { CoroutinesExecutor() as CoroutineProvider }
//
//    viewModel { TestViewModel(get()) }
}

val skillsApp = listOf(appModule)