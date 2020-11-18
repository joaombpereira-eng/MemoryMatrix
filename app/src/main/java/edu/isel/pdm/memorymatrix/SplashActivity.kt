package edu.isel.pdm.memorymatrix

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.isel.pdm.memorymatrix.game.GameActivity
import edu.isel.pdm.memorymatrix.utils.BaseActivity
import edu.isel.pdm.memorymatrix.utils.runDelayed


class SplashViewModel : ViewModel() {

    val scheduledComplete: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>(false)
    }

    private var isSchedule = false

    fun scheduleTransition(millis: Long) {
        if (!isSchedule) {
            isSchedule = true
            runDelayed(millis) {
                scheduledComplete.value = true
            }
        }
    }
}

/**
 * Splash screen displayed when the application starts
 */
class SplashActivity : BaseActivity() {

    private val contentView by lazy { findViewById<View>(R.id.root) }
    private val viewModel: SplashViewModel by viewModels()

    private fun navigateToGameActivity() {
        startActivity(Intent(this, GameActivity::class.java))
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        contentView.setOnClickListener {
            navigateToGameActivity()
        }

        viewModel.scheduledComplete.observe(this) { shouldNavigate ->
            if (shouldNavigate)
                navigateToGameActivity()
        }

        viewModel.scheduleTransition(5000)
    }
}