package markodunovic.web.app.kotlintest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import markodunovic.web.app.kotlintest.fragments.FirstImageFragment

class MainActivity : AppCompatActivity() {
    private lateinit var txtView: TextView;

    companion object{  // hate this tag
        private val TAG:String? = MainActivity::class.simpleName;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragment = FirstImageFragment.newInstance();
        txtView = findViewById<TextView>(R.id.textview1);
        txtView.setOnClickListener(View.OnClickListener {
            Log.d(TAG, "onCreate: ")
            //txtView.setText("i dun been clicked")
            replaceFragment(fragment)
        })
    }

    private fun replaceFragment(fragment: Fragment){
        val fragTrans = supportFragmentManager.beginTransaction();
        fragTrans.replace(R.id.fragment_container,fragment)
        fragTrans.commit()
    }


}