package ru.torear.resume

import android.app.Application
import androidx.fragment.app.FragmentActivity
import com.orhanobut.hawk.Hawk

class App : Application() {

    companion object {
        lateinit var user: User

        fun logout(activity: FragmentActivity) {
            activity.finish()
        }
    }

    override fun onCreate() {
        super.onCreate()
        Hawk.init(this).build()
    }

}