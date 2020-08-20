package com.poilkar.nehank.daggerhilt_demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.core.os.postDelayed
import com.poilkar.nehank.daggerhilt_demo.ui.MainActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed(3000){
            startActivity(Intent(this@SplashActivity,
                MainActivity::class.java))
            finish()
        }
    }
}