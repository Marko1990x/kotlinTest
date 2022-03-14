package markodunovic.web.app.kotlintest.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import markodunovic.web.app.kotlintest.R

class FragmentSecond : Fragment() {
    private lateinit var txtName: TextView
    private var background: ImageView? = null
    private var asd:String = "Clicked";
    private var list:MutableList<String> = ArrayList();
    companion object {
        fun newInstance() = FragmentSecond();
        private val TAG:String? = FragmentSecond::class.simpleName;

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view:View = inflater.inflate(R.layout.fragment_second,container,false)
        setButtons(view)
        asd = "new String";
        list.add(asd);
        list.add("dsa")
        list.add("qqq")
        list.add("www")

        for (String in list){
            Log.d(TAG, "onCreate: "+String + " " + String.length)
        }
        Log.d(TAG, "functionAddTwoNumbers: " +addTwoNumbers(10,30.11))
        Log.d(TAG, "AddTwoStrings: " + stringConcatenation("Hello","World"))
        Log.d(TAG, "Multiply by two: " + multiply2(2))
        Log.d(TAG, "Multiply by three: " +multiplyBy3(4))
        Log.d(TAG, "ifMoreOrLess: " + ifMoreOrLess(5))
        Log.d(TAG, "ifMoreOrLess: " + ifMoreOrLess(15))
        Log.d(TAG, "boolean: " + boolean(19))
        Log.d(TAG, "boolean: " + boolean(20))
        Log.d(TAG, "loop: "+do_while(0))
        Log.d(TAG, "LoopAndRanges : "+loopingAndRanges())
        return view
    }

    fun loopingAndRanges (): String{
        for (i in 1..5){
            Log.d(TAG, "loopingAndRanges: loop $i");
        }

        val range = 1..5; // includes both bounds in the resulting range
        val range2 = 1 until 10; // excludes the end
        Log.d(TAG, "range1: $range")
        Log.d(TAG, "range2: $range2")

        val range3 = 40;
        Log.d(TAG, "Is number in range: "+ (range3 in 1 .. 1000).toString())

        val name:String = "Marko";
        val name2:String = "Pera";
        Log.d(TAG, "Name has char: " + ("ko" in name).toString())
        Log.d(TAG, "Name has char: " + ("ko" in name2).toString())

        return "Done";
    }

    fun do_while(p: Int) :String{
        var p1 = p
        while (condition(p1)){
            p1+= 10
            Log.d(TAG, "do_while: $p1")
        }
        return "Done with loop value $p1"
    }

    private fun condition(p1: Int) =  p1<100 // boolean check

    private fun boolean(p1:Int): String{
        var x: Boolean = p1 >= 20
        if(x){
            return "$x $p1 is greater then 20"
        }else{
            return "$x $p1 is less then 20"
        }
    }

    private fun ifMoreOrLess(p1: Int): String {
        if (p1 <= 10){
            return "$p1 is less then 10"
        }else if (p1 >= 10){
            return "$p1 is more then 10"
        }
        return "Error"
    }

    // function body example // cannon infer if type is omitted it will return unit type
    private fun multiply2 (p1:Int): Int{
        return p1*2;
    }

    // expression body example // kotlin infers the return type of expression body
    private fun multiplyBy3 (number: Int): Int = number *3;

    private fun stringConcatenation (p1 :String, p2: String): String{
        return p1+" "+p2;
    }

    private fun addTwoNumbers(var1:Int, var2:Double): Double{
        var asd =  var1+var2;
        return asd;
    }

    private fun setButtons(view: View) {
        txtName = view.findViewById(R.id.txt_name);
        background = view.findViewById(R.id.background);
        txtName.setText(FragmentSecond::class.simpleName);
        val link:String = "https://github.com/Marko1990x/AppData/raw/main/moded/vertical/3.jpg";
        Picasso.get().load(link).fit().into(background);
    }
}