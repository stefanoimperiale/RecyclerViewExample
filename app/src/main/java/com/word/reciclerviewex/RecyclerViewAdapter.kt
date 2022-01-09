package com.word.reciclerviewex

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.word.reciclerviewex.databinding.ExampleItemBinding

class RecyclerViewAdapter(private val onDelete: (ExampleItem) -> Unit) :
    ListAdapter<ExampleItem, RecyclerViewAdapter.RecyclerViewHolder>(ExampleItemDiffCallback) {
    class RecyclerViewHolder(itemBinding: ExampleItemBinding, private val onDelete: (ExampleItem) -> Unit) :
        RecyclerView.ViewHolder(itemBinding.root) {

        private val titleString: TextView = itemBinding.titleString
        private val descriptionString: TextView = itemBinding.descriptionString
        private val deleteButton: ImageButton = itemBinding.deleteButton

        /* Bind league name and image. */
        fun bind(item: ExampleItem) {
            titleString.text = item.title
            descriptionString.text = item.description
            deleteButton.setOnClickListener { onDelete(item) }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding = ExampleItemBinding.inflate(layoutInflater, parent, false)
        return RecyclerViewHolder(itemBinding, onDelete)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val logs = getItem(position)
        holder.bind(logs)
    }

    object ExampleItemDiffCallback : DiffUtil.ItemCallback<ExampleItem>() {
        override fun areItemsTheSame(oldItem: ExampleItem, newItem: ExampleItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ExampleItem, newItem: ExampleItem): Boolean {
            return oldItem.id == newItem.id
        }

    }
}