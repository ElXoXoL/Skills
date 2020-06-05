package dakote.skills.application.base

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
import java.util.*

abstract class BaseFragment(@LayoutRes resource: Int): Fragment(resource){

    // Fixes meizu phones error on editText hints
    protected fun haxMeizu(vararg editTexts: TextInputEditText) {
        val manufacturer = Build.MANUFACTURER.toUpperCase(Locale.US)
        if (manufacturer.contains("MEIZU")) {
            for (editText in editTexts) {
                editText.setHintTextColor(Color.TRANSPARENT)
                editText.hint = editText.hint
            }
        }
    }

    protected fun replaceFragment(fragment: Fragment){
        (activity as? BaseActivity)?.replaceFragment(fragment)
    }

    protected fun replaceFragmentWithPopAnim(fragment: Fragment){
        (activity as? BaseActivity)?.replaceFragmentWithPopAnim(fragment)
    }

    protected fun replaceFragmentNoAnim(fragment: Fragment){
        (activity as? BaseActivity)?.replaceFragmentNoAnim(fragment)
    }

    protected fun replaceFragmentNoAnimNoStack(fragment: Fragment){
        (activity as? BaseActivity)?.replaceFragmentNoAnimNoStack(fragment)
    }

}