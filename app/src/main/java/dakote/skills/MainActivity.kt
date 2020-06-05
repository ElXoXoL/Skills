package dakote.skills

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dakote.skills.application.base.BaseActivity
import dakote.skills.room.RoomActivity
import dakote.skills.test.TestFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragmentNoAnim(TestFragment())
    }
}
