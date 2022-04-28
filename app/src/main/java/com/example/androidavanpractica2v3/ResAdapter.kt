package com.example.androidavanpractica2v3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidavanpractica2v3.databinding.ItemRestBinding
import com.squareup.picasso.Picasso


class ResAdapter(private val variable: List<DmRestaurantes>, private val context:Context, val onItemListener: OnItemListener) : RecyclerView.Adapter<ResAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResAdapter.ViewHolder {
        val LayoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemRestBinding.inflate(LayoutInflater)
        //item_rest es el nombre del layout donde esta la card del recycler view
        return ViewHolder(binding, onItemListener)
    }

    override fun onBindViewHolder(holder: ResAdapter.ViewHolder, position: Int) {
        // holder.bind(variable[position])
        holder.bindData(variable[position])

       /* holder.ivRestaurante.text = variable[position].Imagen
        holder.elpTvNombre.text = variable[position].Nombre_rest
        holder.elpRbCalificacion.text = variable[position].Calificacion
        holder.elpTvFundacion.text = variable[position].Fundacion
        holder.Costo.text = variable[position].Costo_Av*/
    }

    override fun getItemCount() = variable.size

    interface OnItemListener{
        fun clickRestaurante(variable : DmRestaurantes)
    }


    class ViewHolder(binding:ItemRestBinding,onItemListener: OnItemListener) : RecyclerView.ViewHolder(binding.root),  View.OnClickListener{
          private val binding = binding
          private val onItemListener = onItemListener
          private lateinit var variable : DmRestaurantes

          init{binding.root.setOnClickListener(this)}

          override fun onClick(p0: View?) { onItemListener.clickRestaurante(variable)}


        fun bindData(item: DmRestaurantes){
            val iv : ImageView = binding.ivRestaurante //Atencion experimento

            binding.Costo.text = item.Costo_Av
            binding.elpRbCalificacion.rating = item.Calificacion.toFloat()
            binding.elpTvFundacion.text = item.Fundacion
            binding.elpTvNombre.text = item.Nombre_rest
            binding.ivRestaurante.setImageResource(item.Imagen)
            /* val ivRestaurante: TextView = itemView.findViewById(R.id.ivRestaurante)
   val elpTvNombre: TextView = itemView.findViewById(R.id.elpTvNombre)
   val elpRbCalificacion: TextView = itemView.findViewById(R.id.elpRbCalificacion)
   val elpTvFundacion: TextView = itemView.findViewById(R.id.elpTvFundacion)
   val Costo: TextView = itemView.findViewById(R.id.Costo)*/
            variable = item
        }



    }

}
