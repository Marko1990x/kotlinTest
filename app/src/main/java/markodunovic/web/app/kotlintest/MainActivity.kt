package markodunovic.web.app.kotlintest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import markodunovic.web.app.kotlintest.fragments.*

class MainActivity : AppCompatActivity() {
    private lateinit var txtView: TextView;
    private lateinit var toggle: ActionBarDrawerToggle
    private val fragment = TestFragment.newInstance();
    private val fragmentFirst = FragmentFirst.newInstance();
    private val fragmentSecond = FragmentSecond.newInstance();
    private val fragmentThird = FragmentThird.newInstance();
    private val fragmentFourth = FragmentFourth.newInstance();

    companion object{  // hate this tag
        private val TAG:String? = MainActivity::class.simpleName;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTestButton();
        setNavigationDrawer();
    }

    private fun setNavigationDrawer() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayout);
        val navView: NavigationView = findViewById(R.id.navView);
        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.fragment1 -> replaceFragment(fragmentFirst,"firstFragment")
                R.id.fragment2 -> replaceFragment(fragmentSecond,"secondFragment")
                R.id.fragment3 -> replaceFragment(fragmentThird,"thirdFragment")
                R.id.fragment4 -> replaceFragment(fragmentFourth,"fourthFragment")
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setTestButton() {
        txtView = findViewById<TextView>(R.id.textview1);
        txtView.setOnClickListener(View.OnClickListener {
            Log.d(TAG, "onCreate: ")
            //txtView.setText("i dun been clicked")
            replaceFragment(fragment,"test")
        })
    }

    private fun replaceFragment(fragment: Fragment,name: String){
        val fragTrans = supportFragmentManager.beginTransaction();
        fragTrans.replace(R.id.fragment_container,fragment)
            .addToBackStack(name)
        fragTrans.commit()
    }


}