package com.example.projet4a.Presentation.HomePage

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projet4a.Domain.Entity.Response
import com.example.projet4a.R
import com.squareup.picasso.Picasso
import java.lang.System.load

class RecyclerAdapter(
        private val apiResponses: MutableList<Response>?
) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.itemCity.text = apiResponses?.get(position)?.name ?:"Erreur"
        holder.itemDesc.text = apiResponses?.get(position)?.weather?.get(0)?.description?.capitalize()
            ?: "Erreur"
        holder.itemTemp.text = apiResponses?.get(position)?.main?.temp.toString() + "°C"
        var image_url = "http://openweathermap.org/img/wn/"+apiResponses?.get(position)?.weather?.get(0)?.icon.toString()+"@2x.png"
        Picasso.get().load(image_url).into(holder.itemImage)
    }

    override fun getItemCount(): Int {
        if (apiResponses != null) {
            return apiResponses.size
        }
        return 0
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var itemImage : ImageView
        var itemCity : TextView
        var itemDesc : TextView
        var itemTemp : TextView

        init {
            itemImage = itemView.findViewById(R.id.item_weather_image)
            itemCity = itemView.findViewById(R.id.item_city)
            itemDesc = itemView.findViewById(R.id.item_weather_description)
            itemTemp = itemView.findViewById(R.id.item_temp)
        }
    }
}