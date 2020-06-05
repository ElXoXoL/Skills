package dakote.skills.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import dakote.skills.R
import dakote.skills.application.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_test.*

class TestFragment : BaseFragment(R.layout.fragment_test) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_open_list.setOnClickListener {
            replaceFragmentNoAnim(TestFragment1())
        }
    }
}
