package com.example.projet4a.Presentation.HomePage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projet4a.Domain.Entity.Response
import com.example.projet4a.R
import kotlinx.android.synthetic.main.activity_home_page.*
import kotlinx.coroutines.delay
import org.koin.android.ext.android.inject
import java.util.Observer

class HomePageActivity : AppCompatActivity() {

    val homepageViewModel : HomePageViewModel by inject()

    private var layoutManager : RecyclerView.LayoutManager? = null
    private var adapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        homepageViewModel.makeApiCall()

        var flag : Boolean = false

        homepageViewModel.flag.observe(this, androidx.lifecycle.Observer {
            when(it){
                is FlagTrue -> { layoutManager = LinearLayoutManager(this@HomePageActivity)
                                recycler_view.layoutManager = layoutManager

                                adapter = RecyclerAdapter(homepageViewModel.weather.value)
                                recycler_view.adapter = adapter
                }
                FlagFalse -> { flag = false }
            }
        })
    }
}
