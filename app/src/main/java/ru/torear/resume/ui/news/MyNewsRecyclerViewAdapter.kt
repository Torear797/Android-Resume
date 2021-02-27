package ru.torear.resume.ui.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.Group
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ru.torear.resume.R
import ru.torear.resume.models.News

class MyNewsRecyclerViewAdapter(
        private val values: List<News>,
        private val listener: OnNewsClickListener
) : RecyclerView.Adapter<MyNewsRecyclerViewAdapter.ViewHolder>() {

    interface OnNewsClickListener {
        fun onShareClick(news: News)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
                LayoutInflater.from(parent.context)
                        .inflate(R.layout.fragment_item_news, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.title.text = item.title
        holder.text.text = item.text
        holder.data.text = item.createDate
        Picasso.get().load(item.imgRes).placeholder(R.drawable.ic_baseline_image_search_24).noFade()
                .into(holder.image)
    }

    override fun onViewAttachedToWindow(holder: ViewHolder) {
        holder.btnArrow.setOnClickListener {
            if (holder.myGroup.visibility == View.VISIBLE) {
                holder.myGroup.visibility = View.GONE
                holder.btnArrow.animate().rotation(0F)
            } else {
                holder.myGroup.visibility = View.VISIBLE
                holder.btnArrow.animate().rotation(-180F)
            }
        }


        holder.btnShare.setOnClickListener {
            if (holder.adapterPosition != RecyclerView.NO_POSITION) {
                listener.onShareClick(values[holder.adapterPosition])
            }
        }
    }

    override fun onViewDetachedFromWindow(holder: ViewHolder) {
        deleteListener(holder.btnArrow)
        deleteListener(holder.btnShare)
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.n_title)
        val text: TextView = view.findViewById(R.id.n_text)
        val data: TextView = view.findViewById(R.id.n_create_date)
        val image: ImageView = view.findViewById(R.id.n_imageView)

        var btnShare: ImageButton = view.findViewById(R.id.n_btn_share)
        var btnArrow: ImageView = view.findViewById(R.id.n_arrow)
        var myGroup: Group = view.findViewById(R.id.MyGroup)
    }

    private fun deleteListener(view: View) {
        if (view.hasOnClickListeners()) {
            view.setOnClickListener(null)
        }

        if (view.onFocusChangeListener != null) {
            view.onFocusChangeListener = null
        }
    }
}