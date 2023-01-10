package com.raisproject.localdatacrud.ui.listdata

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.raisproject.localdatacrud.data.model.Data
import com.raisproject.localdatacrud.databinding.DataItemBinding

class DataAdapter: ListAdapter<Data, DataAdapter.DataViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val binding = DataItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    inner class DataViewHolder(private val binding: DataItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Data) {
            binding.apply {
                tvNik.text = data.nik.toString()
                tvNama.text = data.nama
                tvUmur.text = data.umur.toString()
                tvKota.text = data.kota
            }
        }
    }

    class DiffCallback: DiffUtil.ItemCallback<Data>() {

        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.nik == newItem.nik
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }
    }
}