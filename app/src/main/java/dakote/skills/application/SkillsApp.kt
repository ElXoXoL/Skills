package dakote.skills.application

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import dakote.skills.koin.skillsApp
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class SkillsApp: Application(){

    companion object {
        lateinit var instance: SkillsApp
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        startKoin {
            // declare used Android context
            androidLogger()
            androidContext(this@SkillsApp)
            // declare modules
            modules(
                skillsApp
            )
        }
    }

//    override fun attachBaseContext(base: Context) {
//        super.attachBaseContext(LocaleUtils.setLocale(base))
//        instance = this
//    }
//
//    override fun onConfigurationChanged(newConfig: Configuration) {
//        super.onConfigurationChanged(newConfig)
//        LocaleUtils.setLocale(this)
//        instance = this
//    }
}