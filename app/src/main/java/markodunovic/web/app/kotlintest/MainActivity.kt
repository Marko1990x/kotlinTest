package markodunovic.web.app.kotlintest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.squareup.picasso.Picasso
import markodunovic.web.app.kotlintest.fragments.*

class MainActivity : AppCompatActivity() {
    private lateinit var txtView: TextView;
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var imageView: ImageView
    private val fragment = TestFragment.newInstance();
    private val fragmentFirst = FragmentFirst.newInstance();
    private val fragmentSecond = FragmentSecond.newInstance();
    private val fragmentThird = FragmentThird.newInstance();
    private val fragmentFourth = FragmentFourth.newInstance();
    private val fragmentBottomFirst = FragmentBottomFirst.newInstance()
    private val fragmentBottomSecond = FragmentBottomSecond.newInstance()
    private val fragmentBottomThird = FragmentBottomThird.newInstance()
    private lateinit var bottomNavigation: BottomNavigationView

    companion object{  // hate this tag
        private val TAG:String? = MainActivity::class.simpleName;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTestButton();
        setNavigationDrawer();
        setBackImage();
        bottomNavigation = findViewById(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.bottom1 -> replaceFragment(fragmentBottomFirst,"bottom1")
                R.id.bottom2 -> replaceFragment(fragmentBottomSecond,"bottom2")
                R.id.bottom3 -> replaceFragment(fragmentBottomThird, "bottom3")
            }
            true
        }
    }

    private fun setBackImage() {
        imageView = findViewById(R.id.imageView);
        val image:String = "https://github.com/Marko1990x/AppData/raw/main/moded/vertical/7.jpg";
        Picasso.get().load(image).fit().into(imageView)
    }

    private fun setNavigationDrawer() {  // nav drawer
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