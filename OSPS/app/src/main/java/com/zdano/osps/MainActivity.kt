package com.zdano.osps

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    private var word: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun checkWord(v : View){
        val task = BgTask()
        task.execute("Check")
    }
    fun doAnagrams(v : View){
        val task = BgTask()
        task.execute("Anagrams")
    }

    private inner class BgTask : AsyncTask<String, Int, String>(){
        override fun doInBackground(vararg p0: String?): String {
            if(word!=null){
                val w = word!!
                if(w.length > 1){
                    if(p0[0] == "Check"){
                        try{
                            val url = "http://wwww.pfs.org.pl/files/php/osps_funkcje2.php"
                            val response = khttp.get(
                                    url=url,
                                    params = mapOf("s" to "spr","slowo_arbiter2" to w))
                            val r = response.content[0].toInt()
                            if(r==49)
                                return "Słowo jest poprawne"
                            else
                                return "Słowo jest nie poprawne"
                        }
                        catch (e : Exception){
                            return e.message.toString()
                        }
                    }
                    else{
                        try{
                            val url = "http://wwww.pfs.org.pl/files/php/osps_funkcje2.php"
                            val response = khttp.get(
                                    url=url,
                                    params = mapOf("s" to "spr","slowo_arbiter2" to w))
                            val r = String(response.content)
                            val items = r.split("|")
                            val sb = StringBuilder()
                            for(i in items) if (i!=""){
                                sb.appendln(i)
                            }
                            return sb.toString()
                        }
                        catch(e : Exception){
                            return e.message.toString()
                        }
                    }
                }
                else {
                    return "Wprowadź słowo mające 2 lub więcej liter"
                }
            }
            return "Wprowadź słowo mające 2 lub więcej liter"
        }

        override fun onPreExecute() {
            super.onPreExecute()
            word = editWord.text.toString().trim()
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            txtResult.text = result
        }
    }
}
