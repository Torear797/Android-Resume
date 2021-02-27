package ru.torear.resume.ui.store

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.squareup.picasso.Picasso
import ru.torear.resume.R
import ru.torear.resume.models.StoreItems

class StoreAdapter(
        private var values: List<StoreItems>,
        private val listener: OnItemClickListener
) : RecyclerView.Adapter<StoreAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onBayClick(item: StoreItems)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.store_image)
        val vendor: TextView = view.findViewById(R.id.store_vendor)
        val title: TextView = view.findViewById(R.id.item_title)
        val price: TextView = view.findViewById(R.id.store_price)

        val card: MaterialCardView = view.findViewById(R.id.card_store)
    }

    override fun onViewAttachedToWindow(holder: ViewHolder) {
        holder.card.setOnClickListener {
            if (holder.adapterPosition != RecyclerView.NO_POSITION) {
                listener.onBayClick(values[holder.adapterPosition])
            }
        }
    }

    override fun onViewDetachedFromWindow(holder: ViewHolder) {
        deleteListener(holder.card)
    }

    private fun deleteListener(view: View) {
        if (view.hasOnClickListeners()) {
            view.setOnClickListener(null)
        }

        if (view.onFocusChangeListener != null) {
            view.onFocusChangeListener = null
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
                LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_store_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.vendor.text = item.vendor
        holder.title.text = item.title
        holder.price.text =
                String.format(holder.price.context.resources.getString(R.string.store_price), item.price)
        Picasso.get().load(item.imgRes).placeholder(R.drawable.ic_baseline_image_search_24).noFade()
                .into(holder.image)
    }

    override fun getItemCount(): Int = values.size

    fun update(modelList: MutableList<StoreItems>) {
        values = modelList
        notifyDataSetChanged()
    }
}