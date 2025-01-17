package com.example.demoapp

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.demoapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    //https://klinq.com/rest/V1/productdetails/6701/253620?lang=en&store=KWD

lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getData()

        binding.btnNewMeme.setOnClickListener {
            getData()
        }
    }
    private fun getData() {

        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Please wait while data is fetch")
        progressDialog.show()

        RetrofitInstance.apiInterface.getData().enqueue(object : Callback<responceDataClass?> {
            override fun onResponse(
                call: Call<responceDataClass?>,
                response: Response<responceDataClass?>
            ) {

                binding.memeTitle.text=response.body()?.message
                binding.memeTitle1.text= response.body()?.status.toString()

                progressDialog.dismiss()
            }

            override fun onFailure(call: Call<responceDataClass?>, t: Throwable) {
                Toast.makeText(this@MainActivity,"${t.localizedMessage}",Toast.LENGTH_SHORT).show()
                progressDialog.dismiss()
            }
        })
    }
}