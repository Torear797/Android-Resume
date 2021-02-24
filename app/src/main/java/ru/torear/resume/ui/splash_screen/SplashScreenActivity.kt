package ru.torear.resume.splash_screen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.torear.resume.App
import ru.torear.resume.Role
import ru.torear.resume.User
import ru.torear.resume.ui.menu.MenuActivity

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val role: List<Role> = listOf(Role(1, "admin", "Android разработчик"))
        val region: Map<Int, String> = mapOf(1 to "Белгород")

        App.user = User(797, "Артём", "Клыч", "", "8-915-***-**-**","email@ya.ru", role, region, "24-02-2021")

        startActivity(Intent(this, MenuActivity::class.java))
        finish()
    }

}