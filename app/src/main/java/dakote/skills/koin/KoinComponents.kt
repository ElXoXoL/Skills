package dakote.skills.koin

import coffeeworld.zipbarista.app.coroutine.CoroutineProvider
import org.koin.core.KoinComponent
import org.koin.core.inject

/**
 * Components object to be able to Mock it later in testing
 */

object KoinComponents: KoinComponent {
//    val firestoreManager : FirestoreManager by inject ()
//    val storageUtils : StorageUtils by inject ()
//    val authUtils: AuthUtils by inject()
    val coroutineProvider: CoroutineProvider by inject()
}