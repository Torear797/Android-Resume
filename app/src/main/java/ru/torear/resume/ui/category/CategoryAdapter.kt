package ru.torear.resume.ui.category

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.squareup.picasso.Picasso
import ru.torear.resume.R
import ru.torear.resume.models.Category

class CategoryAdapter(
    private val values: List<Category>,
    private val listener: OnCategoryClickListener
) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    interface OnCategoryClickListener {
        fun onCategoryClick(cat: Category)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.cat_image)
        val vendor: TextView = view.findViewById(R.id.cat_vendor)

        val card: MaterialCardView = view.findViewById(R.id.card_category)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_category, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CategoryAdapter.ViewHolder, position: Int) {
        val item = values[position]
        holder.vendor.text = item.title
        Picasso.get().load(item.imgRes).placeholder(R.drawable.ic_baseline_image_search_24).noFade()
            .into(holder.image)
    }

    override fun onViewAttachedToWindow(holder: ViewHolder) {
        holder.card.setOnClickListener {
            if (holder.adapterPosition != RecyclerView.NO_POSITION) {
                listener.onCategoryClick(values[holder.adapterPosition])
            }
        }
    }

    override fun onViewDetachedFromWindow(holder: ViewHolder) {
        deleteListener(holder.card)
    }

    override fun getItemCount(): Int = values.size

    private fun deleteListener(view: View) {
        if (view.hasOnClickListeners()) {
            view.setOnClickListener(null)
        }

        if (view.onFocusChangeListener != null) {
            view.onFocusChangeListener = null
        }
    }

}