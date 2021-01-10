package com.jkhome.dicpublicapi

import android.Manifest
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.jkhome.dicpublicapi.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val permissions = arrayOf(Manifest.permission.INTERNET)
        ActivityCompat.requestPermissions(this, permissions, 0)

        binding.wordEditText.setText("apple")
        findViewById<EditText>(R.id.word_edit_text).setText("orange");
        val findButton = findViewById<Button>(R.id.find_button)

        findButton.setOnClickListener {

            Toast.makeText(this, "Click", Toast.LENGTH_SHORT).show()
            val word:String = findViewById<EditText>(R.id.word_edit_text).text.toString()

            val appID = "d99a50c0"
            val apiKey = "3cd1e411d7bd942bc7df2d4950f53f08"
            val url:String = "https://od-api.oxforddictionaries.com:443/api/v2/entries/en-gb/$word"

            val request: StringRequest = object : StringRequest(
                Method.GET, url,
                Response.Listener { response ->
                    if (response != null) {
                        Log.e("Your Array Response", response)
                    } else {
                        Log.e("Your Array Response", "Data Null")
                    }
                },
                Response.ErrorListener {
                        error -> Log.e("error is ", "" + error)
                })
            //this is class content
            {

                //sample from java
//                    HttpsURLConnection urlConnection=(HttpsURLConnection) url.openConnection();
//                    urlConnection.setRequestProperty("Accept", "application/json");
//                    urlConnection.setRequestProperty("app_id", app_id);
//                    urlConnection.setRequestProperty("app_key", app_key);

                //This is for Headers If You Needed
                @Throws(AuthFailureError::class)
                override fun getHeaders(): Map<String, String> {
                    val params: MutableMap<String, String> = HashMap()
                    //params["Content-Type"] = "application/json; charset=UTF-8"
                    params["Accept"] = "application/json"
                    params["app_id"] = appID
                    params["app_key"] = apiKey
                    return params
                }

                //Pass Your Parameters here
//                override fun getParams(): Map<String, String> {
//                    val params: MutableMap<String, String> = HashMap()
//                    return params
//                }
            }
//            val stringRequest = StringRequest(
//                Request.Method.GET,
//                url,
//                Response.Listener { response ->
//                    response
//                },
//                Response.ErrorListener { error ->
//                    error
//                })
            val queue = Volley.newRequestQueue(this)
            queue.add(request)
        }
    }
}