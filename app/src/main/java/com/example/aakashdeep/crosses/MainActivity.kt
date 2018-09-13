package com.example.aakashdeep.crosses

import android.app.FragmentTransaction
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_play.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, PlayFragment.OnFragmentUserPlayListener {

    private val TAG:String ="ak_mainact"
    private lateinit var drawableLayout: DrawerLayout
    private lateinit var frameLayout: FrameLayout
    private lateinit var  drawerToggle:ActionBarDrawerToggle
    //private lateinit var  txtview: TextView
    private lateinit var aboutFragment:AboutFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //txtview = findViewById(R.id.textview)
        drawableLayout = findViewById(R.id.drawerLayout)
        frameLayout = findViewById(R.id.frameLayout)

        drawerToggle = ActionBarDrawerToggle(this, drawableLayout, R.string.open, R.string.close)

        drawableLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        nav_view.setNavigationItemSelectedListener(this)
        aboutFragment = AboutFragment()
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
                Log.d(TAG,"Play clicked")
                showPlayFragment();
            }
            R.id.about -> {
                Log.d(TAG,"about clicked")
                showAboutFragment()
            }
        }
        drawableLayout.closeDrawer(GravityCompat.START)
        return true
    }

    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        //fun onFragmentInteraction(uri: Uri)
    }

    fun showAboutFragment(){
        welcomeTextView.visibility = View.GONE
        val transaction = supportFragmentManager.beginTransaction()
        val fragment = AboutFragment()
        transaction.replace(R.id.frameLayout, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun showPlayFragment(){
        welcomeTextView.visibility = View.GONE
        val transaction = supportFragmentManager.beginTransaction()
        val fragment = PlayFragment()
        transaction.replace(R.id.frameLayout, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun onSubmitButtonClick(view: View){

        if(!user1EditText.text.isEmpty() && !user2EditText.text.isEmpty()){

            textView.visibility = View.GONE
            textView2.visibility = View.GONE
            user1EditText.visibility = View.GONE
            user2EditText.visibility = View.GONE
            submitButton.visibility = View.GONE

            tableLayout.visibility = View.VISIBLE
        }

    }

    override fun onUserPlay(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
