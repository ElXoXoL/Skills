package dakote.skills.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import dakote.skills.R
import dakote.skills.application.base.BaseFragment
import dakote.skills.application.extensions.dp
import dakote.skills.application.extensions.px
import dakote.skills.utils.AnimationUtils
import dakote.skills.utils.Logger
import kotlinx.android.synthetic.main.fragment_test_1.*
import kotlin.math.hypot
import kotlin.math.max

class TestFragment1 : BaseFragment(R.layout.fragment_test_1) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  super.onCreateView(inflater, container, savedInstanceState)
        view?.addOnLayoutChangeListener(object: View.OnLayoutChangeListener{
            override fun onLayoutChange(
                v: View?,
                left: Int,
                top: Int,
                right: Int,
                bottom: Int,
                oldLeft: Int,
                oldTop: Int,
                oldRight: Int,
                oldBottom: Int
            ) {
                v?.removeOnLayoutChangeListener(this)
                revealView()
            }

        })
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        card_open_map.setOnClickListener {
            hideView()
        }
    }

    private fun revealView(){

        val x = (main_layout.measuredWidth / 2)
        val y = 125.px

        val radius = hypot(main_layout.width.toDouble(), main_layout.height.toDouble()).toFloat()

        AnimationUtils.circularReveal(x, y, radius, main_layout)

        AnimationUtils.scaleAnimation(
            0.6f, 1f, 0.6f, 1f, card_open_map
        )
    }

    private fun hideView(){

        val x = (main_layout.measuredWidth / 2)
        val y = 125.px

        val radius = hypot(main_layout.width.toDouble(), main_layout.height.toDouble()).toFloat()

        AnimationUtils.scaleAnimation(
            1f, 0f, 1f, 0f, card_open_map
        )

        AnimationUtils.circularHide(x, y, radius, main_layout){
            activity?.onBackPressed()
        }

    }
}
