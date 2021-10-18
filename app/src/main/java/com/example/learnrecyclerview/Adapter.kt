package com.example.learnrecyclerview

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val heroList : ArrayList<Hero>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = heroList[position]
        holder.heroImage.setImageResource(currentItem.heroImage)
        holder.heroName.text = currentItem.heroName
        holder.heroDates.text = currentItem.heroDates
        holder.heroDescription.text = currentItem.heroDescription
    }

    override fun getItemCount(): Int {
        return heroList.size
    }

    class ViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val heroImage : ImageView = itemView.findViewById(R.id.hero_image)
        val heroName : TextView = itemView.findViewById(R.id.hero_name)
        val heroDates : TextView = itemView.findViewById(R.id.hero_dates)
        val heroDescription : TextView = itemView.findViewById(R.id.hero_description)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }

        }
    }

}