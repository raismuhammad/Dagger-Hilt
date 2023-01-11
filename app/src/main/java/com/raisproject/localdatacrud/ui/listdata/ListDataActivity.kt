package com.raisproject.localdatacrud.ui.listdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.raisproject.localdatacrud.R
import com.raisproject.localdatacrud.data.model.Data
import com.raisproject.localdatacrud.databinding.ActivityListDataBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class ListDataActivity : AppCompatActivity() {

    private val viewModel: ListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityListDataBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        viewModel.saveData(data)

        val dataAdapter = DataAdapter()

        binding.apply {
            rvListData.apply {
                adapter = dataAdapter
                layoutManager = LinearLayoutManager(this@ListDataActivity)
                setHasFixedSize(true)
            }
        }

        viewModel.getListData()

        lifecycleScope.launchWhenCreated {
            viewModel.dataListEvent.collect {
                Log.e("LOG", it.toString())
                viewModel.saveListData(it.data)
            }
        }

        lifecycleScope.launchWhenCreated {
            viewModel.dataEvent.collect {
                Log.e("TAG", it.toString())
            }
        }

        viewModel.getAllDataRepository().observe(this@ListDataActivity) {
            dataAdapter.submitList(it)
        }
    }
}