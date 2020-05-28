package dakote.skills.application.extensions

import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.LinearGradient
import android.graphics.Shader
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.view.animation.AnimationUtils
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.annotation.*
import androidx.core.content.ContextCompat
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar
import com.google.android.gms.tasks.Task
import com.google.android.gms.tasks.Tasks
import dakote.skills.R
import dakote.skills.application.SkillsApp
import dakote.skills.application.glide.GlideApp
import java.lang.Exception
import java.util.concurrent.TimeUnit

/**
 * My favourite extensions for easy work
 */

fun ImageView.load(url: String?){
    if (url.isNullOrEmpty()){
        this.setImageDrawable(null)
        return
    }
    GlideApp.with(SkillsApp.instance)
        .load(url)
        .into(this)
}

fun ImageView.load(@DrawableRes resId: Int?){
    GlideApp.with(SkillsApp.instance)
        .load(resId)
        .into(this)
}

fun ImageView.load(drawable: Drawable?){
    GlideApp.with(SkillsApp.instance)
        .load(drawable)
        .into(this)
}

fun ImageView.load(data: Uri?){
    GlideApp.with(SkillsApp.instance)
        .load(data)
        .into(this)
}

fun ImageView.load(data: Bitmap?){
    GlideApp.with(SkillsApp.instance)
        .load(data)
        .into(this)
}

fun Context.drawable(@DrawableRes resId: Int?): Drawable?{
    if (resId == null)
        return null

    return ContextCompat.getDrawable(this, resId)
}

fun Context.color(@ColorRes resId: Int): Int{
    return ContextCompat.getColor(this, resId)
}

fun <T>Task<T>.await(): T{
    return Tasks.await(this, 5, TimeUnit.SECONDS)
}

// My best way to get px or dp in app

val Int.dp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()

val Int.px: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()

val Float.dp: Float
    get() = this / Resources.getSystem().displayMetrics.density

val Float.px: Float
    get() = this * Resources.getSystem().displayMetrics.density

fun EditText.hideKeyboard(){
    try {
        val imm = this.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(this.windowToken, 0)
        this.clearFocus()
    } catch (e: Exception) {
        Log.d("Keyboard", e.toString())
    }
}

fun EditText.showKeyboard(){
    val imm = this.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    this.requestFocus()
    imm.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
}

// TODO: maybe remove
fun View.loadAnim(duration: Long = 300, @AnimRes animId: Int? = null){
    val animation = AnimationUtils.loadAnimation(context, animId ?: R.anim.appear)
    animation.duration = duration
    this.startAnimation(animation)
}

fun View.appear(duration: Long = 300, @AnimRes animId: Int? = null, isIgnoreVisibility: Boolean = false){
    if (!isIgnoreVisibility && this.visibility == View.VISIBLE){
        return
    }
    val animation = AnimationUtils.loadAnimation(context, animId ?: R.anim.appear)
    animation.duration = duration
    this.startAnimation(animation)
    this.visibility = View.VISIBLE
}

fun View.disappear(duration: Long = 300, type: Int = 0, @AnimRes animId: Int? = null, isIgnoreVisibility: Boolean = false){
    if (!isIgnoreVisibility && (this.visibility == View.GONE || this.visibility == View.INVISIBLE)){
        return
    }
    val animation = AnimationUtils.loadAnimation(context, animId ?: R.anim.disappear)
    animation.duration = duration
    this.startAnimation(animation)
    this.visibility = if (type == 0){
        View.GONE
    } else{
        View.INVISIBLE
    }
}

fun View.slideY(height: Float = 0f, duration: Long = 300){
    this.animate()
        .setDuration(duration)
        .translationY(height)
}

// Gradient text color
fun TextView.setGradient(@ColorInt bottomColor: Int, @ColorInt topColor: Int){
    val textShader = LinearGradient(
        0f, 0f, 0f, this.textSize,
        intArrayOf(topColor, bottomColor),
        floatArrayOf(0f, 1f), Shader.TileMode.CLAMP
    )
    this.paint.shader = textShader
}

// Gradient text color
fun TextView.setGradientRes(@ColorRes bottomColor: Int, @ColorRes topColor: Int){
    val textShader = LinearGradient(
        0f, 0f, 0f, this.textSize,
        intArrayOf(this.context.color(topColor), this.context.color(bottomColor)),
        floatArrayOf(0f, 1f), Shader.TileMode.CLAMP
    )
    this.paint.shader = textShader
}

// Gradient text color
fun Button.setGradientRes(@ColorRes bottomColor: Int, @ColorRes topColor: Int){
    val textShader = LinearGradient(
        0f, 0f, 0f, this.textSize,
        intArrayOf(this.context.color(topColor), this.context.color(bottomColor)),
        floatArrayOf(0f, 1f), Shader.TileMode.CLAMP
    )
    this.paint.shader = textShader
}

// Fast toast short
fun String?.toast(){
    Toast.makeText(SkillsApp.instance, this, Toast.LENGTH_SHORT).show()
}

// Fast toast long
fun String?.toastLong(){
    Toast.makeText(SkillsApp.instance, this, Toast.LENGTH_LONG).show()
}

// Default snackBar
// TODO: fix snackBar
//fun String?.snack(view: View){
//    if (this.isNullOrEmpty()){
//        return
//    }
//
//    Snackbar.make(
//        view,
//        this,
//        Snackbar.LENGTH_LONG).apply {
//
//        this.view.setBackgroundColor(view.context.color(R.color.blackTrans))
//
//        (this.view.findViewById(R.id.snackbar_text) as TextView).apply {
//            typeface = TypefaceUtils.bold
//            setTextColor(view.context.color(R.color.white))
//            setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f)
//        }
//
//    }.show()
//
////        .setAction("Action", null)
////    snackbar.setActionTextColor(Color.BLUE)
//
//}

// Always expanded bottom sheet dialog
fun BottomSheetDialog.setAlwaysExpanded(){
    this.setOnShowListener {
        val bottomSheet = this.findViewById<View>(R.id.design_bottom_sheet) as FrameLayout?
        val bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet!!)

        bottomSheetBehavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(p0: View, p1: Float) {}

            override fun onStateChanged(v: View, newState: Int) {
                if (newState == BottomSheetBehavior.STATE_DRAGGING) {
                    bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
                }
            }

        })
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
    }
}

fun BottomSheetDialog.setBackgroundBlack(){
    this.window!!.setBackgroundDrawable(ColorDrawable(context.color(R.color.blackTrans)))
}
