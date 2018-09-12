package com.example.aakashdeep.crosses

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.util.Log
import android.view.MenuItem
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private val TAG:String ="ak_mainact"
    private lateinit var drawableLayout: DrawerLayout
    private lateinit var  drawerToggle:ActionBarDrawerToggle
    private lateinit var  txtview: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtview = findViewById(R.id.textview)
        drawableLayout = findViewById(R.id.drawerLayout)
        drawerToggle = ActionBarDrawerToggle(this, drawableLayout, R.string.open, R.string.close)

        drawableLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        nav_view.setNavigationItemSelectedListener(this)

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if(drawerToggle.onOptionsItemSelected(item)){
            Log.d(TAG,"Play clicked"+item)

            return true
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.play -> {
                // Handle the camera action
               // textview.append="play"
                Log.d(TAG,"Play clicked")
                txtview.text = "play"
            }
            R.id.about -> {
                Log.d(TAG,"about clicked")
                txtview.text = "about"
            }
        }

        return true
    }
}
