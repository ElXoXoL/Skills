package dakote.skills

import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Base64
import android.util.Log
import com.facebook.applinks.AppLinkData
import dakote.skills.application.base.BaseActivity
import dakote.skills.application.extensions.json
import dakote.skills.koin.KoinComponents
import dakote.skills.test.TestFragment
import dakote.skills.utils.Logger
import java.security.MessageDigest


class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragmentNoAnim(TestFragment())

        AppLinkData.fetchDeferredAppLinkData(this
        ) {
            // Process app link data
            Logger.log("DEEP ${it?.argumentBundle?.get("target_url")}")
        }
    }
}
