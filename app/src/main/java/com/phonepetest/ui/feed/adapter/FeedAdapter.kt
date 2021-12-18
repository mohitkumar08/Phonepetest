package com.phonepetest.ui.feed.adapter

/**
 * @created 18/12/21}
 * @author Mohit Kumar
 *
 */

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.phonepetest.data.response.MovieModel
import com.phonepetest.databinding.FeedItemViewBinding


class FeedAdapter : RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {
    private var items: ArrayList<MovieModel> = arrayListOf()

    init {
        setHasStableIds(true)
    }

    fun addItems(newList: List<MovieModel>) {
        try {
            val l = items.size
            items.addAll(newList)
            notifyItemRangeInserted(l, newList.size)
        } catch (ex: Throwable) {
            ex.printStackTrace()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FeedViewHolder {

        val binding =
            FeedItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FeedViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size


    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemId(position: Int): Long {
        return items[position].id.toLong()
    }

    inner class FeedViewHolder(private val binding: FeedItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val context = binding.root.context

        fun bind(movieModel: MovieModel) {
            with(binding) {
                Glide.with(context)
                    .load(movieModel.getPlaceHolderImage())
                    .into(poster)
                name.text = movieModel.originalTitle
            }
        }
    }
}