package dakote.skills.application.base

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import dakote.skills.utils.FragmentUtils

abstract class BaseActivity: AppCompatActivity() {

    private val fragmentUtils by lazy { FragmentUtils(this) }

    override fun onBackPressed() {
        fragmentUtils.onBackPressed()
        super.onBackPressed()
    }

    fun replaceFragment(fragment: Fragment){
        fragmentUtils.replaceFragment(fragment)
    }

    fun replaceFragmentWithPopAnim(fragment: Fragment){
        fragmentUtils.replaceFragmentWithPopAnim(fragment)
    }

    fun replaceFragmentNoAnim(fragment: Fragment){
        fragmentUtils.replaceFragmentNoAnim(fragment)
    }

    fun replaceFragmentNoAnimNoStack(fragment: Fragment){
        fragmentUtils.replaceFragmentNoAnimNoStack(fragment)
    }
}