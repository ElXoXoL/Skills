package dakote.skills.utils

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.view.View
import android.view.ViewAnimationUtils
import android.view.animation.Animation
import android.view.animation.DecelerateInterpolator

import android.view.animation.ScaleAnimation
import androidx.cardview.widget.CardView


object AnimationUtils{

    fun circularReveal(x: Int, y: Int, radius: Float, view: CardView){

        val anim = ViewAnimationUtils.createCircularReveal(view, x, y, 0f, radius)
        anim.duration = 500

        // make the view visible and start the animation
        view.visibility = View.VISIBLE
        anim.start()
    }

    fun circularHide(x: Int, y: Int, radius: Float, view: View, onHideAction: () -> Unit){

        val anim = ViewAnimationUtils.createCircularReveal(view, x, y, radius, 0f)

        // make the view invisible when the animation is done
        anim.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator?) {
                super.onAnimationEnd(animation)
                view.visibility = View.GONE
                onHideAction()
            }
        })

        // start the animation
        anim.start()
    }

    fun scaleAnimation(startX: Float, endX: Float, startY: Float, endY: Float, view: View){
        val anim: Animation = ScaleAnimation(
            startX, endX,  // Start and end values for the X axis scaling
            startY, endY,  // Start and end values for the Y axis scaling
            Animation.RELATIVE_TO_SELF, 0.5f,  // Pivot point of X scaling
            Animation.RELATIVE_TO_SELF, 0.5f
        ) // Pivot point of Y scaling
        anim.interpolator = DecelerateInterpolator()
        anim.fillAfter = true // Needed to keep the result of the animation

        anim.duration = 300
        view.startAnimation(anim)
    }
}